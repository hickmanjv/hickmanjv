// hickmanjv - Josh Hickman
// CS1050 Homework 2 Section - H
// Spring 2018 03/05/18

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define ROW 6	// for row length
#define COL 4	// for column length
#define MAX 25	// for strings

const int costMatrix[ROW][COL] = {{500,200,200,500},	//global variable for seat price
				  {500,200,200,500},
			    	  {500,200,200,500},
			    	  {500,200,200,500},
			    	  {500,200,200,500},
			    	  {500,200,200,500}};

void initialSeats(char flight[][COL], int seats);			// prototype to initialize seats of the plane
void displayMenu();							// prototype to display the menu to the user
void printFlightMap(char flight[][COL]);				// prototype to display open/reserved seats on the plane
int  loginMatch(int passcode, int adminPasscode);			// prototype to check for admin mode login
int  getTotalRevenue(char f1[][COL], char f2[][COL], char f3[][COL]);	// prototype to total all revenue from flights
void flightMenu();							// prototype to show flight options
void seatReservation(char flight[][COL]);				// prototype to reserve a seat

int main(void)
{
	// declaring and initializing variables
	const int adminPasscode = 105016;
	int count = 0, option = 0, passcode = 0, pswdCheck = -1, fly = 0, revenue = 0;
	char flight1[ROW][COL], flight2[ROW][COL], flight3[ROW][COL];
	char name[MAX], *flight_number[MAX] = {"MIA1050", "BNA1050", "LAS1050"};

	srand(time(NULL));		// seeding the random number generator
	count = ((rand() % 5) + 1);	// assigning a random number for proir reservations on the plane

	initialSeats(flight1, count);	// initializing the random seat order on flight COU to MIA
	initialSeats(flight2, count);	// initializing the random seat order on flight COU to BNA
	initialSeats(flight3, count);	// initializing the random seat order on flight COU to LAS

	printf("********* WELCOME TO JOE'S AIRLINE BOOKING SYSTEM *********\n\n");

	do{	
		displayMenu();		// displays main menu for program		
		scanf("%d", &option);
	
			while(option < 1 || option > 3)		// loop to ensure a correct option is chosen
			{
				printf("\nWrong option! Choose a right optiona again\n\n"); 
				displayMenu();
				scanf("%d", &option);
			}// end while

			if(1 == option)		// admin mode option
			{
				printf("\nEnter the login passcode to log in as admin: ");
				scanf("%d", &passcode);
				pswdCheck = loginMatch(passcode, adminPasscode);	// returns 0 if password is wrong, 1 if correct

					while(0 == pswdCheck)	// loop to ensure entered password is correct
					{
						printf("Invalid Passcode combination\n\n");
						printf("Enter the login passcode to log in as admin: ");
						scanf("%d", &passcode);
						pswdCheck = loginMatch(passcode, adminPasscode);
					}// end while
				
				// prints the available/reserved seats for each flight while in admin mode
				printf("\nPrinting the Flight Map of flight Columbia to Miami....\n\n");
				printFlightMap(flight1);
				printf("Printing the Flight Map of flight Columbia to Nashville....\n\n");
				printFlightMap(flight2);
				printf("Printing the Flight Map of flight Columbia to Las Vegas....\n\n");
				printFlightMap(flight3);

				revenue = getTotalRevenue(flight1, flight2, flight3);	// assings total revenue from reserved seats on all flights
				printf("The total earnings from all of the flights: $%d\n\n", revenue);
				printf("You are logged out now!\n\n"); 
			}//end if
			else if(2 == option)	// reserve a seat options
			{
				printf("\n");
				flightMenu();	// prints the 3 flight options to the user
				scanf("%d", &fly);
				
					while(fly < 1 || fly > 3)	// loop to ensure a correct option is chosen
					{
						printf("\n");
						flightMenu();
						scanf("%d", &fly);
					}// end while

				printf("\nEnter your first name: ");	// ask user for name then assigns it into an array
				scanf("%s", name);
				printf("\n");

					if(1 == fly)	// reservation for COU to MIA
					{
						seatReservation(flight1);	// function to get appropriate seat from user
						printf("\nYour requested seat has been reserved\n\n");
						printFlightMap(flight1);	// showing the user that the seat they asked for is now reserved
						printf("Congratulations %s, your flight %s has been booked, enjoy your trip.\n\n", name, flight_number[0]);
					}
					else if(2 == fly)	// reservation for COU to BNA
					{
						seatReservation(flight2);	// function to get appropriate seat from user
						printf("\nYour requested seat has been reserved\n\n");
						printFlightMap(flight2);	// showing the user that the seat they asked for is now reserved
						printf("Congratulations %s, your flight %s has been booked, enjoy your trip.\n\n", name, flight_number[1]);
					}
					else		// reservation for COU to LAS
					{
						seatReservation(flight3);	// function to get appropriate seat from user
						printf("\nYour requested seat has been reserved\n\n");
						printFlightMap(flight3);	// showing the user that the seat they asked for is now reserved
						printf("Congratulations %s, your flight %s has been booked, enjoy your trip.\n\n", name, flight_number[2]);
					}	

				printf("Enjoy your Thanksgiving Break :)\n\n");
			}// end else if
			else
			{
			}// end else


		}while(3 != option);// end do-while

	printf("\nTerminating the Program\n\n");
	printf("Thank you for using Joe's Airline Booking System.\n\n");
	
	return(0);
}

void displayMenu()		// prints main menu for user
{
	printf("1.) Admin Log-in\n\n");
	printf("2.) Reserve a seat\n\n");
	printf("3.) Exit\n\n");
	printf("Choose an option: ");
}

int loginMatch(int passcode, const int adminPasscode)	// checks admin password, 0 for false, 1 for true
{
	if(passcode != adminPasscode)
	{
		return 0;
	}
	else	return 1;
}

void initialSeats(char flight[][COL], int count)	// initializes random seat reservations (X) and all other empty seats (O) for a flight
{
	int i, j, k;

	// loop to pre-assign passengers randomly
	for(k = 1; k <= count; k++)
	{
		int row = rand() % ROW;
		int col = rand() % COL;
		
		// if/else to ensure duplicate X doesn't happen
		if(flight[row][col] != 'X')
		{
			flight[row][col] = 'X';
		}
		else
		{
			k--;
		}
	}// end for
	
	// loop to assign open seats to array unless already occupied
	for(i = 0; i < ROW; i++)
	{
		for(j = 0; j < COL; j++)
		{
			// if/else to ensure occupied seat is not overwritten
			if(flight[i][j] == 'X')
			{
			}
			else
			{
				flight[i][j] = 'O';
			}
		}// end inner for
	}// end outer for
}

void printFlightMap(char flight[][COL])		// prints physical representation of inside of plane cabin
{
	int i, j;

	for(i = 0; i < ROW; i++)
	{
		for(j = 0; j < COL; j++)
		{
			printf("%c ", flight[i][j]);
		}// end inner for
		
		printf("\n\n");
	}// end outer for
}

void flightMenu()		// menu to choose which destination to fly to 
{
	printf("1.) COU ----> MIA\n\n");
	printf("2.) COU ----> BNA\n\n");
	printf("3.) COU ----> LAS\n\n");
	printf("Choose a flight: ");
}	

void seatReservation(char flight[][COL])	// function to reserve a seat on a flight, but not one already reserved
{
	int i, j;
	printFlightMap(flight);
	printf("Which seat row do you want?: ");
	scanf("%d", &i);
	
		while(i < 0 || i > 5)	// loop to ensure proper rows are chosen
		{
			printf("\nSeat rows are between 0 and 5.\n\n");
			printf("Try again. Which seat row do you want?: ");
			scanf("%d", &i);
		}// end while

	printf("\nWhich seat column do you want?: ");
	scanf("%d", &j);
	
		while(j < 0 || j > 3)	// loop to ensure proper columns are chosen
		{
			printf("\nSeat columns are between 0 and 3.\n\n");
			printf("Try again. Which seat column do you want?: ");
			scanf("%d", &j);
		}// end while

		while(flight[i][j] == 'X')	// loop to ensure an already reserved seat cannot be reserved again
		{
			printf("\nSorry!! someone has reserved that seat. Please Try Again.\n\n");
			printf("Which seat row do you want?: ");
			scanf("%d", &i);
				
				while(i < 0 || i > 5)
				{
					printf("\nSeat rows are between 0 and 5.\n\n");
					printf("Try again. Which seat row do you want?: ");
					scanf("%d", &i);
				}// end while

			printf("\nWhich seat column do you want?: ");
			scanf("%d", &j);

				while(j < 0 || j > 3)
				{
					printf("\nSeat columns are between 0 and 3.\n\n");
					printf("Try again. Which seat column do you want?: ");
					scanf("%d", &j);
				}// end while
		}// end while

	flight[i][j] = 'X';	// changes chosen seat to X if everything checks out
}

int getTotalRevenue(char f1[][COL], char f2[][COL], char f3[][COL])	// function to calculate a running total of all seats taken for all flights
{
	int i, j;
	int total = 0;

	for(i = 0; i < ROW; i++)
	{
		for(j = 0; j < COL; j++)
		{
			if(f1[i][j] == 'X')	// adds to running total - COU to MIA
			{
				total += costMatrix[i][j];
			}

			if(f2[i][j] == 'X')	// adds to running total - COU to BNA
			{
				total += costMatrix[i][j];
			}
	
			if(f3[i][j] == 'X')	// adds to running total - COU to LAS
			{
				total += costMatrix[i][j];
			}
		}// end inner for
	}// end outer for
	
	return total;
}

