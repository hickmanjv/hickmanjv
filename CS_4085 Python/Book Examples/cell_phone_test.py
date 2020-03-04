import cellphone as cp

def make_list():
    # Create an empty list
    phone_list = []

    # Add 5 phone objects to the list
    print('Enter data for five phones.')
    for count in range(1, 6):
        print('Phone number ' + str(count) + ':')
        man = input('Enter the manufacturer: ')
        mod = input('Enter the model number: ')
        retail = float(input('Enter the retail price: '))
        print()

        # Create phone object in memory
        phone = cp.CellPhone(man, mod, retail)

        # Add phone object to the list
        phone_list.append(phone)

    return phone_list

def display_list(phone_list):
    for item in phone_list:
        print(item.get_manufact())
        print(item.get_model())
        print(item.get_retail_price())
        print()

def main():

    phones = make_list()

    """man = input('Enter the manufacturer: ')
    mod = input('Enter the model number: ')
    retail = float(input('Enter the retail price: '))
    print()
    
    phone = cp.CellPhone(man, mod, retail)
    message = str(phone)
    print(message)"""

    print('Here is the data you entered:\n')
    display_list(phones)

# Call the main function
main()
