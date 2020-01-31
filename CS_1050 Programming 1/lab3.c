// hickmanjv - Josh Hickman
// CS1050 Lab3 Section H

#include <stdio.h>
#include <math.h>

int main(void)
{
	int flag = 1, year = 0, response = 0;
	float total = 0, principle = 0, rate = 0, interest = 0, num1 = 0, pow1 = 0, powResult = 0;

	while(1 == flag)
	{	
		printf("Bank account type\n\n");
		printf("(1) Checking \n(2) Saving \n(3) Fixed Deposit\n");
		printf("Please make a selection: ");
		scanf("%d", &response);

			while(response < 1 || response > 3)
			{
				printf("Incorrect choice, please make a choice again\n");
				printf("Bank account type\n\n");
				printf("(1) Checking \n(2) Saving \n(3) Fixed Deposit\n");
				printf("Please make a selection: ");
				scanf("%d", &response);
			}
		
		printf("Enter a year: ");
		scanf("%d", &year);
		
			while(year < 1 || year > 10)
			{
				printf("Incorrect value, year should be between 1-10\n");
				printf("Enter a year: ");
				scanf("%d", &year);
			}

		printf("\nEnter the amount: ");
		scanf("%f", &principle);
		
			while(principle <= 0)
			{
				printf("Incorrect value, enter the amount again\n");
				scanf("%f", &principle);
			}

		if(1 == response)
		{
			rate = 1;
			total = principle * pow((1 + (rate / 100)), year);
			interest = total - principle;
	
			printf("Total amount after %d years is $%.2f", year, total);
			printf("\nTotal interest earned on the amount $%.2f with the rate of %.2f%% is $%.2f", principle, rate, interest);
		}
		else if(2 == response)
		{
			rate = 9;
			total = principle * pow((1+(rate/100)), year);
			interest = total - principle;

			printf("Total amount after %d years is $%.2f", year, total);
			printf("\nTotal interest earned on the amount $%.2f with the rate of %.2f%% is $%.2f", principle, rate, interest);
		}
		else
		{	
			rate = 13;
			total = principle *pow((1+(rate/100)), year);
			interest = total - principle;

			printf("Total amount after %d years is $%.2f", year, total);
			printf("\nTotal interest earned on the amount $%.2f with the rate of %.2f%% is $%.2f", principle, rate, interest);
		}

		printf("\n\nDo you wish to calculate again?\n");
		printf("Press 0 for no, 1 for yes: ");
		scanf("%d", &flag);
			
			while(flag < 0 || flag > 1)
			{
				printf("Program needs a 0 to quit or 1 to continue, please enter a 0 or 1");
				scanf("%d", &flag);

			}

	}


		printf("\n\n********** Bonus part *********");
		printf("\n\nEnter a number: ");
			scanf("%f", &num1);
		printf("\n\nEnter an exponent: ");
			scanf("%f", &pow1); 
	
		powResult = pow(num1, pow1);

		printf("\n\npow(%f, %.0f) = %.2f", num1, pow1, powResult);
		printf("\n\n");

	return(0);
}
	
