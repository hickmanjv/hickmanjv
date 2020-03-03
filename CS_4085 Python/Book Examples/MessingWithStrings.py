def main():

    # Strings are immutable!!
    
    count = 0

    my_string = input("Enter a sentence: ")

    for ch in my_string:
        if ch == 'T' or ch == 't':
            count += 1

    print("The letter T appears", count, "times.")

    new_string = "Roses are red"
    ch = new_string[6]
    print(ch)

    print(new_string[0], new_string[6], new_string[7], new_string[8], sep='')
    print(new_string[-1], new_string[-5], new_string[-7], new_string[-10], sep='')

    city = "San Francisco"
    size = len(city)

    print(size)

    letters = 'abc'
    letters += 'def'
    print(letters)

    name = 'Carmen'
    print('The name is', name)
    name = name + ' Brown'
    print('Now the name is', name)

    full_name = "John James Doe"
    middle_name = full_name[5:11]
    print(middle_name)

    letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    print(letters[0:26:2])
    print(letters[1:26:2])

    name_string = full_name[:]      # = name_string = full_name[0 : len(full_name)]
    print(name_string)

    first = input("Enter your first name: ")
    last = input("Enter your last name: ")
    idnumber = input("Enter your student ID number: ")

    print("Your system login name is: ")
    print(get_login_name(first, last, idnumber))
    print()
    
    text = 'Four score and seven years ago'

    if 'seven' in text:
        print('The string "seven" was found.')
    else:
        print('The string "seven" was not found.')
    print()
    
    names = "Bill Joanne Susan Chris Juan Katie"

    if "Pierre" not in names:
        print("Pierre was not found.")
    else:
        print("Pierre was found.")
    print()
    
    string1 = '1200'
    if string1.isdigit():
        print(string1, 'contains only digits.')
    else:
        print(string1, 'contains characters other than digits.')

    string2 = 'abc123'
    if string2.isdigit():
        print(string2, 'contains only digits.')
    else:
        print(string2, 'contains characters other than digits.')

    print()
    
    user_string = input("Enter a string: ")

    # not working if string is too long or using the word 'is'
    if user_string.isalnum():
        print('The string is alphanumeric.')
    if user_string.isdigit():
        print('The string contains only digits.')
    if user_string.isalpha():
        print('The string contains only alphabetic characters.')
    if user_string.isspace():
        print('The string contains only whitespace characters.')
    if user_string.islower():
        print('The letters in the string are all lowercase.')
    if user_string.isupper():
        print('The letters in the string are all uppercase.')

    print()
    filename = input('Enter the filename: ')

    if filename.endswith('.txt'):
        print("That is the name of a text file.")
    elif filename.endswith('.py'):
        print("That is the name of a Python source file.")
    elif filename.endswith('.doc'):
        print("That is the name of a word processing document.")
    else:
        print("Unknown file type.")

    print()
    string = 'Four score and seven years ago'
    position = string.find('seven')

    if position != -1:
        print('The word "seven" was found at index', position)
    else:
        print('The word "seven" was not found.')

    new_string1 = string.replace('years', 'days')
    print(new_string1)

    password = input("Enter your password: ")

    while not valid_password(password):
        print("That password is not valid.")
        password = input('Enter your password: ')

    print('That is a valid password')
    
        

def get_login_name(first, last, idnumber):

    set1 = first[0 : 3]
    set2 = last[0 : 3]
    set3 = idnumber[-3 :]

    login_name = set1 + set2 + set3

    return login_name
    

def valid_password(password):
    correct_length = False
    has_uppercase = False
    has_lowercase = False
    has_digit = False

    if len(password) >= 7:
        correct_length = True

        for ch in password:
            if ch.isupper():
                has_uppercase = True
            if ch.islower():
                has_lowercase = True
            if ch.isdigit():
                has_digit = True

        if correct_length and has_uppercase and \
           has_lowercase and has_digit:
            is_valid = True
        else:
            is_valid = False

        return is_valid

#Call the main function
main()
