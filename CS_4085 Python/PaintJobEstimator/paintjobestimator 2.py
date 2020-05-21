"""
#   Name: Joshua HIckman
#   Pawprint: hickmanjv
#   Assignment: Paint Job Estimator
#   Date: 02/08/20
#   This version is changed based on the style guide and pylint
"""

import math

# Global Constants
LABOR_PER_HOUR = 62.25
GALLON_SQFT_COVERAGE = 350
SQFT_PER_HOUR = 58.33333                   # 350 sqft in 6 hours = 58.33333 sqft/hr


def main():
    """ Function that will take input from the user regarding how big the
        job is and how much the paint they have chosen costs per gallon.
        Then will display formated totals on the screen for the user to see
        how long a job will take and how much it will cost. """

    # General information displayed to the user about the program
    print("This program will help you calculate the total cost of your paint job.")
    print("We just need some initial information from you...\n")

    # setting loop condition variable
    another_job = True

    # main program loop
    while another_job:

        # exception handling for invalid input, allows program to keep running unitl valid input
        while True:
            try:
                square_foot = float(input("Please enter the square foot of the space to be"
                                          + "painted. Positive numbers only: "))

                if square_foot <= 0:
                    print("Invalid square foot entry. We cannot do a job for 0 square foot or"
                          + "less. Please enter a number greater than zero.")
                    continue
            except ValueError:
                print('The value you entered is invalid. Please enter a positive numeric value.')
            else:
                break

        # exception handling for invalid input, allows program to keep running unitl valid input
        while True:
            try:
                price = float(input('Please enter the price per gallon of paint you have chosen.'
                                    + ' Please do not include the "$": '))

                if price <= 0:
                    print("Invalid price entry. We need a correct price of the paint to be used."
                          + "Please enter a number greater than zero.")
                    continue
            except ValueError:
                print('The value you entered is invalid. Please enter a positive numeric value.')
            else:
                break

        # Get the number of hours the job will take
        hours = calc_labor_hours(square_foot)

        # Get the labor cost of the job
        labor = calc_labor_cost(hours)

        # Get the number of gallons needed for the job
        gallons = calc_gallons(square_foot)

        # Get the total cost of the paint for the job
        paint_cost = calc_cost_paint(gallons, price)

        # Get the total cost of the entire job
        total_price = total_job_cost(labor, paint_cost)

        # Display the totals to the user
        print('\nThe number of gallons of paint needed to do this job is: ', gallons)
        print('The hours of labor needed to complete the job is: ', format(hours, '.1f'))
        print('The cost of the paint is: $', format(paint_cost, '.2f'))
        print('The cost of the labor to do the job is: $', format(labor, '.2f'))
        print('The total cost of the entire job will be: $', format(total_price, '.2f'))
        print()

        # prompt the user to do another calculation or exit
        continue_program = input('Do you want to calculate another job? (y/n): ')

        # setting loop condition variable again to prevent infinite loop
        another_job = bool(continue_program in ('y', 'Y'))

def calc_labor_hours(square_foot):
    """ Function that will return the number of hours a job
        will take to complete """
    return square_foot / SQFT_PER_HOUR

def calc_labor_cost(hours):
    """ Function that will return the total labor cost of a job """
    return 62.25 * hours

def calc_gallons(square_foot):
    """ Function that will return the number of gallons needed
        for the job, rouned up so there will always be enough
        paint for the job """
    return math.ceil(square_foot / GALLON_SQFT_COVERAGE)

def calc_cost_paint(gallons, price):
    """ Function that will return total price of the paint """
    return gallons * price

def total_job_cost(labor, paint_cost):
    """ Function that will return the total cost of a job """
    return labor + paint_cost

main()
