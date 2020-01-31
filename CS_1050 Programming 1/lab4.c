// hickmanjv - Josh Hickman
// CS1050 lab4 - section H

#include <stdio.h>

int errorCheck(int);		// prototype for error checking
int checkEven(int);		// prototype for even/odd assingment
int checkPrime(int);		// prototype for prime assingment
void printMizzou(int);		// prototype for printing MIZZOU format

int main(void)
{
	// Declaring and initializing variables
	int num1 = 0, num2 = 0, even = 0, prime = 0, error = -1;
	
	// Prompting the user and taking in input for 1st number
	printf("Enter the first positive number: ");
	scanf("%d", &num1);
	
	// Error checking for 1st number
	error = errorCheck(num1);
		while(error == 0)
		{
			printf("Error! Enter a postive number only: ");
			scanf("%d", &num1);
			error = errorCheck(num1);
		}
	
	// Check for even or od number
	even = checkEven(num1);
		if(1 == even)
		{
			printf("\n%d is an Even number", num1);
		}
		else	printf("\n%d is an Odd number", num1);
	
	// Check for prime number
	prime = checkPrime(num1);
		if(1 == prime)
		{
			printf("\n%d is a Prime number", num1);
		}
		else	printf("\n%d is not a Prime number", num1);

	// Prompt for 2nd number from user
	printf("\n\nEnter the second positive number: ");
	scanf("%d", &num2);
	
	// Error checking for 2nd number
	error = errorCheck(num2);
		while(error == 0)
		{
			printf("Error! Enter a positive number only: ");
			scanf("%d", &num2);
			error = errorCheck(num2);
		}
	
	// Printing output from 2nd number
	printf("\n\nCalling the mizzou function, the output is: ");
	printMizzou(num2);
	printf("\n\n");

	return (0);	
}

int errorCheck(int num1)
{
	if(num1 >= 1)
	{
		return 1;
	}
	else	return 0;
}

int checkEven(int e)
{
	if(0 == (e % 2))
	{
		return 1;
	}
	else	return 0;
}

int checkPrime(int p)
{
	int i, flag;
	
	for(i = 2; i <= p; i++)
	{
		if(1 == i % 2)
		{
			flag = 1;
		}
		else if(i == 2)
		{
			flag = 1;
		}
		else 	flag = 0;
	}

	return flag;
}

void printMizzou(int n2)
{
	int i;
	
	for(i = 1; i <= n2; i++)
	{
		if((0 == (i % 3)) && (0 == (i % 5)) )
		{
			printf(" MIZZOU, ");	
		}
		else if(0 == (i % 3))
		{
			printf(" MIZ, ");
		}
		else if(0 == (i % 5))
		{
			printf(" ZOU, ");
		}
		else
		
		printf("%d, ", i);
	}
}
