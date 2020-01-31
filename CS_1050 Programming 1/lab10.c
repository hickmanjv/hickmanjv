// hickmanjv - Josh Hickman
// Lab 10 - CS1050 - Section H

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void initializeArray(int*, int);
void printNumbers(int*, int);
void printReverse(int*, int);
float findAverage(int*, int);
int findMax(int*, int);
int findMin(int*, int);

int main(void)
{
	int max = 0, min = 0, size = 0;
	float avg = 0;
	int *ptr_a;

	srand(time(NULL));
	
	printf("Enter the size of the array: ");
	scanf("%d", &size);

		while(size < 1 || size > 100)
		{
			printf("Please enter again: ");
			scanf("%d", &size);
		}

	ptr_a = (int*) malloc(size * sizeof(int));

	initializeArray(ptr_a, size);
	printNumbers(ptr_a, size);
	avg = findAverage(ptr_a, size);
	max = findMax(ptr_a, size);
	min = findMin(ptr_a, size);

	printf("\nThe mean of all the numbers = %.2f", avg);
	printf("\nThe minimum of all the numbers = %d", min);
	printf("\nThe maximum of all the numbers = %d\n", max);
	
	printReverse(ptr_a, size);
	
	free(ptr_a);
	
	return 0;

}

void initializeArray(int *ptr_a, int size)
{
	int i;

	for(i = 0; i < size; i++)
	{
		*(ptr_a + i) = (1 + rand() % 9);
	}
}

void printNumbers(int *ptr_a, int size)
{
	int i;

	printf("\n\nThe array is:\n");
	
	for(i = 0; i < size; i++)
	{
		printf("%d ", *(ptr_a + i));
	}
}

float findAverage(int *ptr_a, int size)
{
	int sum = 0, i;
	
	for(i = 0; i < size; i++)
	{
		sum += *(ptr_a + i);
	}

	return (float) sum / (float) size;
}

int findMax(int *ptr_a, int size)
{
	int i, max = 0;
	
	for(i = 0; i < size; i++)
	{
		if(max < *(ptr_a + i))
		{
			max = *(ptr_a + i);
		}
	}

	return max;
}

int findMin(int *ptr_a, int size)
{
	int i, min = 10000;

	for(i = 0; i < size; i++)
	{
		if(min > *(ptr_a + i))
		{
			min = *(ptr_a + i);
		}
	}
	
	return min;
}

void printReverse(int *ptr_a, int size)
{
	int i;
	
	printf("\n\n********* BONUS *********\n\n");
	printf("The numbers reversed are:\n");
	
	for(i = size - 1; i >= 0; i--)
	{
		printf("%d ", *(ptr_a +i));
	}
	
	printf("\n");
}
