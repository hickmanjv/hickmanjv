// hickmanjv - Josh Hickman
// CS1050 Lab 7 - Section H

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define MAX 20

int check_error(int);				// prototype for error checking
void initialize_2Darray(int[][MAX], int);	// prototype to intialize 2D array
void print_2Darray(int[][MAX], int);		// prototype to print array to screen
int findZeros(int[][MAX], int);			// prototype to find the zeros a 2D array
int findEvenOdd(int[][MAX], int);		// prototype to find even & odd numbers in array
void printTranspose(int[][MAX], int);		// prototype to print array in row/column format

int main(void)
{ 
	// declare and initialize variables
	int size = -1 , error = -1, evenNum = -1, oddNum = -1, zeros = -1;
	int arr1[MAX][MAX];
	
	srand(time(NULL));	// seeding the random number generator

	// prompting the user for size of the array
	printf("Enter the size of the 2D array: ");
	scanf("%d", &size);
	error = check_error(size);
		// ensuring array size of only 1-20
		while(0 == error)	
		{
			printf("Please enter a value between 1-20 only: ");
			scanf("%d", &size);
			error = check_error(size);
		}
	
	initialize_2Darray(arr1, size);		// initializing the array
	print_2Darray(arr1, size);		// printing array
	printf("\n\n");
	zeros = findZeros(arr1, size);		// getting number of zeros in randomized array
	printf("The number of zeros 2-D array: %d\n", zeros);
	evenNum = findEvenOdd(arr1, size);	// getting the number of evens in randomized array
	oddNum = (size * size) - evenNum;	// getting the number of odds in randomized array
	printf("The number of Even numbers: %d\n", evenNum);
	printf("The number of Odd numbers: %d\n", oddNum);
	printTranspose(arr1, size);		// printing transposed array w/ rows as columns and columns as rows

	return(0);
}

int check_error(int size)				// function for error checking
{
	if(size < 1 || size > 20)
	{
		return 0;
	}
	else	return 1;
}

void initialize_2Darray(int arr1[][MAX], int size)	// function to initialize array with random 0-9
{
	int i = -1, j = -1;

	for(i = 0; i < size; i++)
	{
		for(j = 0; j < size; j++)
		{
			arr1[i][j] = rand() %10;
		}
	}
} 

void print_2Darray(int arr1[][MAX], int size)		// function to print the array
{
	int i = -1, j = -1;

	printf("THE FIRST 2-D ARRAY is:\n");
	
	for(i = 0; i < size; i++)
	{
		for(j = 0; j < size; j++)
		{
			printf("%3d", arr1[i][j]);
		}
		
		printf("\n");
	}
}

int findZeros(int arr1[][MAX], int size)		// function to return number of zeros
{
	int i = -1, j = -1, count = 0;

	for(i = 0; i < size; i++)
	{
		for(j = 0; j < size; j++)
		{
			if(arr1[i][j] == 0)
			{
				count++;
			}
			else
			{
			}
		}
	}

	return count;
}

int findEvenOdd(int arr1[][MAX], int size)		// function to return number of even numbers
{
	int i = -1, j = -1, count = 0;

	for(i = 0; i < size; i++)
	{
		for(j = 0; j < size; j++)
		{
			if((arr1[i][j] %2) == 0)
			{
				count++;
			}
			else
			{
			}
		}
	}

	return count;
}

void printTranspose(int arr1[][MAX], int size)		// function to print rows as columns and columns as rows
{
	int i = -1, j = -1;
	
	printf("The transpose of the 2-D Array is\n");

	for(i = 0; i < size; i++)
	{
		for(j = 0; j < size; j++)
		{
			printf("%3d", arr1[j][i]);
		}
		
		printf("\n");
	}
} 
