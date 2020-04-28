"""
Name: Joshua Hickman
Pawprint: hickmanjv
Assignment: Challenge Tweet Manager
Date: 04/27/20
"""

import time

class Tweet:

    def __init__(self, author, text):
        self.__author = author
        self.__text = text
        self.__age = time.localtime(time.time())

    def get_author(self):
        return self.__author

    def get_text(self):
        return self.__text

    def get_age(self):
        now = time.localtime(time.time())
        # putting the different parts of time into a list for manipulation
        now = [now.tm_hour, now.tm_min, now.tm_sec]
        then= [self.__age.tm_hour, self.__age.tm_min, self.__age.tm_sec]

        hours = now[0] - then[0]
        # uses military time so if it's negative the += will correct to proper value
        if hours < 0:
            hours += 24
        
        minutes = now[1] - then[1]
        # if negative the += will correct to proper value
        if minutes < 0:
            minutes += 60
            
        seconds = now[2] - then[2]
        # if negative the += will correct to proper value
        if seconds < 0:
            seconds += 60

        # logic will return the highest value that is recorded i.e. 1hr 20min 30sec = 1hr
        if hours > 0:
            hours = str(hours) + 'h'
            return hours
        elif minutes > 0:
            minutes = str(minutes) + 'm'
            return minutes
        else:
            seconds = str(seconds) + 's'
            return seconds

    
