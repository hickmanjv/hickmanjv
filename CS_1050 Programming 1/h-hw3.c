/* ---------------------------------------------------------------------------------------
 Student: Josh Hickman
 Student ID: 10236503
 Assignment: Homework 3 - CS1050 - Section H - 04/12/18 Spring 2018
	h-hw3.c - reading data from a file and writing to another. The program takes
	command line arguments: an input filename, the count of the numbers in the file,
	and the output file name.
---------------------------------------------------------------------------------------- */


#include <stdio.h>
#include <stdlib.h>

int load_data(FILE*, int*, float*, char**, int);			// File prototypes
void print_data(int*, float*, int);					//
int highest_amount(float*, int);					//
int lowest_amount(float*, int);						//
float average_amount(float*, int);					//
int write_data(FILE*, int*, float*, char**, int, int, int, float);	//


/* ==========================================================================
 Function: main()
	main will check command line arguments for valid input, open the
	appropriate files, and process the data in different ways defined
	by their individual functions
========================================================================== */

int main(int argc, char *argv[])
{
	// Declaring and initializing variables/filenames
	int size = 0, high = 0, low = 0, load = -1, write = -1;
	float avg = 0;
	int* ptrAccount;
	float* ptrTotal;
	FILE* inputFile = (fopen(argv[1], "r"));
	FILE* outputFile = (fopen(argv[3], "w"));

		// Error Checking for proper amount of cmd line parameters
		if(argc < 4 || argc > 4)
		{
			printf("Incorrect number of arguments\n");
			return 1;
		}

	// Ensuring account totals is of type int
	size = atoi(argv[2]);

	// Setting up pointer arrays
	ptrAccount = (int*) malloc(size * sizeof(int));
	ptrTotal = (float*) malloc(size * sizeof(float));
	
	load = load_data(inputFile, ptrAccount, ptrTotal, argv, size);	// Function to load data from a file into pointer arrays
									// returns 0 if failed, 1 if success
		// Error checking when file doesn't open
		if(load == 0)
		{
			printf("File could not be opened\n");
			exit(1);
		}

	print_data(ptrAccount, ptrTotal, size);				// Function to print data from file to the screen
	high = highest_amount(ptrTotal, size);				// Function to find the highest dollar amount of all accounts
	low = lowest_amount(ptrTotal, size);				// Function to find the lowest dollar amount of all accounts
	avg = average_amount(ptrTotal, size);				// Function to find the average of all amounts fr all accounts

	printf("\nThe highest amount is $%.2f in the account number %d\n", *(ptrTotal + high), *(ptrAccount + high));
	printf("The lowest amount is $%.2f in the account number %d\n", *(ptrTotal + low), *(ptrAccount + low));
	printf("The average amount is $%.2f\n", avg);

	write = write_data(outputFile, ptrAccount, ptrTotal, argv, size, high, low, avg);	// Function to write data and calculations to a file
												// returns 0 if failed, 1 if success
		// Error checking when file doesn't create
		if(write == 0)
		{
			printf("Can not open a file for writing data\n\n");
		}

	// Freeing the created pointer arrays
	free(ptrAccount);
	free(ptrTotal);

	return (0);
}

int load_data(FILE *inputFile, int *ptrAccount, float *ptrTotal, char **argv, int size)
{	
	int i;

	if((inputFile = fopen(argv[1], "r")) == NULL)
	{
		printf("File could not be opened\n");
		return 0;
	}
	else
	{
		fscanf(inputFile, "%*[^\n]\n");		//skips first line of file - it doesn't contain data in use for pointers
	
		// loop for reading file data into pointers
		while(!feof(inputFile))
		{
			for(i = 0; i < size; i++)
			{
				fscanf(inputFile, "%d%f\n", (ptrAccount + i), (ptrTotal + i));
			}
		}

		// Closing File
		fclose(inputFile);
	}

	return 1;
}

void print_data(int *ptrAccount, float *ptrTotal, int size)
{
	int i;

	printf("Account No. Amount\n");
	
	for(i = 0; i < size; i++)
	{
		printf("%d%14.2f\n", (*(ptrAccount + i)), (*(ptrTotal + i)));
	}
}

int highest_amount(float *ptrTotal, int size)
{
	int i, index;
	float high;
	
	for(i = 0; i < size; i++)
	{
		if (high < (*(ptrTotal +i)))
		{
			high = (*(ptrTotal + i));
			index = i;
		}
	}

	return index;
}

int lowest_amount(float *ptrTotal, int size)
{
	int i, index;
	float low = 10000000;

	for(i = 0; i < size; i++)
	{
		if(low > (*(ptrTotal + i)))
		{
			low = (*(ptrTotal + i));
			index = i;
		}
	}

	return index;
}

float average_amount(float *ptrTotal, int size)
{
	int i;
	float sum = 0;

	for(i = 0; i < size; i++)
	{
		sum += (*(ptrTotal + i));
	}

	return (sum / (float) size);
}

int write_data(FILE *outputFile, int *ptrAccount, float *ptrTotal, char **argv, int size, int high, int low, float avg)
{
	int i;

	if((outputFile = fopen(argv[3], "w")) == NULL)
	{
		printf("Can not open the file\n");
		return 0;
	}
	else
	{
		fprintf(outputFile, "Account No. Amount\n");

		for(i = 0; i < size; i++)
		{
			fprintf(outputFile, "%d%14.2f\n", (*(ptrAccount + i)), (*(ptrTotal + i)));
		}

		fprintf(outputFile, "\nThe highest amount is: $%.2f\n", (*(ptrTotal + high)));
		fprintf(outputFile, "The lowest amount is: $%.2f\n", (*(ptrTotal + low)));
		fprintf(outputFile, "The average amount is: $%.2f\n", avg);

		// Closing File
		fclose(outputFile);
	}

	return 1;
} 
