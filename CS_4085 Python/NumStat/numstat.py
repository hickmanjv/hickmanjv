"""
Name: Joshua Hickman
Pawprint: hickmanjv
Assignment: Number Stats
Date: 02/19/20
"""


def main():
    """ Function that will open a file of integers, performing various
        operations on them and printing them to the screen """

    total = 0
    count = 0
    average = 0.0
    num_range = 0
    num_list = []

    try:
        # Opening the file to read the information
        number_file = open('numbers.txt', 'r')

        # Loop processing the data from the file
        for line in number_file:
            number = [int(line)]
            total += number[0]      # list 'number' stays at index 0
            count += 1
            num_list += number

        # closing the file as soon as we are done with it
        number_file.close()

        # Get the average of the numbers in the file
        average = calc_average(total, len(num_list))

        # Get the range of numeric values
        num_range = calc_range(max(num_list), min(num_list))

        # Printing the formatted operations to the screen
        print("File name: ", number_file.name)
        print("Sum: ", total)
        print("Count: ", count)
        print("Average: ", average)
        print("Maximum: ", max(num_list))
        print("Minimum: ", min(num_list))
        print("Range: ", num_range)
    except IOError:
        print("Could not open the file numbers.txt, please check the file.")


def calc_average(total, count):
    """ Function that will return the average of a set of numbers """
    return float(total / count)

def calc_range(maximum, minimum):
    """ Function that will return the numeric range of a set of numbers """
    return maximum - minimum

# Run the main program
main()
