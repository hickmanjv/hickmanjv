/* ---------------------------------------------------------------
Student: Josh Hickman - hickmanjv
Student ID: 10236503
Assignment - Homework 3
     homework3.c - A program to take an input file of zipcodes,
     cities, and states, then loading them into a binary tree
     so that you can search for specific zipcodes or the
     number of zipcodes listed in each state
--------------------------------------------------------------- */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAXCITYNAME 30
#define MAXLINELENGTH 50

/* =============================
Defining struct data type
==============================*/
typedef struct n_
{
	int zipCode;        //A zip code that exists in the given city/state
	char* city;         //Will point to a city name
	char state[3];      //A state abbreviation. Note that we need room for the NULL terminator!
	struct n_* left;    //connections to other nodes
	struct n_* right;
} Node;

/* =============================
Function Prototypes
==============================*/
Node* importTree(char* filename);
Node* addNode(Node* root, Node* newNode);
int findStateCount(Node* root, char* state);
Node* findZipCode(Node* root, int zipCode);
void freeTree(Node* root);

/* ==============================================================
Function: main()
    - A function that will check command line arguments for
    accuracy and then build the tree from the input file. Then
    main will prompt the user with a menu that allows them to
    search for how many zipcodes a specific state has in the
    file or search for a specific zipcode in the file
=============================================================== */
int main(int argc, char** argv)
{
     if(argc != 2)
     {
          puts("Invalid command line arguements");
          puts("<a.out> <input filename>");
          return 1;
     }

     int choice = 0, st_count = 0, zip = 0;
     char st[3] = {};
     Node *root = NULL, *zipNode = NULL;

     root = importTree(argv[1]);    // builds BST from input file

     do     // loop for user menu
     {
          puts("1. Find the number of zip codes in a state");
          puts("2. Find a zip code");
          puts("3. Exit");
               scanf("%d", &choice);

               while(choice < 1 || choice > 3)
               {
                    puts("Error - not a valid option. Try again.");
                    puts("\n1. Find the number of zip codes in a state");
                    puts("2. Find a zip code");
                    puts("3. Exit");
                         scanf("%d", &choice);
               }

          if(choice == 1)       // search for a state to see how many zipcodes are in the file
          {
               puts("\nEnter the state: ");
                    scanf("%s", st);

               st_count = findStateCount(root, st);

               printf("\nThe state of %c%c has %d zip codes in the file.\n\n", st[0], st[1], st_count);
          }
          else if(choice == 2)  // search for a specific zipcode
          {
               puts("\nEnter the zip code you want to find: ");
                    scanf("%d", &zip);

               zipNode = findZipCode(root, zip);

                    if(zipNode != NULL)
                    {
                         printf("\nResult found for zip code %d", zip);
                         printf("\n\nCity: %s\n", zipNode->city);
                         printf("State: %s\n\n", zipNode->state);
                    }
                    else
                    {
                         printf("\nNo results found for zip code %d\n\n", zip);
                    }
          }

     }while(choice != 3);   // condition for menu loop

     puts("\nProgram Terminated");

     freeTree(root);    // free all allocated space
     return 0;
}

/* ================================================
Function: addNode()
    A function that will add a node to the BST
    in the proper location based on the zipcode
================================================ */
Node* addNode(Node* root, Node* newNode)
{
     if(root == NULL)
     {
          root = newNode;
     }

     if((newNode->zipCode) < (root->zipCode))
     {
          root->left = addNode(root->left, newNode);
     }
     else if((newNode->zipCode) > (root->zipCode))
     {
          root->right = addNode(root->right, newNode);
     }

     return root;
}

/* =============================================================
Function: findStateCount()
    A function that will search a BST for nodes that have the 
    matching state member with what was provided to the 
    function. Every time a node matches, a counter is bumped to 
    provide a total number of zipcodes for that particular state
============================================================== */
int findStateCount(Node* root, char* state)
{
     int count = 0;

     if(root == NULL)
     {
         return count;
     }
     else
     { 
         for(int i = 0; state[i] != '\0'; i++)
         {
             if(state[i] >= 97 && state[i] <= 122)
             {
                 state[i] = state[i] - 32;
             }
         }

         if(strcmp(state, root->state) == 0)
         {
             count++;
         }
         count += findStateCount(root->left, state);
         count += findStateCount(root->right, state);
     }

     return count;
}

/* =================================================
Function: findZipCode()
    A function that will return the node of a BST
    that has a matching member of zipcode to the 
    value sent to the function
================================================= */
Node* findZipCode(Node* root, int zip)
{
     Node *temp = NULL;

     if(root == NULL)
     {
          return NULL;
     }

     if(zip == root->zipCode)
     {
          return root;
     }
     else if(zip < root->zipCode)
     {
          temp = findZipCode(root->left, zip);
          return temp;
     }
     else if(zip > root->zipCode)
     {
          temp = findZipCode(root->right, zip);
          return temp;
     }

     return root;
}

/* ==============================================
Function: freeTree()
    A function that frees up allocated memory
    along with the allocated space for the city
    member of each node
=============================================== */
void freeTree(Node* root)
{
     if(root != NULL)
     {
          freeTree(root->left);
               free(root->city);
          freeTree(root->right);
               free(root);
          root = NULL;
     }
}

/* ============================================================
Function: importTree()
    A function that takes in an input file, then mallocs space
    for nodes of a BST and uses the addNode function to place
    the node in the correct place in the tree. Then importTree
    loops through the file adding a node for each line of data
============================================================= */
Node* importTree(char* filename)
{
	Node* root = NULL;

	FILE* fp = fopen(filename, "r");

	if(!fp)     // checks to see if file was successfully opened
	{
		printf("Error opening file.\n");
		return NULL;
	}

	while(!feof(fp))    //loop that starts at the beginning of input file and ends when end of file(eof) is reached
	{
		Node* new = malloc(sizeof(Node));   // mallocing space for a new node to add to a binary search tree(BST)
		if(!new)                            // checks to see if allocating space couldn't happen
		{
			printf("Failed to allocate memory. Ending read.\n");
			exit(1);
		}
		new->city = malloc(sizeof(char)*MAXCITYNAME);   // mallocs space for the character string of a city name
		if(!(new->city))                                // checks to see if allocating space couldn't happen
		{
			printf("Failed to allocate memory. Ending read.\n");
			exit(1);
		}
		new->left = NULL;       // initializes left pointer of node
		new->right = NULL;      // initializes right pointer of node
		char* line = malloc(sizeof(char)*MAXLINELENGTH);    // mallocs space for a string of characters that will be used for the zipcode
		if(!line)                                           // checks to see if allocating space couldn't happen
		{
			printf("Failed to allocate memory. Ending read.\n");
			exit(1);
		}
		if(fgets(line, MAXLINELENGTH, fp) == NULL)      // checks for errors reading in the first line of data from the file
		{
			if(!feof(fp))
			{
				printf("File reading ended prematurely. Check for errors in the file.\n");
				exit(1);
			}
			free(new->city);        // in case there was an error you still need to free up the space you allocated
			free(line);             // ^
			free(new);              // ^
			fclose(fp);             // still need to close the file if there was an error reading from it
			break;                  // breaks out of the importTree function because data couldn't be read from the file
		}
		char* tmp = strtok(line, ",");  // function that sets a delimiter of ',' so only the items read between commas gets stored
                                        // into variables
		new->zipCode = atoi(tmp);       // coverts the zipcode from a string into numbers and stores it into the zipCode member of a node
		tmp = strtok(NULL, ",");        // moves tmp to the next data to be read after the 1st comma
		strcpy(new->city, tmp);         // copys the city name from the file into the city member of the node
		new->city[strlen(tmp)+1] = '\0';    // ensures that the null terminator is added to the end of the city name string
		tmp = strtok(NULL, ",");        // moves tmp to the next data to be read after the 2nd comma
		strcpy(new->state, tmp);        // copies the state name from the file into the state member of the node
		new->state[2] = '\0';           // ensures that the null terminator is in the last array spot of the state array
		root = addNode(root, new);      // calls the addNode function to add the node to the BST and returns the root address
		if(!root)       // checks to see if a node could not be added to the tree
		{
			printf("Root of tree is still NULL! Ending read.\n");
			exit(1);
		}
		free(line);     // frees the allocated space used for the zipcode since it was converted to an integer value
                        // there is no longer a need to have the space for the string version
	}

	return root;        // returns the root address of the BST
}
