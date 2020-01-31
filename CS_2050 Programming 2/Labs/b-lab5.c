/* ---------------------------------------------------
Student: Josh Hickman - hickmanjv
Student ID: 10236503
Assignment: Lab 5
    Program to take inputs from a file and create
    a linked list of the inputs. Then delete nodes
    from from the list based on user input.
--------------------------------------------------- */

#include <stdio.h>
#include <stdlib.h>

typedef struct n_
{
    int x;
    int y;
    struct n_* nextNode;
}Node, *NodePtr;

/* ====================
Function Prototypes
==================== */

Node* importList(char*);
Node* removeNodes(Node*, int);
void printList(Node*);
void freeList(Node*);

/* =============================================================
Function: main()
    Checks for command line arguments, utilizes functions to 
    import the values from a file, requests user input while 
    error checking. Calls function to delete nodes at users
    choice. Finally cleaning up the malloc'd space and freeing 
    all nodes left over.
============================================================= */

int main(int argc, char **argv)
{
    if(argc != 2)
    {
        puts("Invalid number of command line arguements!");
        puts("<./a.out> <input file>");
        return 1;
    }
    
    int value = 0;
    NodePtr startPtr = NULL;

    startPtr = importList(argv[1]);
    
    printList(startPtr);

    printf("Enter an x value (-1 to exit): ");
        scanf("%d", &value);

        if(-1 == value)
        {
            freeList(startPtr);
            return -1;
        }

        while(value != -1)
        {
            startPtr = removeNodes(startPtr, value);
            printList(startPtr);
            printf("Enter an x value (-1 to exit): ");
                scanf("%d", &value);

            if(value == -1)
            {
                freeList(startPtr);
                return 2;
            }
        }

    return 0;
}

/* ========================================================
Function: importList()
    A function that opens an input file and reads through
    all of the data, loading it into nodes to be used in 
    a linked list. Also mallocs space for each node as it
    creates them.
======================================================== */
Node* importList(char* inputFile)
{
    FILE *inFile = fopen(inputFile, "r");
    NodePtr startNode = NULL;
    NodePtr currentPtr;
    NodePtr newPtr;
    
        if(inFile == NULL)
        {
            perror("file could not be opened...");
            exit (1);
        }

     int x, y;

    while(fscanf(inFile, "%d %d", &x, &y) == 2)
    {
       newPtr  = malloc(sizeof(Node));

       if(newPtr != NULL)
       {
           newPtr->x = x;
           newPtr->y = y;
           newPtr->nextNode = NULL;

           currentPtr = startNode;

           if(startNode == NULL)
           {
               startNode = newPtr;
           }
           else
           {
               while(currentPtr->nextNode != NULL)
               {
                   currentPtr = currentPtr->nextNode;
               }

               currentPtr->nextNode = newPtr;
           }
        }
    }

    fclose(inFile);
    return startNode;
}



/* ========================================================
Function: printList()
    A function that that will print the x and y values of
    each struct node in the linked list with appropriate
    formatting.
======================================================== */
void printList(Node* startPtr)
{
    NodePtr tempPtr = startPtr;

    while(tempPtr != NULL)
    {
        printf("(%d,%d) -> ", tempPtr->x, tempPtr->y);
        
        tempPtr = tempPtr->nextNode;
    }

    puts("NULL");
}



/* ========================================================
Function: freeList()
    A function that will free every single node that has
    space malloc'd in the program in linear order from
    beginning to end.
======================================================== */
void freeList(Node* startPtr)
{
    NodePtr temp;

    while(startPtr != NULL)
    {
        temp = startPtr;
        startPtr = startPtr->nextNode;
        free(temp);
    }
}



/* ===========================================================
Function: removeNodes()
    A function that will take the value provided by the user
    and delete any node that has the same x value as the
    number provided by the user and maintain the linked list.
=========================================================== */
Node* removeNodes(Node* startPtr, int val)
{
    NodePtr temp = NULL;
    NodePtr current = NULL;

    while(startPtr->x == val)  // if first node
    {
        temp = startPtr;
        startPtr = startPtr->nextNode;
        free(temp);
    }

    for(current = startPtr; current != NULL; current = current->nextNode)
    {
        // while loop for multiple nodes with same value
        while(current->nextNode != NULL && current->nextNode->x == val)
        {
            temp = current->nextNode;
            current->nextNode = temp->nextNode;
            free(temp);
        }
    }

    return startPtr;
}
