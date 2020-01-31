// hickmanjv - Josh Hickman
// Lab 9 - CS1050 Section H
// 04/04/18

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>
#define MAX 100

void initialize_array(int*, int);
void print_array(int*, int);
float median(int*, int);
float standard_deviation(int*, int);
void sortArray(int*, int);
float mean(int*, int);

int main(void)
{
	int size = 0;
	float med = 0, sd = 0;
	int array[MAX] = {0};
	int *arPtr = array;

	srand(time(NULL));

	printf("Enter a valid size for the input: ");
	scanf("%d", &size);
		
		while(size < 1 || size > 100)
		{
			printf("Enter a valid size for the input: ");
			scanf("%d", &size);
		}
	
	initialize_array(arPtr, size);
	print_array(arPtr, size);
	sortArray(arPtr, size);
	printf("\n");
	print_array(arPtr, size);
	med = median(arPtr, size);
	sd = standard_deviation(arPtr, size);
	
	printf("\n\nMedian of the array is %.2f\n", med);
	printf("Standard deviation is %.2f\n", sd);

	return (0);
}

void initialize_array(int *arPtr, int size)
{
	int i;

	for(i = 0; i < size; i++)
	{
		*(arPtr + i) = 1 + rand() % 5;
	}
}

void print_array(int *arPtr, int size)
{
	int i;

	printf("Input array\n");

	for(i = 0; i < size; i++)
	{
		printf("%d ", *(arPtr + i));
	}
}

float median(int *arPtr, int size)
{
	float median;

	if(size % 2 == 1)
	{
		return *(arPtr + (size/2));
	}
	else
	{
		median = ((*(arPtr + (size/2)) + *(arPtr + (size/2) -1)) / 2.0);
		return median;
	}
}

float standard_deviation(int *arPtr, int size)
{
	float stdDev = 0, mn;
	int i;
	
	mn = mean(arPtr, size);	 
	
	for(i = 0; i < size; i++)
	{
		stdDev += pow(*(arPtr + i) - mn, 2);
	}

	return sqrt(stdDev/(size -1));

}

void sortArray(int *arPtr, int size)
{
	int pass, i, hold;

	for(pass = 1; pass < size; pass++)
	{
		for(i = 0; i < size - 1; i++)
		{
			if( *(arPtr + i) > *(arPtr + i + 1))
			{
				hold = *(arPtr + i);
				*(arPtr + i) = *(arPtr + i + 1);
				*(arPtr + i + 1) = hold;
			}
		}
	}
}

float mean(int *arPtr, int size)
{
	int i;
	float total;

	for(i = 0; i < size; i++)
	{
		total += *(arPtr + i);
	}
	
	return (total/size);
}

