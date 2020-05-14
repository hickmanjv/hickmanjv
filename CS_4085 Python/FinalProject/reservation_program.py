"""
Name: Josh Hickman
Pawprint: hickmanjv
Asssignment: Final Project
Date: 05/04/20
"""

import reservation as res
import os
import pickle
import datetime
from random import randint
from pathlib import Path

# Global Variables
TABLES = 16         # there will be 16 Tables per time frame
DATE = datetime.datetime.now()
TIMES = {1 : '5:00PM', 2 : '6:30PM', 3 : '8:00PM', 4 : '9:30PM'}
MONTHS = {1 : 'January', 2 : 'February', 3 : 'March', 4 : 'April', 5 : 'May',
          6 : 'June', 7 : 'July', 8 : 'August', 9 : 'September', 10 : 'October',
          11 : 'November', 12 : 'December'}


def leap_year(year):
    """
    This function which return the correct days in February based on the year
    """
    if (year % 4) == 0:
        if (year % 100) == 0:
            if(year % 400) == 0:
                return 29
            else:
                return 28
        else:
            return 28
    else:
        return 28

def generate_res_num(first_name, last_name):
    """
    This function will return a reservation_id that can be used to track
    the reservation in the file system
    """
    return (first_name + last_name + str(randint(1000, 900000)))

def display_options():
    """
    Displays the main menu options
    """
    print()
    print('Welcome to our reservation interface!\n')
    print("1. Make a reservation")
    print("2. Check my reservation")
    print("3. Cancel my reservation")
    print("4. Quit")

def make_reservation():
    """
    This function will handle user input for the reservation system and
    generate the reservation object that will be serialized and stored as a
    file in the program folder. Directories will be created based on the year,
    month, and day that a reservation is for. There are only 16 available
    tables in the restaurant and no over-booking will be allowed to occur
    """
    while True:
        first_name = input('First Name: ')

        while not first_name.isalpha():
            print('Please enter a vaild first name, only letters are supported')
            first_name = input('First Name: ')
                
        last_name = input('Last Name: ')

        while not last_name.isalpha():
            print('Please enter a valid last name, only letters are supported')
            last_name = input('Last Name: ')

        while True:
            try:
                party = int(input('Party Size: '))

                if party < 1 or party > 4:
                    raise Exception
                    continue
                else:
                    break
            except Exception as e:
                print('Sorry, we only accept party sizes of 1 to 4 people')
                continue
            except ValueError:
                print('Only numerical values of 1 to 4 are accepted')
                continue

        print()
        print('Our reservation times are:')
        print('1 - 5:00PM to 6:30PM')
        print('2 - 6:30PM to 8:00PM')
        print('3 - 8:00PM to 9:30PM')
        print('4 - 9:30PM to 11:00PM')
        
        while True:
            try:
                time = int(input('\nWhich time frame would you like to make a reservation for? '))

                if time < 1 or time > 4:
                    raise Exception
                else:
                    time = TIMES[time]
                    break
            except ValueError:
                print('Please enter a number specified by the selection menu')
                continue
            except Exception as e:
                print('Please enter a number specified by the selection menu (1 - 4)')
                continue
        print()
        break

    while True:
        while True:
            try:
                year = int(input('Year: '))

                if year < DATE.year:
                    print("You cannot make a reservation before today's date, please try again.")
                    continue
                elif year > (DATE.year + 1):
                    print('Sorry, but we do not accept reservations that far in advance')
                    continue
            except ValueError:
                print('Please enter only numerical values')
            else:
                break
            
        while True:
            try:
                month = int(input('Month: '))

                if month < 1 or month > 12:
                    print('Please enter a valid month 1-12')
                    continue
                elif month < DATE.month and year == DATE.year:
                    print("You cannot make a reservation before today's date, please try again.")
                    continue
            except ValueError:
                print('Please enter only numerical values')
            else:
                break

        while True:
            try:
                day = int(input('Day: '))
                
                if day < 1 or day > 31:
                    print('Please enter a valid day of the month, (1, 2, 13, etc)')
                    continue
                elif month in [4, 6, 9, 11] and day > 30:
                    print("There are only 30 days in " + MONTHS[month])
                    continue
                elif month == 2:
                    actual_days = leap_year(year)
                    if day > actual_days:
                        print('There are only ' + str(actual_days) + ' days in February')
                        continue
                elif year == DATE.year and month == DATE.month and day < DATE.day:
                    print("You cannot make a reservation before today's date, please try again.")
                    continue
            except ValueError:
                print('Please enter only numerical values')
            else:
                break

        # ensures that a day will be 2 digits (i.e. 03 instead of 3)
        if len(str(day)) == 1:
            day = '0' + str(day)

        # concatenating a file path to create accurate directories/subdirectories
        path = str(year) + '/' + MONTHS[month] + '/' + str(day) + '/' + time

        # this is the reservation_id
        res_num = generate_res_num(first_name, last_name)

        # creating the reservation object
        reservation = res.Reservation(first_name, last_name, party, time, month, day, year)
        
        #print(reservation) -- testing the creation of reservation object

        # filename will be the same as the reservation_id to make reservation lookup easier
        filename = res_num

        # found this to help appropriately create a directory system in the program folder
        # https://stackoverflow.com/questions/273192/how-can-i-safely-create-a-nested-directory
        Path(path).mkdir(parents = True, exist_ok = True)

        # serializing the reservation and saving it to the appropriate subdirectory
        with open (path + '/' + filename, 'wb') as file:
            pickle.dump(reservation, file)

        # https://stackoverflow.com/questions/2632205/how-to-count-the-number
        # -of-files-in-a-directory-using-python
        # doesn't work when no reservation for that day is present - will make the
        # reservation, then cancel it if over-booking occurs
        path, dirs, files = next(os.walk(path))
        file_count = len(files)
        
        #print(file_count)  --  testing the file counting to ensure over-booking logic is accurate
        
        good_reservation = TABLES - file_count

        # Ensuring the restaurant cannot be overbooked for a time frame
        if good_reservation <= 0:
            delete_over_booking(res_num)
            print("\nWe're sorry, we are booked for that day, please choose a different date\n")
            continue
        else:
            break

    # gives the user their reservation id number
    print('\nYour reservation id is: ' + str(res_num) + ', Please retain this for later use.')

def check_reservation():
    """
    This function will check a reservation_id to see if you have a reservation in the system
    """
    reservation_id = input('Please enter your reservation id: ')
    filepath = []
    for root, dirs, files in os.walk(os.getcwd()):
        if reservation_id in files:
            filepath.append(os.path.join(root, reservation_id))
            break

    # this wll test if there is no reservation file in the system
    if filepath == []:
        print("\nWe are sorry, there doesn't seem to be a reservation on file for that id")
        return

    # if the file is found, then the serialized file will be loaded and decoded
    with open(filepath[0], 'rb') as file:
        res = pickle.load(file)

    # display the contents of the reservation file
    display_reservation(res)
    

def display_reservation(res):
    """
    This function will take in contents of the reservation file and display the formated
    contents to the user
    """
    f_name = res.get_first_name()
    l_name = res.get_last_name()
    month = res.get_month()
    day = res.get_day()
    year = res.get_year()
    party = res.get_party_size()
    time = res.get_time()
    reserve_time = res.get_reserve_time()

         
    print('\nName: ' + str(f_name) + ' ' + str(l_name))
    print('Date: ' + str(month) + '/' + str(day) + '/' + str(year))
    print('Party Size: ' + str(party))
    print('Time: ' + str(time))
    print('Reservation was made: ' + str(reserve_time))
    
def cancel_reservation():
    """
    This function will remove a reservation at the user's request
    providing feedback based on success.
    """
    reservation_id = input('Please enter your reservation id: ')
    filepath = []
    for root, dirs, files in os.walk(os.getcwd()):
        if reservation_id in files:
            filepath.append(os.path.join(root, reservation_id))
            break

    # This tests if no reservation is found
    if filepath == []:
        print('There is no reservation with that id to cancel')
        return

    os.remove(filepath[0])
    print("\nReservation has been successfully canceled")

def delete_over_booking(reservation_id):
    """
    This funciton will silently remove the reservation in the case of
    over-booking
    """
    filepath = []
    for root, dirs, files in os.walk(os.getcwd()):
        if reservation_id in files:
            filepath.append(os.path.join(root, reservation_id))
            break

    os.remove(filepath[0])

def remove_empty_dirs():
    """
    This function will walk through the directories in the program folder
    deleting any that have no files in them
    """
    # https://gist.github.com/jacobtomlinson/9031697
    # username elecs7g in the comments showed me how to remove empty directories
    path = os.getcwd()
    for (path, dirs, files) in os.walk(path, topdown = False):
        if files:
            # if there are files in the directory continue looping through the directory
            continue
        try:
            # if there aren't files then remove the empty directory
            os.rmdir(path)
        except OSError as ex:
            pass

def main():
    """
    This function will display the main program menu and allow the user to
    make, check, and cancel reservations. At the end of each program run,
    any empty directories will be deleted to keep program folders tidy
    """
    loop_control = 'y'
    
    while loop_control.lower() == 'y':
        display_options()

        try:
            option = int(input('\nWhat would you like to do? '))

            if option == 1:
                make_reservation()
            elif option == 2:
                check_reservation()
            elif option == 3:
                cancel_reservation()
            elif option == 4:
                break
            else:
                print('Please only enter one of the menu options above...')
                continue
        except ValueError:
            print('Please only enter one of the menu options above...')
            continue
        
        loop_control = str(input('\nWould you like to continue (y/n)? '))
        
    # clean up empty folders to keep program file un-cluttered
    remove_empty_dirs()

# calling the main methon
main()
