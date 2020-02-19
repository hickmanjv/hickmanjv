"""
Name: Joshua Hickman
Pawprint: hickmanjv
Assignment: Random Number File Writer and Reader
Date: 02/18/20
"""

import random

def main():
    """ This program will ask the user to provide an amount of random numbers
         and the lower and upper bounds of those numbers. Then generate them,
         and write them out to a file, formatted to have 1 number per line. """

    # Getting the input of random numbers the user wants, handling exceptions
    while True:
        try:
            count = int(input("How many random numbers do you want? "))

            if count < 1:
                print("Invalid amount of random numbers, there has to be at least 1 or more."
                      + " Please try again:")
                continue
        except ValueError:
            print("The value you have entered is invalid. Positive numeric values only.")
        else:
            break

    # Getting the input of the lowest value of random numbers, handling exceptions
    while True:
        try:
            lower_bound = int(input("What is the lowest the random number should be: "))

            if lower_bound < 1:
                print("Invalid number value. No numbers lower than 1 are accepted. "
                      + "Please try again:")
                continue
        except ValueError:
            print("The value you have entered is invalid. Positive numeric values only.")
        else:
            break

    # Getting the input of the highest value of random numbers, handling exceptions
    while True:
        try:
            upper_bound = int(input("What is the highest the random number should be: "))

            if upper_bound < 1:
                print("Invalid number value. No numbers lower than 1 are accepted. "
                      + "Please try again:")
                continue
        except ValueError:
            print("The value you have entered is invalid. Positive numeric values only.")
        else:
            break

    try:
        # Open the file to write to
        random_num_file = open('randomnum.txt', 'w')

        # Loop to create the random numbers and write them to the file neatly
        for number in range(count):
            number = random.randint(lower_bound, upper_bound)
            random_num_file.write(str(number) + '\n')

        # Close the file
        random_num_file.close()

        print("The random numbers were written to randomnum.txt")

    except IOError:
        print("An error occured when trying to write the random numbers to the file,"
              + " randomnum.txt")

# Calling the main function
main()
