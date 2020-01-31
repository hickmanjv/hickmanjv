/* -----------------------------------------------------------------------
Student: Josh Hickman - hickmanjv
Student ID: 10236503
Assignment: Homework 2
    homework2.c - A program to read bank account information into a 
    linked list of structs and then update the information from another
    file. Various operations on the linked list, such as insertion and 
    deletion occur. After all totals are updated, negative accounts are
    deleted and the rest of the information is written to an output file.
----------------------------------------------------------------------- */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/* =========================
Struct Type Definition
========================= */
typedef struct struct_bank
{
    int accn_num;
    char *name;
    float amount;
    struct struct_bank *next;
}bank, *bankPtr;


/* =========================
Function Prototypes
========================= */
bank* create_node(char*, int, float);
bank* insert_node(bank*, bank*);
bank* build_list(char*);
bank* update_list(bank*, char*);
bank* delete_node(bank*);
int check_list(bank*, char*, int, float);
int write_output(bank*, char*);
void print_list(bank*);
void freeMem(bank*);


/* ===================================================================
Function: main()
    - A function that will check to ensure command line arguments
    are correct before proceeding, then will call functions to build
    a linked list then print the list, update the linked list then
    print the list, delete any nodes that have negative account
    balances then print the list, writing the update list to an
    output file and finally freeing up dynamically allocated
    memory used throught the program
=================================================================== */
int main(int argc, char **argv)
{
    if(4 != argc)
    {
        puts("Invalid number of command line arguments!");
        puts("<a.out> <input file> <update file> <output file>");
        return 1;
    }

    bankPtr startNode = NULL;
    int value = -2;

    startNode = build_list(argv[1]);
    
    puts("\nCreated Linked List");
    print_list(startNode);
    puts("\n");

    startNode = update_list(startNode, argv[2]);

    puts("\nList after update");
    print_list(startNode);
    puts("\n");

    startNode = delete_node(startNode);

    puts("\nList after deletion");
    print_list(startNode);
    puts("\n");

    value = write_output(startNode, argv[3]);
    
        if(value != 1)
        {
            puts("Error writing list to file");
        }
        
    freeMem(startNode);

    return 0;
}

/* ===============================================================
Function: create_node()
    - A function that takes in members of a struct to create a
    node to be used for insertion into a linked list
=============================================================== */
bank* create_node(char* n, int acct , float amnt)
{
    bankPtr tempPtr = malloc(sizeof(bank));
    
        if(tempPtr == NULL)
        {
            perror("Could not allocate space for node");
            exit(1);
        }
   
    tempPtr->name = n;
    tempPtr->accn_num = acct;
    tempPtr->amount = amnt;
    tempPtr->next = NULL;

    return tempPtr;
}

/* ================================================================
Function: insert_node()
    - A function that takes in a pointer to the start of a linked
    list and a pointer to a created node, inserting the created
    node at the end of the list
================================================================ */
bank* insert_node(bank* startPtr, bank* nodePtr)
{
    bankPtr currentPtr = startPtr;

    if(startPtr->next == NULL)
    {
        startPtr->next = nodePtr;
    }
    else
    {
        while(currentPtr->next != NULL)
        {
            currentPtr = currentPtr->next;
        }

        currentPtr->next = nodePtr;
    }

    return startPtr;
}

/*==========================================================================
Function: build_list()
    - A function to build a linked list of bank accounts from information
    provided by an inpute file. Has logic to create the start node
    if it would be the first one in the list. Utilizes the 
    create_node() and insert_node() functions inside itself
========================================================================== */
bank* build_list(char* inputFile)
{
    FILE* inFile = fopen(inputFile, "r");       

        if(inFile == NULL)                    
        {
            perror("Error opening input file");
            exit(1);
        }

    int num = 0, acct = 0;                      
    float amnt = 0.0;
    char* name = NULL;

    bankPtr startPtr = NULL;      
    bankPtr tempPtr = NULL;

    fscanf(inFile, "%d", &num);         

    for(int i = 0; i < num; i++)           
    {   
        if(i == 0)
        {   
            name = malloc(sizeof(char)*10);   

                if(name == NULL)            
                {
                    perror("Space could not be created for name");
                    exit(1);
                }

            fscanf(inFile, "%d%s%f", &acct, name, &amnt);   
            startPtr = create_node(name, acct, amnt);    
            tempPtr = startPtr->next;    
        }
        else
        {   
            name = malloc(sizeof(char)*10);    
            
                if(name == NULL)         
                {
                    perror("Space could not be created for name");
                    exit(1);
                }

            fscanf(inFile, "%d%s%f", &acct, name, &amnt);  

            tempPtr = create_node(name, acct, amnt);      
            startPtr = insert_node(startPtr, tempPtr);  
        }
    }

    fclose(inFile);

    return startPtr;
}

/* ================================================================
Function: update_list()
    - A function that takes in a pointer to the start of a linked
    list and a pointer to a file that will update the accounts
    previously loaded, if the account is already loaded, the
    function simply updates the account balance, otherwise it
    will create a new node at the end of the linked list for the 
    new account
================================================================ */
bank* update_list(bank* startPtr, char* updateFile)
{
    FILE* upFile = fopen(updateFile, "r");

        if(upFile == NULL)
        {
            perror("Error opening update file");
            exit(1);
        }
    
    int num = 0, acct = 0, val = -1;
    float amnt = 0.0;
    char* name = NULL;

    bankPtr temp = startPtr;
    bankPtr new = NULL;

    fscanf(upFile, "%d", &num);

    for(int i = 0; i < num; i++)
    {
        name = malloc(sizeof(char)*10);

            if(name == NULL)
            {
                perror("Space could not be created for name");
                exit(1);
            }

        fscanf(upFile, "%d%s%f", &acct, name, &amnt);
        val = check_list(startPtr, name, acct, amnt);

        if(1 == val)
        {
            while(temp->accn_num != acct)
            {
                temp = temp->next;
            }

            temp->amount += amnt;
            temp = startPtr;
            free(name);
        }
        else
        {
            new = create_node(name, acct, amnt);
            startPtr = insert_node(startPtr, new);
        }
    }

    fclose(upFile);

    return startPtr;
}

/* =============================================================
Function: delete_node()
    - A function that takes in a pointer to the start of a 
    linked list and will step through the list checking to see
    if there are any accounts with a negative balance. The 
    nodes that have the account member in a negative balance
    will be deleted from the linked list
============================================================= */
bank* delete_node(bank* startPtr)
{
    bankPtr temp = NULL;
    bankPtr current = NULL;

    while(startPtr->amount < 0)
    {
        temp = startPtr;
        startPtr = startPtr->next;
        free(temp->name);
        free(temp);
    }

    for(current = startPtr; current != NULL; current = current->next)
    {
        while(current->next != NULL && current->next->amount < 0)
        {
            temp = current->next;
            current->next = temp->next;
            free(temp->name);
            free(temp);
        }
    }

    return startPtr;
}

/* ============================================================
Function: check_list()
    - A function that takes in a pointer to the start of a 
    linked list along with the members of each node to check
    if the passed information is currently in the linked list
    returns 1 if true, 0 if information is not found
============================================================ */
int check_list(bank* startPtr, char* n, int acct, float amnt)
{
    int val = -1;

    bankPtr temp = startPtr;     

    while(temp != NULL)            
    {
        if(temp->accn_num == acct)
        {
            val = 1;
            return val;
        }
        else
        {
            val = 0;
        }

        temp = temp->next;         
    }

    if(0 == val)
    {
        printf("The account: %d is not in the linked list\n", acct);
    }

    return val;
}

/* ============================================================
Function: write_output()
    - A function that takes in a pointer to the start of a 
    linked list and a pointer to an output filename to write
    the bank account data to a separate file
============================================================ */
int write_output(bank* startPtr, char* outputFile)
{
    bankPtr temp = startPtr;

    FILE* outFile = fopen(outputFile, "w");

        if(outFile == NULL)
        {
            perror("Could not open output file");
            exit(1);
        }

    while(temp != NULL)
    {
        fprintf(outFile, "%d\t%-8s%11.2f\n", temp->accn_num, temp->name, temp->amount);

        temp = temp->next;
    }

    fclose(outFile);

    return 1;
}

/* ===============================================================
Function: print_list()
    - A function that takes in a pointer to the beginning node
    of a linked list and will print the bank account information
    to the screen with the accounts listed in alphabetical 
    order by name
=============================================================== */
void print_list(bank* startPtr)
{
    bankPtr tempPtr = NULL;
    bankPtr temp = startPtr;
    bankPtr current = startPtr;
    //bankPtr swapPtr = NULL;

    int tempAcct = 0;
    float tempAmt = 0.0;
    char *tempNm[10] = {};

    while(current != NULL)
    {
        tempPtr = current;

        while(tempPtr->next != NULL)
        {
            
            if(strcmp(tempPtr->name, tempPtr->next->name) > 0)
            {
                tempAcct = tempPtr->accn_num;
                tempPtr->accn_num = tempPtr->next->accn_num;
                tempPtr->next->accn_num = tempAcct;
                
                *tempNm = tempPtr->name;
                tempPtr->name = tempPtr->next->name;
                tempPtr->next->name = *tempNm;

                tempAmt = tempPtr->amount;
                tempPtr->amount = tempPtr->next->amount;
                tempPtr->next->amount = tempAmt;
                
                /*swapPtr = tempPtr;
                tempPtr = tempPtr->next;
                tempPtr->next = swapPtr;*/
            }

            tempPtr = tempPtr->next;
        }
        
        current = current->next;
    }


    while(temp != NULL)
    {
         printf("%d\t%-8s   %-.2f\n", temp->accn_num, temp->name, temp->amount);

         temp = temp->next;
    }
}

/* ===========================================================
Function: freeMem()
    - A function that takes in a pointer to the start of a 
    linked list and will free the  malloc'd space for 
    dynamacally allocated names and then the nodes themselves
=========================================================== */
void freeMem(bank* startPtr)
{
    bankPtr tempPtr;

    while(startPtr != NULL)
    {
        tempPtr = startPtr;
        startPtr = startPtr->next;
        free(tempPtr->name);
        free(tempPtr);
    }
}
