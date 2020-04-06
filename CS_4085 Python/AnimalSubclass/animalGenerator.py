"""
Name: Josh Hickman
Pawprint: hickmanjv
Assignment: Challenge: Animal Subclass
Date: 04/03/20
"""

import Animal as an

def main():
    """ Function that will prompt the user to create animal objects
    until the user decides to stop. There are 2 types of Animal
    subclasses, Mammals and Birds. Once the loop is terminated
    the animal objects that were created will be displayed to the
    screen """

    # Program greeting and explaination
    print('Welcome to the animal generator!')
    print('This program creates Animal objects.')

    # variable assignment
    animal_list = []
    again = 'y'

    # main program loop, will prompt the user after creating each
    # animal object
    while again.lower() == 'y':

        print('\nWould you like to create a mammal or bird?')
        print('1. Mammal')
        print('2. Bird')
        # Catching errors for menu input items
        # Ensuring only 1 or 2 is selected for program to continue
        while True:
            try:
                animal_value = int(input('Which would you like to create? '))
                if animal_value > 2 or animal_value < 1:
                    raise Exception
                break
            except ValueError:
                print('Only enter a number specified by the selection menu')
            except Exception as e:
                print('Only enter a number specified by the selection menu')

        # if Mammal is selected
        if animal_value == 1:
            animal_type = input('\nWhat type of mammal would you like to create? ')
            
            # Ensuring no numbers in the Mammal type
            while not animal_type.isalpha():
                print('Please enter a valid type of mammal, no numbers should be used.')
                animal_type = input('\nWhat type of mammal would you like to create? ')

            # setting the Mammal's name
            mammal_name = input("What is the mammal's name? ")
            # setting the Mammal's hair color
            hair_color = input("What color is the mammal's hair? ")
            # create the Mammal object
            animal = an.Mammal(hair_color, animal_type, mammal_name)
            # add the Mammal to a list
            animal_list.append(animal)
        else:
            # if Bird is selected
            animal_type = input('\nWhat type of bird would you like to create? ')
            
            # Ensuring no numbers in the Mammal type
            while not animal_type.isalpha():
                print('Please enter a valid type of bird, no numbers should be used.')
                animal_type = input('\nWhat type of bird would you like to create? ')

            # setting the Bird's name
            bird_name = input("What is the bird's name? ")
            # setting the can_fly of the Bird
            flight = input('Can the bird fly? ')
            # create the Bird object
            animal = an.Bird(flight, animal_type, bird_name)
            # add the Bird to a list
            animal_list.append(animal)
            

        # prompt the user to create more animals or end the program
        again = input('\nWould you like to add more animals (y/n)? ')

    # displaying the animals that were created
    print('\nAnimal List: ')
    display_animals(animal_list)


def display_animals(animal_list):
    """ Function that will take a list of animal objects and
    loop through them printing in a specified format """

    # loop through the list of animals printing each one
    for animal in animal_list:
        print(animal.get_name() + ' the ' + animal.get_animal_type() +
              ' is ' + animal.check_mood())

# Call the main function
main()
