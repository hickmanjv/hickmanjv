/* ------------------------------------------------
Student: Josh Hickman - hickmanjv
Student ID: 10236503
Assignment: Lab 3 Section B
    b-lab3.c - Program to demonstrate recursion
    within a function
------------------------------------------------ */

#include <stdio.h>
#include <stdlib.h>

/* ==============================
 Declaring Struct Data Type
============================== */

typedef struct storage
{
    int x;
    int y;
    int gcd;
    int fib;
}Store;

/* ========================
 Function Prototypes
======================== */

int gcd(int, int);
int fibonacci(int);
void write_to_file(Store, char*);


/* =================================================================
 Function - main()
    Will check to make sure command line arguements are valid
    and store variables into the structure. Then use those
    variables from the structure to use the gcd and fibonacci
    functions, at the end writing the struct variables to a file
 ================================================================ */

int main(int argc, char **argv)
{
    int fib = 0, userNum = 0, i;
    Store storage;      // creating an instance of type Store

    storage.x = atoi(argv[1]);
    storage.y = atoi(argv[2]);

    if(argc != 4)
    {
        printf("\nInvalid command line input!\n");
        printf("<./a.out> <number> <number> <output file>");
        return 1;
    }
    else if(storage.x < 0)
    {
        printf("Invalid number, please enter only positive integers!\n");
        return 2;
    }
    else if(storage.y < 0)
    {
        printf("Invalid number, please enter only positive integers!\n");
        return 3;
    }

    storage.gcd = gcd(storage.x, storage.y);

    printf("\nThe GCD of %d and %d is %d\n\n", storage.x, storage.y, storage.gcd);
    
    printf("How many elements of the fibonacci sequence would you like to generate?\n");
    printf("Please enter a non negative number: ");
        scanf("%d", &userNum);

        while(fib < 0)
        {   
            printf("Invalid input, please enter a non negative number: ");
                scanf("%d", &userNum);
        }
    
    storage.fib = fibonacci(storage.x);

    for(i = 0; i < userNum; i++)
    {
        printf("%d\n", fibonacci(i));
    }
    
    write_to_file(storage, argv[3]);



    return 0;
}

/* ======================================================
 Function - gcd()
    A function to recursively find the greatest common 
    denominator of 2 numbers.
 ====================================================== */

int gcd(int num1, int num2)
{
    if(num2 == 0)
    {
        return num1;
    }
    else
    {
        return gcd(num2, (num1 % num2));
    }

}



/* =====================================================
 Function - fibonacci()
    A function that recursively finds the fibonacci
    number in its sequence based on what number
    passed to the function.
 ==================================================== */

int fibonacci(int fib)
{
    if(fib == 0 || fib == 1)
    {
        return fib;
    }
    else
    {
        return (fibonacci(fib - 2) + fibonacci(fib -1));
    }
}

/* ========================================================
 Function - write_to_file()
    function to print all of the members of the structure
    to an output file.
======================================================== */

void write_to_file(Store storage, char *file)
{
    FILE *outFile = fopen(file, "w");

        if(outFile == NULL)
        {
            printf("\nUnable to open output file.\n");
            return;
        }

        fprintf(outFile, "%d %d %d %d\n", storage.x, storage.y, storage.gcd, storage.fib);

    fclose(outFile);
}

