/*******************************************************************
 Author: Josh Hickman
 PawPrint: hickmanjv
 Assignment: Programming Assignment 2
    - Create a red-black tree with various functions based on the
      data of the tree. Everything is contained in this one .c file
 ******************************************************************/

#include <stdio.h>
#include <stdlib.h>
#define RED 'R'
#define BLACK 'B'

typedef struct Node{
    
    int key;
    char color;
    
    struct Node *left;
    struct Node *right;
    struct Node *parent;
    
}Node;

// Create dummy Sentinel Nodes to represent empty BLACK nodes
struct Node Sentinel_Nil_Node;
Node* Sentinel_Nil = &Sentinel_Nil_Node;

/*************************************
 Function Prototypes
*************************************/

Node* createNode(int);
void insertNode(Node**, int);
void rotateLeft(Node**, Node*);
void rotateRight(Node**, Node*);
void redBlackFix(Node**, Node*);
void printPreorder(Node*);
void printInorder(Node*);
void freeTree(Node*);
int treeHeight(Node*, int, int);
int blackHeight(Node*);
Node* OS_Select(Node*, int);
int size(Node*);

int main(){
    
    Node* root = Sentinel_Nil;
    Node* secondLargest = NULL;
    
    int bHeight = 0, key = 0, height = 0, level = 0, count = 0;
    
    while(1)
    {
        printf("Please type in a number to insert into the red-black tree: ");
        
        if(scanf("%d", &key))
        {
            insertNode(&root, key);
            count++;
        }
        else
        {
            break;
        }
    }
    
    
    printf("\nInorder List of Red-Black Tree Nodes is: ");
    printInorder(root);
    
    bHeight = blackHeight(root);
    printf("\n\nThe black height of the tree is: %d\n\n", bHeight);
    
    height = treeHeight(root, level, height);
    printf("The height of the tree is: %d\n\n", height);
    
    secondLargest = OS_Select(root, (count - 1));
    printf("The 2nd largest key value in the tree is %d\n\n", secondLargest->key);
    
    freeTree(root);
    
    return 0;
}

/********************************************************
 Function to create a new node to be inserted into the 
 red-black tree with defaulted values. Error checks if
 there is an error with created space for the node.
 *******************************************************/
Node* createNode(int key){
    
    Node *newNode = (Node*)malloc(sizeof(Node));
    
    if(newNode == NULL){
        perror("Error! A new node could not be created.");
        exit(EXIT_FAILURE);
    }
    
    newNode->key = key;
    newNode->color = RED;
    newNode->left = Sentinel_Nil;
    newNode->right = Sentinel_Nil;
    newNode->parent = Sentinel_Nil;
   
    return newNode;
}

/***************************************************************
 This function relies on createNode() function and once created,
 will insert that node in the proper order to the tree. Calls
 redBlackFix() to ensure red black tree properties
 ***************************************************************/
void insertNode(Node **root, int key){
    
    Node *y = Sentinel_Nil;
    Node *x = (*root);
    Node *z = createNode(key);

    while(x != Sentinel_Nil)
    {
        y = x;
            
        if(z->key < x->key)
        {
            x = x->left;
        }
        else
        {
            x = x->right;
        }
    }
        
    z->parent = y;
        
    if(y == Sentinel_Nil)
    {
        *root = z;
    }
    else if(z->key < y->key)
    {
        y->left = z;
    }
    else
    {
        y->right = z;
    }
        
    z->color = RED;
    z->left = Sentinel_Nil;
    z->right = Sentinel_Nil;
        
    redBlackFix(root, z);
}

/*********************************************************
 Handles the left direction rotations of nodes in tree
 *********************************************************/
void rotateLeft(Node **root, Node *x){
    
    // Since rotating left, y needs to be on the right of x
    Node *y = x->right;
    
    // 
    x->right = y->left;
    
    if(y->left != Sentinel_Nil)
    {
        y->left->parent = x;
    }
    
    y->parent = x->parent;
    
    if(x->parent == Sentinel_Nil)
    {
        *root = y;
    }
    else if(x == x->parent->left)
    {
        x->parent->left = y;
    }
    else
    {
        x->parent->right = y;
    }
    
    y->left = x;
    
    x->parent = y;
}

/*********************************************************
 Handles the right direction rotations of nodes in tree
 *********************************************************/
void rotateRight(Node **root, Node *y){
    
    Node *x = y->left;
    
    y->left = x->right;
    
    if(x->right != Sentinel_Nil)
    {    
        x->right->parent = y;
    }
    
    x->parent = y->parent;
    
    if(y->parent == Sentinel_Nil)
    {
        *root = x;
    }
    else if(y == y->parent->right)
    {
        y->parent->right = x;
    }
    else
    {
        y->parent->left = x;
    }
    
    x->right = y;
    y->parent = x;
    
}

/***********************************************************************
 * WARNING - This function works on a lot of cases for adjustment in
 * the tree, however their exists the double rotate case that currently
 * fails.
 
 This function updates the red black tree to maintain balance and the
 different properties required to have a red black tree.
 
 - Help with this function came from GeeksForGeeks
 C Program for Red Black Tree Insertion
 https://www.geeksforgeeks.org/c-program-red-black-tree-insertion
************************************************************************/
void redBlackFix(Node **root, Node *z){
    
  
    while ((z != *root) && (z->color != BLACK) && (z->parent->color == RED)) 
    { 
        /*  Case : A 
            Parent of pt is left child of Grand-parent of pt */
        if (z->parent == z->parent->parent->left) 
        { 
            /* Case : 1 
               The uncle of pt is also red 
               Only Recoloring required */
            if (z->parent->parent->right != Sentinel_Nil && z->parent->parent->right->color == RED) 
            { 
                z->parent->parent->color = RED; 
                z->parent->color = BLACK; 
                z->parent->parent->right->color = BLACK; 
                z = z->parent->parent; 
            }
            else
            { 
                /* Case : 2 
                   pt is right child of its parent 
                   Left-rotation required */
                if (z == z->parent->right) 
                { 
                    rotateLeft(root, z->parent); 
                    z = z->parent; 
                    z->parent = z->parent; 
                } 
  
                // This is where there will be an error occurring if this second rotate is needed
                /* Case : 3 
                   pt is left child of its parent 
                   Right-rotation required */
                rotateRight(root, z->parent->parent); 
                
                //swap colors
                char ch = z->parent->color ;
                z->parent->color = z->parent->parent->color;
                z->parent->parent->color = ch;
                
                z = z->parent; 
            } 
        }            
        else  /* Case : B - Parent of pt is right child of Grand-parent of pt */
        {  
            /*  Case : 1 
                The uncle of pt is also red 
                Only Recoloring required */
            if ((z->parent->parent->left != Sentinel_Nil) && (z->parent->parent->left->color == RED)) 
            { 
                z->parent->parent->color = RED; 
                z->parent->color = BLACK; 
                z->parent->parent->left->color = BLACK; 
                z = z->parent->parent; 
            } 
            else
            { 
                /* Case : 2 
                   pt is left child of its parent 
                   Right-rotation required */
                if (z == z->parent->left) 
                { 
                    rotateRight(root, z->parent); 
                    z = z->parent; 
                    z->parent = z->parent; 
                }
                
                // This is where there will be an error occurring if this second rotate is needed
                /* Case : 3 
                   pt is right child of its parent 
                   Left-rotation required */
                rotateLeft(root, z->parent->parent); 
                
                //swap colors
                char ch = z->parent->color ;
                z->parent->color = z->parent->parent->color;
                z->parent->parent->color = ch;
                
                z = z->parent; 
            } 
        } 
    } 
  
    root[0]->color = BLACK; 
}

/*************************************************
 Prints the tree in preorder, not needed but
 no use getting rid of a perfectly good function
 *************************************************/
void printPreorder(Node *root){
    
    if(root == NULL)
    {
        return;
    }
    
    if(root->key != 0)
    {
        printf("%d-%c ", root->key, root->color);
    }
    
    printPreorder(root->left);
    printPreorder(root->right);
}

/**************************************************
 Prints the tree to the screen inorder, which is
 smallest key node to largest key node
 **************************************************/
void printInorder(Node *root){
    
    if(root == NULL)
    {
        return;
    }
    
    printInorder(root->left);
    
    if(root->key != 0)
    {
        printf("%d-%c ", root->key, root->color);
    }
    
    printInorder(root->right);
}

/*****************************************************
 will return the 'black' height of the red-black tree
 ie. the number of black nodes down any given branch
 pathway
 *****************************************************/
int blackHeight(Node *root){
    
    int blackHeight = 0;
    
    while(root != NULL){
        
        if(root == Sentinel_Nil || root->color == 'B')
        {
            blackHeight++;
        }
        
        root = root->left;
    }
    
    return blackHeight;
    
}

/***************************************************
 returns the total height of the tree
 **************************************************/
int treeHeight(Node *root, int level, int height){
    
    if(root)
    {
        if(level>height)
        {
            height = level;
        }
            
        height = treeHeight(root->left, level + 1, height);
        height = treeHeight(root->right, level + 1, height);
    }
    
    return height;
}

/***********************************************************
 will return the 'nth' largest node given to this function
 - relies on size() function
 ***********************************************************/
Node* OS_Select(Node *root, int n){
    
    int r = (size(root->left) + 1);
    
    if(n == r)
    {
        return root;
    }
    else if(n < r)
    {
        return OS_Select(root->left, n);
    }
    else 
    {
        return OS_Select(root->right, n-r);
    }
}

/*****************************************************
 returns the size of the node given to the function
 *****************************************************/
int size(Node* root){
    
    if(root == Sentinel_Nil)
    {
        return 0;
    }
    else
    {
        return(size(root->left) + 1 + size(root->right));
    }
    
}   

/******************************************************
 Function that will free all malloc'd space for nodes
 *****************************************************/
void freeTree(Node *root){
    
    if(root != Sentinel_Nil){
        freeTree(root->left);
        freeTree(root->right);
        free(root);
        
        root = NULL;
    }
}
