"""
Name: Josh Hickman
Pawprint: hickmanjv
Assignment: Challenge: Animal Class
Date: 03/04/20
"""
from random import randint

# Class for a user defined animal and name
# the mood of the animal will be random
class Animal:
    
    # method initialize the animals, setting the mood
    # randomly based on 3 different moods
    def __init__(self, animal_type, name):
        self.__animal_type = animal_type
        self.__name = name

        if randint(1, 3) == 1:
            self.__mood = 'happy'
        elif randint(1, 3) == 2:
            self.__mood = 'hungry'
        else:
            self.__mood = 'sleepy'

    """
    # Looks as though the Challenge doesn't want the setters
    
    def set_animal_type(self, animal_type):
        self.__animal_type = animal_type

    def set_name(self, name):
        self.__name = name

    # this method will set the mood of the animal
    # to 1 of 3 randomly selected moods
    def set_mood(self):
        if random.randint(1,3) == 1:
            self.__mood = 'happy'
        elif random.randint(1,3) == 2:
            self.__mood = 'hungry'
        else:
            self.__mood = 'sleepy'
    """

    # returns the type of the animal
    def get_animal_type(self):
        return self.__animal_type
    # returns the name of the animal
    def get_name(self):
        return self.__name
    # returns the mood of the animal
    def check_mood(self):
        return self.__mood

    # returns the state of an animal object
    def __str__(self):
        return self.__name + ' the ' + self.__animal_type + ' is ' + self.__mood
