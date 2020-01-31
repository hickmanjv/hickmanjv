#include <stdio.h>

int main(void)
{
	/* declaring variables and initializing */
	int num1 = 0, num2 = 0, total = 0;
	float divResult = 0;
	
	printf("Enter the first number: "); /* prompts the user */
	scanf("%d", &num1); /* read input from the user */

		while(num1 < 0)// loop to ensure non-negative number
		{	
			 printf("Enter a non-negative number: "); /*prompts the user*/
                         scanf("%d", &num1); /* read input from user*/
		}// end loop

	printf("\nEnter the second number: "); /*prompts the user*/
	scanf("%d", &num2); /* read input from user*/

		while(num2 < 0) // loop to ensure non-negative number
		{	
			printf("Enter a non-negative number: "); /*prompts the user*/
			scanf("%d", &num2);
		}// end loop

	printf("\nADDITION\n");
		total = num1 + num2; /* addition equation */
			printf("The sum of %d and %d is %d.\n", num1, num2, total); /*prints addition*/

	printf("\nSUBTRACTION\n");
		total = num1 - num2; // subtraction equation
			printf("The difference between %d and %d is %d.\n", num1, num2, total); //prints subtraction

	printf("\nMULTIPLICATION\n");
		total = num1 * num2; /* multiplication equation */
			printf("The product of %d and %d is %d.\n", num1, num2, total); /*prints multiplication*/

	printf("\nDIVISION\n");
		while(num2 == 0)// loop to ensure no division by 0
		{	
			printf("Cannot divide by zero!\nEnter a new number: "); //illegal division prompt
			scanf("%d", &num2); // read updated number two
				
				while (num2 < 0)// loop to remind user to use non-negative numbers
				{	
					printf("Please enter a non-negative non-zero number: "); // keeping non-negative numbers
					scanf("%d", &num2); // read non-negative and non-zero number
				}// end loop
		}// end loop

		divResult = (float) num1 / (float) num2; // type-casted division equation
	
			printf("%d divided by %d is %.2f.\n", num1, num2, divResult); //prints division
			
			if(num1 > num2) // if condition to test greater than or equality
			{	
				printf("\n%d is the bigger number\n", num1);
			
			}
			if(num2 > num1)
			{	
				printf("\n%d is the bigger number\n", num2);
			}

			if(num1 == num2)
			{
				printf("\nThose two numbers are equal\n");
			} // end greater than or equality conditional

	return(0);
}	
