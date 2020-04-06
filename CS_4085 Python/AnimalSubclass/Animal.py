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

# Subclass of Animal
class Mammal(Animal):

    def __init__(self, hair_color, *args, **kwargs):
        super().__init__(*args, **kwargs)
        self.__hair_color = hair_color

    # returns the hair color of a Mammal
    def get_hair_color(self):
        return self.__hair_color

# Subclass of Animal
class Bird(Animal):

    def __init__(self, can_fly, *args, **kwargs):
        super().__init__(*args, **kwargs)
        self.__can_fly = can_fly

    # returns the flight status of a Bird
    def get_can_fly(self):
        return self.__can_fly
