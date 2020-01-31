// hickmanjv - Josh Hickman
// CS1050 LAB 6 section H

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int check_error(int);			//prototype to check user input	
void initialize_array(int[], int);	//prototype to initialize array w/ random numbers
void print_array(int[], int);		//prototype to print elements of the array
int bonus_array(int[], int);		//prototype to print index of maximum value in array
float average(int[], int);		//prototype to calclate average if index values

int main(void)
{
	// declare and initialize variables
	int size = 0, error = -1, index = -1, fred[50] = {0};
	float av = 0;

	srand(time(NULL));	//seeding the random number generator

	printf("Enter the size of the input: ");
	scanf("%d", &size);
	error = check_error(size);
		

		while(0 == error)	// error check to only take numbers 1-50
		{
			printf("Invalid input enter the size of the input again: ");
			scanf("%d", &size);
			error = check_error(size);
		}

	initialize_array(fred, size);		// function to initialized the array
	printf("\nThe first input array\n");
	print_array(fred, size);		// function to print each element of array
	av = average(fred, size);		// function to calculate average of array elements
	printf("\n\nAverage of numbers in the first array is %.2f\n\n", av);
	
	printf("***Bonus Part***\n\n");
	index = bonus_array(fred, size);	// function to return index value of maximum number 
	printf("The maximum number is present at the index location %d in the array\n\n", index);
	
	return (0);
}

int check_error(int x)		//funtion for error checking
{
	if(x < 1 || x > 50)
	{
		return 0;
	}
	else	return 1;
}

void initialize_array(int fred[], int size)	//function to initialize arrays w/ random numbers
{
	int i;

	for(i = 0; i < size; i++)
	{
		fred[i] = rand() % 10;
	}	
}

void print_array(int fred[], int size)		// function to print array elements
{
	int i;

	for(i = 0; i < size; i++)
	{
		printf("%2d", fred[i]);
	}
}

float average(int fred[], int size)		// function to get average of elements in array
{
	float avg = 0;
	int i;

	for(i = 0; i < size; i++)
	{
		avg += fred[i];
	}

	avg = avg / size;

	return avg;
}  

int bonus_array(int fred[], int size)		// function to return index of max value in array
{
	int largest = -1, index = -1, i = 0;

	for(i = 0; i < size; i++)
	{
		if(fred[i] > largest)
		{
			largest = fred[i];
			index = i;
		}
		else
		{
		}
	}

	return index;
}
