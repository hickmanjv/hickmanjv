/* ---------------------------------------------------------------------
Student: Josh Hickman - hickmanjv
Student ID: 10236503
Assignment: Homework 1
    Homework1.c - Creating a program to read data from 3 different input
    files that contain baseball player stats used to calculate
    slugging percentage, then sorting the player list in
    descending order and writing the total number of sorted
    players into an output file
--------------------------------------------------------------------- */


#include <stdio.h>
#include <stdlib.h>

/* ============================================
 Creating the Player data type and its members
============================================ */

typedef struct player
{
    char Fname[25];
    char Lname[25];
    int Singles;
    int Doubles;
    int Triples;
    int Homeruns;
    int At_Bats;
    float Slugging_Percentage;
} Player;

/* =======================
 Funtion Prototypes
======================= */

void read_from_file(char*, Player*, int, int);
void calculate_slugging(Player*, int);
void sort_array(Player*, int);
void write_to_file(char*, Player*, int);


/* =======================================================
Function: main()
    main will check the command line arguments for valid
    input, and process the functions that allow for
    reading in data, calculations on the data, sorting,
    and writing to output file.
======================================================= */

int main(int argc, char **argv)
{
    if(argc != 6)
    {
        printf("Invalid number of command line arguements\n");
        printf("<./a.out> <total # of players> <inputfile 1> <inputfile 2> <inputfile 3> <outputfile>\n\n");
        return 1;
    }

    int index = 0, size = 0, temp = 0;
    temp = atoi(argv[1]);
    size = (temp/3);

    Player *playerPtr = (Player*)malloc(sizeof(Player) * temp);     // dynamically creating an array of player structures

        if(!playerPtr)
        {
            printf("Unable to allocate memory for the players.\n");
            return 2;
        }


    read_from_file(argv[2], playerPtr, index, size);
    read_from_file(argv[3], (playerPtr + size), (index + size), (size * 2));
    read_from_file(argv[4], (playerPtr + (size * 2)), (index + (size * 2)), temp);

    calculate_slugging(playerPtr, temp);

    sort_array(playerPtr, temp);

    write_to_file(argv[5], playerPtr, temp);


    free(playerPtr);    // freeing up malloc'd space

    return 0;
}

/* ===============================================================
Function: read_from_file
    This function will read in the size and the list players from
    an inputfile and add them to the player array. The function
    will use index to know where to start loading players into the
    array.
=============================================================== */

void read_from_file(char *inputFile, Player* playerPtr, int index, int size)
{
    int i;
    FILE *inFile = fopen(inputFile, "r");
    
        if(inFile == NULL)
        {
            printf("Unable to open input file.\n");
            return;
        }

    for(i = index; i < size; i++)
    {
        fscanf(inFile, "%s", playerPtr->Fname);
        fscanf(inFile, "%s", playerPtr->Lname);
        fscanf(inFile, "%d", &(playerPtr->Singles));
        fscanf(inFile, "%d", &(playerPtr->Doubles));
        fscanf(inFile, "%d", &(playerPtr->Triples));
        fscanf(inFile, "%d", &(playerPtr->Homeruns));
        fscanf(inFile, "%d", &(playerPtr->At_Bats));

        playerPtr++;
    }

    fclose(inFile);
}

/* ===================================================================
Function: calculate_slugging
    This function will take in an array of players and calculate
    their slugging percentage using the members of the structure
    (Singles, Doubles, Triples, Homeruns, At_Bats). Singles represent
    1, Doubles 2, Triples 3, and Homeruns 4. You multiply all the 
    different hits and add them together, dividing by At_Bats.
=================================================================== */

void calculate_slugging(Player* playerPtr, int size)
{
    int i;

    for(i = 0; i < size; i++)
    {
        playerPtr->Slugging_Percentage = (((float)(playerPtr->Singles) + (float)(playerPtr->Doubles * 2)
                                         + (float)(playerPtr->Triples * 3) + (float)(playerPtr->Homeruns * 4))
                                         / (float)(playerPtr->At_Bats));
        playerPtr++;
    }

}

/* ===================================================================
Function: sort_array
    This function takes in an array of players and will sort the array
    based on Slugging percentage using the Bubble Sort algorithm.
    The sort will make the array go in descending order.
=================================================================== */

void sort_array(Player* playerPtr, int size)
{
    int i, j;

    for(i = 0; i < size - 1; i++)
    {
        for(j = 0; j < size - i - 1; j++)
        {
            if((playerPtr[j].Slugging_Percentage) < (playerPtr[j+1].Slugging_Percentage))
            {
                Player temp;

                temp = playerPtr[j];
                playerPtr[j] = playerPtr[j+1];
                playerPtr[j+1] = temp;
            }
        }
    }
}

/* ==================================================================
Function: write_to_file
    This function takes in an array of players, the filename of the
    output file and the size of the players in the array to write
    them to the output file
================================================================== */

void write_to_file(char *outputFile, Player* playerPtr, int size)
{
    int i;
    FILE *outFile = fopen(outputFile, "w");
    
        if(outFile == NULL)
        {
            printf("Unable to open output file.\n");
            return;
        }

    for(i = 0; i < size; i++)
    {
        fprintf(outFile, "%s ", playerPtr->Fname);
        fprintf(outFile, "%s ", playerPtr->Lname);
        fprintf(outFile, "%d ", playerPtr->Singles);
        fprintf(outFile, "%d ", playerPtr->Doubles);
        fprintf(outFile, "%d ", playerPtr->Triples);
        fprintf(outFile, "%d ", playerPtr->Homeruns);
        fprintf(outFile, "%d ", playerPtr->At_Bats);
        fprintf(outFile, "%.4f ", playerPtr->Slugging_Percentage);
        fprintf(outFile, "\n");

        playerPtr++;
    }

    fclose(outFile);

}
