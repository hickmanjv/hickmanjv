"""
Name: Josh Hickman
Pawprint: hickmanjv
Assignment: Challenge: Cipher
Date: 04/17/20
"""

# Cipher based on assignment requirements
CIPHER = {'a' : '0', 'b' : '1', 'c' : '2', 'd' : '3', 'e' : '4', 'f' : '5',
	  'g' : '6', 'h' : '7', 'i' : '8', 'j' : '9', 'k' : '!', 'l' : '@',
	  'm' : '#', 'n' : '$', 'o' : '%', 'p' : '^', 'q' : '&', 'r' : '*',
	  's' : '(', 't' : ')', 'u' : '-', 'v' : '+', 'w' : '<', 'x' : '>',
	  'y' : '?', 'z' : '=', ' ' : ' '}

def encode_message(message):
        """
        Function that will take in a string of alphabetic characters
        and swap them out for the corresponding character in the
        CIPHER dictionary
        """
        new_message = ""
        
        # convert the message to a list for character swap
        char_list = list(message)
        
        # loop through the list exchanging the value and key of
        # the CIPHER dictionary
        for char in char_list:
                char_list[char_list.index(char)] = CIPHER[char]

        # put the message list back into a string
        new_message = new_message.join(char_list)
        
        print('Encoded message: ' + new_message)

def decode_message(message):
        """
        This function will take in a message of digits and symbols and
        convert it back to plain text based on the CIPHER dictionary
        """
        new_message = ""

        # convert the message to a list for character swap
        char_list = list(message)

        # Invert the key/value pairs in the CIPHER to make it easier
        # to exchange the characters for decoding
        inverted_cipher = dict([i, j] for j, i in CIPHER.items())

        # loop through the list exchanging the key and value with
        # the inverted CIPHER dictionary
        for char in char_list:
                char_list[char_list.index(char)] = inverted_cipher[char]

        # put the message list back into a string
        new_message = new_message.join(char_list)
        
        print('Decoded message: ' + new_message)
              
def main():
        """
        This is the main function of the program, it will display a selection menu to
        the user and accept proper input to make the CIPHER work properly
        """
        # loop variable
        option = True

        while option:
                # Main program selection menu
                print('\nWelcome to the Secret Message Encoder/Decoder')
                print('1. Encode a message')
                print('2. Decode a message')
                print('3. Exit')

                while True:
                        # Preventing invalid input from the user
                        try:
                                menu_option = int(input('\nWhat would you like to do? ' ))

                                if menu_option < 1 or menu_option > 3:
                                        raise Exception
                                break
                        except ValueError:
                                print('\nOnly enter a number specified by the selection menu, try again.')
                        except Exception as e:
                                print('\nOnly enter a number specified by the selection menu, try again.')
                                
                if menu_option == 1:
                        while True:
                                # Ensures the user only enters digits or symbols so that the
                                # inverted CIPHER and decode function will work properly
                                try:
                                        message = input(str('\nEnter a message to encode: '))
                                        
                                        # loop through each character checking, throwing an exception
                                        # if a digit or symbol is found
                                        # Found the use of all() on W3Schools.com for Python
                                        if not all(char.isalpha() or char.isspace() for char in message):
                                                raise Exception
                                        break
                                except Exception as e:
                                        print('\nPlease enter a message that only has letters to encode.')
                                        
                        encode_message(message.lower())
                elif menu_option == 2:
                        while True:
                                # Ensures the user only enters digits or symbols so that the
                                # inverted CIPHER and decode function will work properly
                                try:
                                        message = input(str('\nEnter a message to decode: '))
                                        
                                        # loop through each character checking, throwing an exception
                                        # if an alphabetic character is found
                                        for char in message:
                                                if char.isalpha():
                                                        raise Exception
                                                        break
                                        break
                                except Exception as e:
                                        print('\nPlease enter a message that only has numbers and/or symbols to decode.')
        
                        decode_message(message)
                else:
                        # else option 3 is the only option that could have been selected based on valid menu input
                        option = False

# call the main function
main()
