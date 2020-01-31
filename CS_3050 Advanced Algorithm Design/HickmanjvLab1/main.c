/*****************************************************************
 *  Name: Josh Hickman - hickmanjv
 *  Class: CS3050
 *  Assignment: Program to create and manipulate a hash table
 *              with chaining
 *  Date: 3/08/19 - 3/14/19
 * 
 * NOTE -- Program uses fmod(), please include -lm command when
 *         compiling with gcc
 *****************************************************************/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

#define SIZE 31

typedef struct HashTableEntry {
    int key;
    char* name;
    struct person* nextPtr;
}person;

typedef struct HashTable {
    int size;
    int count;
    person** entries;
}hashT;

/******************************* 
 Function Prototypes
 *******************************/

int getKey(char*);
int convertToIndex(int);
int collisionHandler(char*, int, int);
void insertEntry(hashT*, person*, int, char*);
person* searchTable(hashT*, int);
void printMenu();
person* newEntry(int, char*);
hashT* initializeTable();
void deletePerson(person*);
void deleteTable(hashT*);

/**********************************************
 Function: Main - no command line arguments
    - Contains entire program 
 **********************************************/
int main(int argc, char** argv) {
         
    int flag = 1, key = -1, index = -1;
    char menuChoice;
    char name[SIZE + 1];
    char name2nd[SIZE + 1];
    person* person1Ptr = NULL;
    person* person2Ptr = NULL;
    person* entryPtr = NULL;
    person* currentPtr = NULL;
    
    printMenu();
    
    person* entry;
    hashT* table = initializeTable();
    
    do{
        printf("What would you like to do? ");
        scanf(" %c", &menuChoice);
        
        /********************************************************************
         This conditional ensures only the correct menu response is chosen
          
          --Technically should parse input for first letter only -- WIP
         ********************************************************************/
        while(menuChoice != 'x' && menuChoice != 'X' && menuChoice != 'p' && menuChoice != 'P'
                && menuChoice != 'f' && menuChoice != 'F' && menuChoice != 'u' && menuChoice != 'U'
                && menuChoice != 'l' && menuChoice != 'L' && menuChoice != 'q' && menuChoice != 'Q')
        {
            
            puts("Error, please enter correct menu choice to continue: \n");
            
            printf("What would you like to do? ");
            scanf(" %c", &menuChoice);
        }
        
        if('x' == menuChoice || 'X' == menuChoice){
            flag = 0;
        }
        else
        {
            /******************************************************************
             Menu choice to create and add a person to the hash table - done
             ******************************************************************/
            if('p' == menuChoice || 'P' == menuChoice){
               
                printf("Please enter the name of the person to add to the program: ");
                scanf("%s", name);
                
                key = getKey(name);
             
                entry = newEntry(key, name);
                
                printf("key is %d and name is %s\n", entry->key, entry->name);
                insertEntry(table, entry, key, name);
               
            }
            
            /******************************************************************
             Menu choice to see make 2 people friends in the hash table
             error Checking - done, getting 2 people stored - done,
             ---linking 2 people - not completed - trouble with pointers---
             * 
             * This menu seg faults if choosing a person not added to the 
             * hash table: WIP
             ******************************************************************/
            if('f' == menuChoice || 'F' == menuChoice){
                
                printf("Enter name of the first person: ");
                scanf("%s", name);
                
                key = getKey(name);
                person1Ptr = searchTable(table, key);
                //printf("%s\n", person1Ptr->name);
                
                if(person1Ptr == NULL){
                    
                    printf("%s has not been added to the hash table, cannot make friends\n", person1Ptr->name);
                }
                else
                {
                    printf("%s is in the table, awaiting second person to make friends\n", person1Ptr->name);
                }
                
                printf("Enter name of the second person: ");
                scanf("%s", name2nd);
                
                key = getKey(name2nd);
                person2Ptr = searchTable(table, key);
                //printf("%s\n", person2Ptr->name);
                
                if(person2Ptr == NULL){
                    
                    printf("%s has not been added to the hash table, cannot make friends\n", person2Ptr->name);
                }
                else if(person1Ptr == NULL && person2Ptr != NULL){
                 
                    printf("%s was not in the table, so unable to make friends with %s\n", person1Ptr->name, person2Ptr->name);
                }
                else
                {
                    printf("%s and %s are now friends!\n\n", person1Ptr->name, person2Ptr->name);
                }
                
//                need to link pointers to create linked list
//                key = getKey(name);
//                index = convertToIndex(key);
                
//                currentPtr = *table[index].entries;
//                
//                key = getKey(name2nd);
//                index = convertToIndex(key);
                
//                while(currentPtr->nextPtr != NULL){
//                    
//                    currentPtr = currentPtr->nextPtr;
//                }
//                
//                currentPtr->nextPtr = *table[index].entries;
            }
            
            if('u' == menuChoice || 'U' == menuChoice){
                puts("test u");
            }
            
            /******************************************************************
             Menu choice to search for a person and print their friends
             Search function not working as intended -  key needs to be updated
             when handling collisions
             Trouble with printing b/c of problem linking from Menu f/F
             ******************************************************************/
            if('l' == menuChoice || 'L' == menuChoice){
                
                printf("Enter name of a person in the hash table to see their friends: ");
                scanf("%s", name);
                
                key = getKey(name);
                entryPtr = searchTable(table, key);
                index = convertToIndex(key);
                
                if(entryPtr == NULL){
                    
                    printf("%s has not been added to the hash table, cannot search for friends\n", name);
                }
                else
                {
                    printf("%s is friends with %s\n", name, entryPtr->name);
                }
            }
            
            if('q' == menuChoice || 'Q' == menuChoice){
                puts("test q");
            }
        }
        
    } while(1 == flag);
    
    // free memory
    deleteTable(table);   
    
    return (EXIT_SUCCESS);
}

void printMenu(){
    
    puts("**************** Welcome to the Micro Facebook Program ********************\n"
         "Here are your options:\n"
         "Type 'P' to enter a person's name which adds them to your hash table\n"
         "Type 'F' to enter two people's names which specifies them as friends\n"
         "Type 'U' and two people's names to have them no longer being friends\n"
         "Type 'L' and a person's name to print out that person's friends\n"
         "Type 'Q' and two people's names to check whether or not they are friends\n"
         "Type 'X' to terminate the program\n"
         "***************************************************************************\n");  
}

/****************************************************************
 Function: getKey
    - Takes in a string and returns numeric key used for hashing
 ****************************************************************/
int getKey(char *name){
    
    int value = 0, sum = 0, i = 0;
    
    for(i = 0; i < strlen(name) + 1; i++){

        value = name[i];
        sum += value;
    }
    
    return sum;
}

/******************************************************************
 Function: convertToIndex
    - Takes in a key and returns numeric index value for position
      in hash table
 ******************************************************************/
int convertToIndex(int hashValue){
    
    double value, x;
    int index;
    
    x = (((double)hashValue * 0.618));
    value = fmod(x, 1);
    index = 23 * value;
    
    return index;
}

/******************************************************************
 Function: collisionHandler
    - Handles the case when there is a collision with hash indexes
 ******************************************************************/
int collisionHandler(char* name, int size, int count){
    int hash1 = 0;
    int hash2 = 0;
    
    hash1 = getKey(name);
    hash2 = getKey(name);
    
    return (hash1 + (count * (hash2 + 1))) % size;
}

/******************************************************************
 Function: newEntry
    - Creates a new "person" and assigns memory/values for the 
      struct person
 ******************************************************************/
person* newEntry(int key, char* name){
    
    person* entry = malloc(sizeof(person));
    entry->key = (key);
    entry->name = strdup(name);
    entry->nextPtr = NULL;
    
    return entry;
}

/******************************************************************
 Function: initializeTable
    - Creates physical hash table, and allocates memory
 ******************************************************************/
hashT* initializeTable(){
    
    hashT* table = malloc(sizeof(hashT));
    
    table->size = SIZE;
    table->entries = calloc((size_t)table->size, sizeof(person*));  // initializes to NULL
    
    return table;
}

/******************************************************************
 Function: insertEntry
    - Insert a person into the calculated index of the hash table
 ******************************************************************/
void insertEntry(hashT* table, person* entry, int key, char* name){
    
    int i = 1;
    
    int index = convertToIndex(key);
    
    person* temp = table->entries[index];
    
    while(temp != NULL){
        
        index = collisionHandler(entry->name, table->size, i);
        temp = table->entries[index];
        i++;
    }
    
    table->entries[index] = entry;
    table->count++;
    
    printf("Index of %s is %d\n", entry->name, index);
}

/******************************************************************
 Function: deletePerson
    - free the memory assigned to a created struct person - used
      in deleteTable function
 ******************************************************************/
void deletePerson(person* p){
    
    free(p->name);
    free(p);
}

/******************************************************************
 Function: deleteTable
    - free the memory of everything in the hash table, then frees
      the memory for the table itself
 ******************************************************************/
void deleteTable(hashT* table){
    
    int i = 0;
    
    for(i = 0; i < table->size; i++){
        person* entry = table->entries[i];
        
        if(entry != NULL){
            deletePerson(entry);
        }
    }
    
    free(table->entries);
    free(table);
}

/******************************************************************
 Function: searchTable
    - takes in the hash table and a key and returns a pointer to
      the name of the person if they are found, NULL otherwise
 ******************************************************************/
person* searchTable(hashT* table, int key){
    
    int index, i = 1;
    
    index = convertToIndex(key);
    
    person* entry = table->entries[index];
    
    while(entry != NULL){
        
        if(entry->key == key){
            
            return entry;
        }
        
        index = collisionHandler(entry->name, table->size, i);
        entry = table->entries[index];
        i++;
    }
    
    return NULL;
}