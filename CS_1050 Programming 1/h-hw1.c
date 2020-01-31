// hickmanjv - Josh Hickman
// CS1050 Homework 1
// 2/10/18 Spring 2018

#include <stdio.h>
#include <math.h>

int   charge(int);		//prototype of function to get customers charge
void  displayMenu();		//prototype of function to display options
int   errorCheck(int);		//prototype of function to check inputs for displayMenu()
int   errorCheckUnits(int);	//prototype of function to check valid unit inputs
float getRate(int, int);	//prototype of function to take in values and determine rate

int main(void)
{	
	// declaring and initializing variables
	int util_type = 0, flag = 0, units = 0, count = 0, loop = 1, i = 0, num1 = 0, result = 0, odd = 0, even = 0;
	float rate = 0, en_chrg = 0, cust_chrg = 0, total_bill = 0, prog_total = 0;

	// loop to control how many times you want to calculate the bill
	while(1 == loop)
	{
		printf("***** ELECTRICITY BILL CALCULATOR *****\n\n\n");

		// loop to display the menu options and error check for correct input
		while(0 == flag)
		{
			displayMenu();
			scanf("%d", &util_type);
			flag = errorCheck(util_type);
		}
		flag = 0;	// reset the flag for the next loop

		printf("\n\nEnter the number of units (in kWh): ");
	
		// loop to error check the units entered and ensure vaild input
		while(0 == flag)
		{
			scanf("%d", &units);
			flag = errorCheckUnits(units);
		}
		flag = 0;	// reset the flag for the next loop
	
		rate =  getRate(units, util_type);		// assign correct rate based on inputs
		en_chrg = units * (rate/100);			// calculate the energy total of the bill
		cust_chrg = (float) charge(util_type);		// assign the correct customer charge based on account type
		total_bill = en_chrg + cust_chrg;		// calculate the total bill

		// displaying the totals
		printf("\n\nTotal energy charge for the customer is: $%.2f", en_chrg);
		printf("\n\nTotal Bill due from this connection is: $%.2f", total_bill);
		
		// prompt to calculate another bill
		printf("\n\nDo you want to continue and calculate another bill? If Yes enter 1 else 0: ");
		scanf("%d", &loop);

			// loop to errorcheck and ensure only 1 or 0 is entered
			while(loop < 0 || loop  > 1)
			{
				printf("Error! Program only recognizes 1 or 0 to continue or quit, please try again: ");
				scanf("%d", &loop);
			}

		count++;				// iterate count variable to track total bill calculations
		prog_total += total_bill;		// add total to a program total to track amount run by program
	}

	// display program totals
	printf("\n\n\nYou calculated the bill %d time(s) and the total amount from all the bills due is $%.2f\n\n", count, prog_total);
	printf("\n\n\nEXITING ELECTRICITY BILL CALCULATOR");
	
	// Bonus section of program
	printf("\n\n*** BONUS ***\n\n");
	printf("Enter a number: ");
	scanf("%d", &num1);
		
		// Loop to ensure only positive numbers are selected
		while(num1 < 0)
		{
			printf("\nError! Please enter a positive number: ");
			scanf("%d", &num1);
		}

	printf("\nThe numbers are: ");	

		for(i = 0; i <= num1; i++)		// loop to iterate through given number
		{
			printf("%d ", i);

			result += i;			// adding the numbers together

			if(1 == (i % 2))		// selection for even/odd numbers and totals them
			{
				odd += i;
			}
			else
			{
				even += i;
			}
		}

	printf("\n\nThe sum of all numbers from 0 to %d is %d", num1, result);
	printf("\n\nSum of Even numbers = %d", even);
	printf("\n\nSum of Odd numbers = %d", odd);
	printf("\n\n");

	return(0);
}

void displayMenu()			// function to display menu prompts 
{
	printf("1. Residential\n\n");
	printf("2. Commercial\n\n");
	printf("3. Industrial\n\n\n");
	printf("Choose the type of connection: ");
}

int errorCheck(int util_type)		// function to errorcheck correct choice of uitlity type
{
	if(util_type < 1 || util_type > 3)
	{
		printf("\n\nInvalid Choice! Please enter a valid choice\n");
		return 0;
	}
	else	return 1;
}

int errorCheckUnits(int units)		// function to errorcheck unit input and ensure positive input
{
	if(units < 0)
	{
		printf("\n\nInvalid input! Please enter a positive value: ");
		return 0;
	}
	else	return 1;
}

float getRate(int units, int util_type)	// function to return the correct rate based on account type and kWh
{
 	float rate = 0;
	
	if(1 == util_type)		// Rates for Residential Customers
	{
		if(units >= 0 && units <= 300)
		{
			rate = 7.50;
		}
		else if (units > 300 && units <= 750)
		{
			rate = 10.00;
		}
		else if (units > 750 && units <= 1500)
		{	
			rate = 13.50;
		}
		else	rate = 15.00;
	}


	if(2 == util_type)		// Rates for Commercial customers
	{
		if(units >= 0 && units <= 300)
		{
			rate = 10.50;
		}
		else if(units > 300 && units <=750)
		{
			rate = 14.00;
		}
		else if(units > 750 && units <=1500)
		{
			rate = 17.50;
		}
		else 	rate = 20.00;
	}

	if(3 == util_type)		// Rates for Industrial customers
	{
		if(units >=0 && units <= 300)
		{
			rate = 36.50;
		}
		else if(units > 300 && units <= 750)
		{
			rate = 40.00;
		}
		else if(units > 750 && units <= 1500)
		{
			rate = 45.50;
		}
		else 	rate = 50.00;
	}

	return rate;
}
int charge(int util_type)		// function to assign a charge based on account type
{
	if(1 == util_type)
	{
		// Residential customer
		return 25;
	}
	else if(2 == util_type)
	{
		// Commercial customer
		return 90;
	}
	else
	{
		// Industrial customer
		return 850;
	}
}
