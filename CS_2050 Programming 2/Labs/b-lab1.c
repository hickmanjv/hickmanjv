/* -------------------------------------------------------------
 Student: Josh Hickman - hickmanjv
 Student ID: 10236503
 Assignment: Lab 1 Section B
------------------------------------------------------------- */

#include <stdio.h>
#include <stdlib.h>

int read_info(char*, int**, char**, float**);
void print_array(char**, int*, float*, int);
int min_GPA(float*, int);
int max_GPA(float*, int);
float avg_GPA(float*, int);
//int search_ID(int*, int, int);

/* =============================================================================
Function: main
	A function with command line arguments that will read information from
	a file and perform various operations with that data, printing the data
	in different ways. Free's the malloc'd spaced at the end of main.
============================================================================= */

int main(int argc, char *argv[])
{
	if(argc != 2)
	{
		printf("Not enough arguements on command line...\n");
		printf("./a.out b-lab1.c  input.txt\n\n");
		return 1;
	}
	
	int size = -1, minGPA = 100, maxGPA = 0;
	float avgGPA = 0;
	int *idPtr;
	char **namePtr;
	float *gpaPtr;	

	size = read_info(argv[1], &idPtr, &namePtr, &gpaPtr);

	print_array(&namePtr, idPtr, gpaPtr, size);

	printf("\n\n");

	maxGPA = max_GPA(gpaPtr, size);
	minGPA = min_GPA(gpaPtr, size);
	avgGPA = avg_GPA(gpaPtr, size);
	
	printf("The person with the highest GPA is %s and their GPA is: %.1f\n\n", (namePtr + maxGPA), (*(gpaPtr + maxGPA)));

	printf("The person with the lowest GPA is %s and their GPA is: %.1f\n\n", (namePtr + minGPA), (*(gpaPtr + minGPA)));

	printf("The average GPA of all students is: %.1f\n\n", avgGPA);






	free(idPtr);
	free(namePtr);
	free(gpaPtr);

	return 0;
}

/* ==============================================================================
Function: read_info
	A function that takes in a pointer for an input file, and double pointers
	for id numbers, names, and gpa's from said input file. Opens and closes
	the file, and in this case the first line of the file is the number of 
	people total in the file, so it reads the very first line and assigns 
	that to a variable for looping. Mallocs space for points to hold multiple 
	indexes of id, name, and gpa. Then scans the input file line by line and 
	inserts those values into the appropriate variabe.
============================================================================== */

int read_info(char* infile, int** id, char** name, float** gpa)
{	
	int size = 0, temp = 0, i = 0;
	float temp2 = 0;
	char *string = NULL;

	
	FILE *filePtr = fopen(infile, "r");

	if((filePtr) == NULL)
	{
		printf("The file could not be opened...\n\n");
		return -1;
	}
	else
	{
		fscanf(filePtr, "%d", &size);
	
			if(size <= 0)
			{
				printf("Improper input file format...\n\n");
				return -2;
			}

		*id = (int*)malloc(sizeof(int) * size);
		*name = (char*)malloc(sizeof(char) * size);
		*gpa = (float*)malloc(sizeof(float) * size);
		string = (char*)malloc(sizeof(char) * size);

			while( fscanf(filePtr, "%s%d%f", string, &temp, &temp2) > 0)   // why > 0 not != EOF
			{
				(*name)[i] = *string;		// only reads first character of line
				printf("%s", string);
				(*id)[i] = temp;
				(*gpa)[i] = temp2;
				i++;
			}

	}
	
	fclose(filePtr);
	free(string);

	return size;
}

/* ==============================================================================
Function: min_GPA
	A function that takes in a pointer to the GPA, and the number of people
	in the file for looping. Will return the index value of the person with
	the lowest GPA. (WARNING!! Does not take into account of multiple people
	with the lowest GPA)
============================================================================== */

int min_GPA(float *gpa, int size)
{
	int i, temp = -1, min = 100;

	for(i = 0; i < size; i++)
	{
		if(*(gpa + i) <  (float) min)
		{
			min = (*(gpa + i));
			temp = i;
		}
	}

	return temp;
}

/* =============================================================================
Function: max_GPA
	A function that takes in a pointer to the GPA, and the number of people
	in the file for looping. Will return the index value of the person with
	the highest GPA. (WARNING!! Does not take into account multiple people
	with the highest GPA)
============================================================================= */

int max_GPA(float *gpa, int size)
{
	int i, max = 0, temp = -1;

	for(i = 0; i < size; i++)
	{
		if(*(gpa + i) > (float) max);
		{
			max = (*(gpa +i));
			temp = i;
		}
	}
	
	return temp;
}

/* ============================================================================
Function: avg_GPA
	A function that takes in a pointer to the GPA, and the number of people
	in the file for looping. Will return the average gpa of everyone in the
	file.
============================================================================ */

float avg_GPA(float *gpa, int size)
{
	int i;
	float total = 0;

	for(i = 0; i < size; i++)
	{
		total += (*(gpa + i));
	}

	return (total / (float) size);

}

/* ===========================================================================
Function: print_array
	A function that takes in pointers to names, id's, and gpa's in a file
	along with the number of people in the file for looping. Prints the 
	contents of the file w/ formatting.
=========================================================================== */

void print_array(char **name, int *id, float *gpa, int size)
{
	int i;
	
	printf("User input\n\n");
	printf("Name\tID\tGPA\n");
	
	puts(name); //     confirms it is being read in wrong

	for(i = 0; i < size; i++)
	{
		printf("%s %d %.1f\n", (*(name + i)), (*(id + i)), (*(gpa + i)));
	}
}

/* ===========================================================================
Funtion: search_ID
	A function that takes in a pointer to the id #'s of people in a file,
	the number of people in the file, and the ID that is to be searched 
	for. Returns the index of the array for the person being searched for
	if the ID given matches someone in the file
=========================================================================== */

/*int search_ID(int *id, int size, int searchID)
{





}*/	
