"""

"""

import contact
import pickle

# Global constants - menu choices
LOOK_UP = 1
ADD = 2
CHANGE = 3
DELETE = 4
QUIT = 5

# Global constant = filename
FILENAME = 'contacts.dat'

def get_menu_choice():
    print()
    print("Menu")
    print("-----------------------")
    print("1.  Look up a contact")
    print("2.  Add a new contact")
    print("3.  Change an existing contact")
    print("4.  Delete a contact")
    print("5.  Quit the program")
    print()
    
    choice = int(input('Enter your choice: '))

    while choice < LOOK_UP or choice > QUIT:
        print('\nError: not a valid menu choice...\n')
        choice = int(input('Enter a valid choice: '))

    return choice

def look_up(mycontacts):
    # Get a name to lookup
    name = input('Enter a name: ')

    # Look it up in the dictionary
    print(mycontacts.get(name, 'That name is not found. '))

def add(mycontacts):
    # Get the contact info
    name  = input('Name: ')
    phone = input('Phone: ')
    email = input('Email: ')

    # Create a contact object
    entry = contact.Contact(name, phone, email)

    # If the name does not exist in the dictionary, add it as a key
    # with the entry object as the as the value
    if name not in mycontacts:
        mycontacts[name] = entry
        print('The entry has been added.')
    else:
        print('That name already exists.')

def change(mycontacts):
    # Get a name to lookup
    name = input('Enter a name: ')

    if name in mycontacts:
        # Get a new phone number
        phone = input('Enter the new phone number: ')

        # Get a new email address
        email = input('Enter the new email address: ')

        # Create a contact object
        entry = contact.Contact(name, phone, email)

        # Update the entry
        mycontacts[name] = entry
        print('Information updated.')
    else:
        print('That name is not found.')

def delete(mycontacts):
    # Get a name to look up
    name = input('Enter a name: ')

    # If the name is found, delete the entry
    if name in mycontacts:
        del mycontacts[name]
        print('Entry deleted')
    else:
        print('That name is not found.')

def save_contacts(mycontacts):
    # Open the file
    out_file = open(FILENAME, 'wb')

    # pickle the dictionary and save it
    pickle.dump(mycontacts, out_file)

    # close the file
    out_file.close()

def load_contacts():
    try:
        # open the file
        contact_file = open(FILENAME, 'rb')

        # unpickle the dictionary
        contact_dictionary = pickle.load(contact_file)

        # close the file
        contact_file.close()
    except IOError:
        # could not open the file so create empty dictionary
        contact_dictionary = {}

    return contact_dictionary

def main():
    # load existing contact dictionary
    mycontacts = load_contacts()
    # initialize the variable for use choice
    choice = 0

    # Loop program until user wants to quit the program
    while choice != QUIT:
        # get user menu choice
        choice = get_menu_choice()

        if choice == LOOK_UP:
            look_up(mycontacts)
        elif choice == ADD:
            add(mycontacts)
        elif choice == CHANGE:
            change(mycontacts)
        elif choice == DELETE:
            delete(mycontacts)

    save_contacts(mycontacts)

# Call the main function
main()
