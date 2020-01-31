/* -----------------------------------------------------
Student: Josh Hickman - hickmanjv
Student ID: 10236503
Assignment: Pre Lab 7
    - A Program that takes in information from a file
    and creates a binary tree of the information and 
    prints in different orders
----------------------------------------------------- */

#include <stdio.h>
#include <stdlib.h>

/* ==============================
Struct data type declaration
============================== */
typedef struct Node
{
    int x;
    int y;
    struct Node *left;
    struct Node *right;
}Node;

/* =============================
Function Prototypes
============================= */
Node* import_tree(char*);
Node* add_node(Node*, Node*);
void inorder(Node*);
void preorder(Node*);
void free_tree(Node*);
Node* delete_node(Node*, int);
Node* min(Node*);

/* ==========================================================
Function: main()
    - A function


========================================================== */
int main(int argc, char **argv)
{
    if(argc != 2)
    {
        puts("Invalid command line arguements");
        puts("<a.out> <input filename>");
        return 1;
    }

    int x = 0;
    Node *root = NULL;

    root = import_tree(argv[1]);
    
    preorder(root);
    puts("\n");
    inorder(root);
    puts("\n");

    printf("Please enter an x value to be deleted from the tree. The number must be greater than zero: ");
        scanf("%d", &x);

        while(x <= 0)
        {
            printf("\nPlease enter an x value to be deleted from the tree. The number must be greater than zero: ");
                scanf("%d", &x);
        }

    root = delete_node(root, x);

    printf("\nWould you like to delete another node? Enter -1 to quit: ");
        scanf("%d", &x);

        while(x != -1)
        {
            printf("\nPlease enter an x value to be deleted from the tree. The number must be greater than zero: ");
                scanf("%d", &x);

                while(x <= 0)
                {
                    printf("\nPlease enter an x value to be deleted from the tree. The number must be greater than zero: ");
                        scanf("%d", &x);
                }

            root = delete_node(root, x);

            printf("\nWould you like to delete another node? Enter -1 to quit: ");
                scanf("%d", &x);
        }

    puts("\nPOST DELETION INORDER");
    inorder(root);

    puts("\n");
    
    puts("POST DELETION PREORDER");
    preorder(root);

    puts("\n");

    free_tree(root);

    return 0;
}

Node* import_tree(char* inputFile)
{
    FILE* inFile = fopen(inputFile, "r");

    if(inFile == NULL)
    {
        perror("Input file could not be opened\n");
        exit(1);
    }

    Node *root = NULL;

    while(!feof(inFile))
    {
        Node *newNode = NULL;
        newNode = malloc(sizeof(Node));
            newNode->left = NULL;
            newNode->right = NULL;

            if(newNode == NULL)
            {
                perror("Failed to create a new node\n");
                exit(1);
            }

        fscanf(inFile, "%d%d", &(newNode->x), &(newNode->y));
        root = add_node(root, newNode);
    }

    fclose(inFile);

    return root;
}

Node* add_node(Node* root, Node* newNode)
{
    if(root == NULL)
    {
        root = newNode;
        return root;
    }

    if((newNode->x) < (root->x))
    {
        if(root->left == NULL)
        {
            root->left = newNode;
        }
        else
        {
            root->left = add_node(root->left, newNode);
        }
    }
    else if((newNode->x) > (root->x))
    {
        if(root->right == NULL)
        {
            root->right = newNode;
        }
        else
        {
            root->right = add_node(root->right, newNode);
        }
    }

    return root;
}

void preorder(Node* root)
{
    if(root != NULL)
    {
        printf("(%d, %d) -> ", root->x, root->y);
        preorder(root->left);
        preorder(root->right);
    }
}

void inorder(Node* root)
{
    if(root != NULL)
    {
        inorder(root->left);
        printf("(%d, %d) -> ", root->x, root->y);
        inorder(root->right);
    }
}

void free_tree(Node* root)
{
    if(root != NULL)
    {
        free_tree(root->left);
        free_tree(root->right);
        free(root);
        root = NULL;
    }
}

Node* delete_node(Node* root, int val)
{
    if(root == NULL)
    {
        return root;
    }
    
    if(val < root->x)
    {
        root->left = delete_node(root->left, val);
    }
    else if(val > root->x)
    {
        root->right = delete_node(root->right, val);
    }
    else
    {
        if(root->left == NULL && root->right == NULL)
        {
            free(root);
            root = NULL;
        }
        else if(root->left == NULL)
        {
            Node *temp = root;
            root = root->right;
            free(temp);
        }
        else if(root->right == NULL)
        {
            Node *temp = root;
            root = root->left;
            free(temp);
        }
        else
        {
            Node *temp = min(root->right);

            root->x = temp->x;
            root->y = temp->y;

            root->right = delete_node(root->right, temp->x);
        }
    }

    return root;
}

Node* min(Node* root)
{
    Node* temp = root;

    while(temp->left != NULL)
    {
        temp = temp->left;
    }

    return temp;
}
