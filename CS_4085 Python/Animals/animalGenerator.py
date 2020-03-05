"""
Name: Josh Hickman
Pawprint: hickmanjv
Assignment: Challenge: Animal Class
Date: 03/04/20
"""

import Animal as an

def main():
    """ Function that will prompt the user to create animal
    objects until the user decides to stop. Once the loop is
    terminated, the animal objects that were created will be
    displayed to the screen """

    # Program greeting and explaination
    print('Welcome to the animal generator!')
    print('This program creates Animal objects.')

    # variable assignment
    animal_list = []
    again = 'y'

    # main program loop, will prompt the user after creating each
    # animal object
    while again.lower() == 'y':
        
        # prompt the user for the type of animal
        animal_type = input('\nWhat type of animal would you like to create? ')

        while not animal_type.isalpha():
            print('Please enter a valid type of animal, no numbers should be used.')
            animal_type = input('\nWhat type of animal would you like to create? ')
            
        # prompt the user for the name of the animal
        # someone may name their animal something with a digit
        # not checking numeric input on purpose
        name = input("What is the animal's name? ")
            
        # create the animal object
        animal = an.Animal(animal_type, name)
        # add the animal to a list
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
        """
        print(animal)
        This would work fine here because of the __str__ function
        in the class file, but the specifications stated to access
        the attributes of the class by the methods below
        """
        print(animal.get_name() + ' the ' + animal.get_animal_type() +
              ' is ' + animal.check_mood())

# Call the main function
main()
