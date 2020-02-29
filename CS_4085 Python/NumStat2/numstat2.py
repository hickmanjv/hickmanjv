"""
Name: Joshua Hickman
Pawprint: hickmanjv
Assignment: Number Stats - 2
Date: 02/27/20
"""


def main():
    """ Function that will open a file of integers, performing various
        operations on them and printing them to the screen. Accounts
        for different issues with the files
    """

    # Declaring program variables
    total = 0
    count = 0
    average = 0.0
    num_range = 0
    median = 0
    max_value = 0
    mode = []
    num_list = []
    number_counts = {}
    another_test = 'y'
    filename = 'numbers.txt'

    # main program loop
    while another_test.lower() == 'y':
        try:
            # opening the file to read data from
            number_file = open(filename, 'r')
            # get the first line of the file
            first_char = number_file.read(1)
            # get back to start of file
            number_file.seek(0)

            # if file is empty, notify the user and prompt loop condition
            if not first_char:
                print('There are no numbers in ' + filename)
                number_file.close()
                another_test = input('\nWould you like to evaluate another file? (y/n): ')

                if another_test.lower() == 'y':
                    filename = input('\n What is the name of the file you would like to evaluate? ')
                    print()
            # if the file is not empty continue with processing the data
            else:
                try:
                    # Loop processing the data from the file
                    for line in number_file:
                        # converting the str into an int
                        number = int(line)
                        # adding the number of the line to the list variable
                        num_list.append(number)

                        # calculating the values for each key in the dictionary
                        # to be used for finding the mode
                        if number in number_counts:
                            number_counts[number] += 1
                        else:
                            number_counts[number] = 1

                    # closing the file as soon as we are done with it
                    number_file.close()

                    # assigning the total sum of all numbers in the file
                    total = sum(num_list)
                    # assigning the number of numbers in the file
                    count = len(num_list)
                    # Get the average of the numbers in the file
                    average = total / count
                    # Get the range of numeric values
                    num_range = max(num_list) - min(num_list)

                    # sorting the list of numbers to find the median
                    num_list.sort()
                    # checking for an even or odd number of numbers in the file
                    # then finding the median based on even / odd
                    if count % 2 == 0:
                        index = (count -1) // 2
                        median = (num_list[index] + num_list[index + 1]) / 2.0
                    else:
                        index = (count-1) // 2
                        median = num_list[index]

                    # obtaining the maximum value of the keys for finding the mode
                    for key in number_counts:
                        value = number_counts[key]

                        if value > max_value:
                            max_value = value

                    # creating a list of the most used numbers in the file aka mode
                    for key in number_counts:
                        if number_counts[key] == max_value:
                            mode.append(key)

                    # Printing the formatted operations to the screen
                    print("File name: ", number_file.name)
                    print("Sum: ", total)
                    print("Count: ", count)
                    print("Average: ", average)
                    print("Maximum: ", max(num_list))
                    print("Minimum: ", min(num_list))
                    print("Range: ", num_range)
                    print("Median: ", median)
                    print("Mode: ", mode)
                except IOError:
                    print("\nCould not open the file " + filename + ", please check the file.")

                # resetting variables to ensure clean loops
                num_list.clear()
                mode.clear()
                number_counts.clear()
                max_value = 0
                value = 0

                # prompt for program loop
                another_test = input('\nWould you like to evaluate another file? (y/n): ')

                if another_test.lower() == 'y':
                    filename = input('\n What is the name of the file you would like to evaluate? ')
                    print()
        except IOError:
            print('\nCould not open the file ' + filename + ', please check the file.')

# Run the main program
main()
