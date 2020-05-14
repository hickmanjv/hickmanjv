"""



"""

from datetime import datetime

class Reservation:

    def __init__(self, first_name, last_name, party_size, time, month, day, year):
        self.__first_name = first_name
        self.__last_name = last_name
        self.__party_size = party_size
        self.__time = time
        self.__month = month
        self.__day = day
        self.__year = year

        now = datetime.now()

        self.__reserve_time = now.strftime("%m/%d/%Y %H:%M:%S")

    def get_first_name(self):
        return self.__first_name

    def get_last_name(self):
        return self.__last_name

    def get_party_size(self):
        return self.__party_size

    def get_time(self):
        return self.__time

    def get_month(self):
        return self.__month

    def get_day(self):
        return self.__day

    def get_year(self):
        return self.__year

    def get_reserve_time(self):
        return self.__reserve_time

    def __str__(self):
        info =  [self.__first_name, self.__last_name, self.__party_size, self.__time, self.__month, self.__day,
                 self.__year, self.__reserve_time]
        return str(info)
