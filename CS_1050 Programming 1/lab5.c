// hickmanjv - Josh Hickman
// CS1050 Lab 5 Section H

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void drinkMenu(void);			// function prototype for displaying a drink menu
void displayMenu(void);			// function prototype for displaying a menu
void displayReceipt(void);		// function prototype for displaying a receipt 
int errorCheck(int);			// function prototype for error checking
float calculateTax(float);		// function prototype for tax calculation
int calculateRandomDiscount(void);	// function prototype for calculating random discount


int main(void)
{
	int option = 0, error = -1, discount_num = -1, num = 0, winning_num = 0;
	float subtotal = 0, tax = 0, total = 0, discount = 0;

	srand(time(NULL));	// seeding the random number generator
	
	drinkMenu();
	scanf("%d", &option);
	error = errorCheck(option);	
		while(0 == error)
		{
			printf("Not a valid option! Please enter again: ");
			scanf("%d", &option);
			error = errorCheck(option);
		}
	
		switch(option)
		{
			case 1:
				subtotal += 0;
				break;
			case 2:
				subtotal =+ 1.00;
				break;
			case 3:
				subtotal += 1.50;
				break;
			case 4: 
				subtotal += 1.75;
				break;
			default:
				printf("Something went horribly wrong");
				break;
		}

	printf("\n\n");
	displayMenu();
	scanf("%d", &option);
	error = errorCheck(option);
		while(0 == error)
		{
			printf("Not a valid option! Please enter again: ");
			scanf("%d", &option);
			error = errorCheck(option);
		}
	
		switch(option)
		{
			case 1:
				subtotal += 4.50;
				break;
			case 2: 
				subtotal += 3.00;
				break;
			case 3: 
				subtotal += 5.00;
				break;
			case 4:
				subtotal += 7.20;
				break;
			default: 
				printf("Something went horribly wrong");
				break;
		}


	printf("\n\nThank you for your order! It will be made shortly!\n\n");
	printf("Subtotal: $%.2f\n", subtotal);
	tax = calculateTax(subtotal);
	printf("Taxes: $%.2f\n", tax);
	discount_num = calculateRandomDiscount();
	discount = subtotal * ((float) discount_num/100);
	printf("You get a random discount of %d%% on this meal\n", discount_num );
	total = ((subtotal + tax) - discount);
	printf("Total: $%.2f\n", total);
	displayReceipt();

	printf("\n\n****** BONUS ******\n\n");
	printf("Try to guess what number I am thinking of.\n");
	winning_num = (1 + rand() % 25);
	printf("Enter a number between 1 - 25: ");
	scanf("%d", &num);
	
		while(num < 1 || num > 25)
		{
			printf("Please try again: ");
			scanf("%d", &num);
		}

		while(num != winning_num)
		{
			if(num < winning_num)
			{
				printf("Your number is too low. Enter again: ");
				scanf("%d", &num);
			}
			else if(num > winning_num)
			{
				printf("Yourn number is too high. Enter again: ");
				scanf("%d", &num);
			}
			else
			{
			}
		}

	printf("\n\nCongratulations!! You won the game!\n");
	printf("Your number %d matched %d!\n\n", num, winning_num);

	return(0);
}

void drinkMenu()	// function to display the drink menu
{
	printf("What would you like to drink?\n");
	printf("1. Water: free\n");
	printf("2. Coke: $1.00\n");
	printf("3. Lemonade: $1.50\n");
	printf("4. Chocolate Milk: $1.75\n");
	printf("Enter an option: ");
}

void displayMenu()	// function to display the food menu
{
	printf("1. Cheeseburger: $4.50\n");
	printf("2. Hotdog: $3.00\n");
	printf("3. Chicken Strips: $5.00\n");
	printf("4. Fries and Burger Combo: $7.20\n");
	printf("Enter an option: ");
}

void displayReceipt()
{	
	int i;
	printf("Your receipt number is: #");
	for(i = 0; i < 8; i++)
		printf("%d", rand() % 10);
	
	printf("\n\n");
}

float calculateTax(float subT)
{
	if(subT <= 4.00)
	{
		return .50 + (subT * .10);
	}
	else
	{
		return .50 + (subT * .25);
	}
}

int errorCheck(int x)
{
	if(x < 1 || x > 4)
	{
		return 0;
	}
	else 	return 1;
}

int calculateRandomDiscount(void)
{
	return (1 + (rand() % 25));
}
