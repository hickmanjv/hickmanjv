"""
Name: Joshua Hickman
Pawprint: hickmanjv
Assignment: Random Number File Writer and Reader
Date: 02/18/20
"""

def main():
    """ This program takes the value entered into the randomnum.txt
         file, prints the numbers and provides a count of the total numbers
         in the file """

    count = 0

    try:
        # Opening the file
        random_num_file = open('randomnum.txt', 'r')

        print("List of random numbers in randomnum.txt:")

        # Loop to iterate through the file and print/count the amount of values
        # in the file
        for line in random_num_file:
            number = int(line)
            count += 1

            print(number)

        print("Random number count: ", count)
    except IOError:
        print("Error! Could not open randomnum.txt -- try running randomwrite.py first")

# Running the program
main()
