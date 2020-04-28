"""
Name: Joshua Hickman
Pawprint: hickmanjv
Assignment: Project ChatRoom Version 1
Date: 04/11/20
"""

import socket
import sys
import pickle

HOST = '127.0.0.1'
PORT = 16503
USERS = {}
FILE = 'users.txt'
SERVER_NAME = 'Server'
UserID = ''

""" ****************************************************** """

def make_dict(FILE):
	"""
	This function will take a file of names and passwords and
	convert it to a dictionary for python
	"""
	# opening the file
	user_file = open(FILE)
	# processing the file into a dictionary, stripping out
	# unwanted characters
	for line in user_file:
		item = line.split()
		key = str(item[0].strip('(,)'))
		value = str(item[1].strip('(,)'))
		USERS[key] = value
	# closing the file
	user_file.close()

def get_message():
	"""
	This function will recieve an incoming message and decode it
	returning the decoded string making for easier manipulation
	"""
	incoming_message = conn.recv(1024)
	incoming_message = incoming_message.decode()
	return incoming_message

def send(message):
	"""
	This function will encode a string and send it to the client
	side. Default encoding for this version of Python is utf-8
	"""
	message = message.encode()
	conn.send(message)

def login(UserID, Password):
	"""
	This function will check the username and password entered
	to verify matching values in the USERS dictionary
	"""
	if UserID in USERS and USERS[UserID] == Password:
		return True
	else:
		return False

def newuser(UserID, Password):
	"""
	This function will create a new user with specific name and
	password requirements and append to the users.txt file
	"""
	if UserID not in USERS:
		if len(UserID) < 32:
			if len(Password) >= 4 and len(Password) <= 8:
				with open(FILE, 'a') as f:
					f.write(f'\n({UserID}, {Password})')
				return True
			else:
				send(f'{SERVER_NAME}: Your password needs to be between 4 and 8 characters in length, please retry.')
		else:
			send(f'{SERVER_NAME}: {UserID} needs to be less than 32 characters long, please shorten it.')

	else:
		send(f'{SERVER_NAME}: {UserID} has already been used, please try a different username.')

	return False


def logout(conn):
	"""
	Close the socket
	"""
	#server_socket.shutdown()
	conn.close()
	server_socket.close()
""" ********************************************************* """

# Creating the server socket (TCP)
server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
# Binding the socket to the localhost and specified port
server_socket.bind((HOST, PORT))

print("\nMy chat room server. Version 1.00")

# Converting file data to a dictionary
make_dict(FILE)
#print(USERS)     Used to check make_dict function

# Listen for incoming connections
server_socket.listen(1)
# Accept the connection
conn, addr = server_socket.accept()

# Loop control
logged_off = True
loop = True

# main loop
while loop:
	# ensuring no messages can be sent until the user logs in, or creates
	# a newuser to log in with
	try:
		incoming_message = get_message()
		text = incoming_message.split()

		if logged_off and text[0] != 'login' and text[0] != 'newuser':
			raise Exception
			continue
	except Exception as e:
		send(f'{SERVER_NAME}: Denied. Please login first.')
	else:
		# Section for loggin in
		if text[0] == 'login':
			try:
				if len(text) != 3:
					raise Exception
					continue
				else:
					UserID = str(text[1])
					Password = str(text[2])
			except Exception as e:
				send(f'{SERVER_NAME}: Invalid login information, please include only a username and password.')

			if len(text) == 3:
				try:
					good_login = login(UserID, Password)
					if not good_login:
						raise Exception
						continue
				except Exception as e:
					send(f"{SERVER_NAME}: Username or password doesn't match a registered user.")
				else:
					send(f"{SERVER_NAME}: {UserID} joins")
					print(f'{UserID} login.')
					logged_off = False

		# Section for creating a new user
		if text[0] == 'newuser' and logged_off == True:
			try:
				if len(text) != 3:
					raise Exception
					continue
				else:
					UserID = str(text[1])
					Password = str(text[2])
			except Exception as e:
				send(f'{SERVER_NAME}: Invalid login information, please include only a username and password.')
			else:
				UserID = str(text[1])
				Password = str(text[2])
				good_newuser = newuser(UserID, Password)

				if good_newuser:
					send(f'{SERVER_NAME}: {UserID} is now a registered user, you may login now.')
					print(f'{UserID} has just been created.')
					# update dictionary of file data
					make_dict(FILE)
					continue
					
		# Section for sending multiple messages while logged in and
		# for logging out when finished
		while not logged_off:
			incoming_message = get_message()
			text = incoming_message.split()

			# Handling logout
			if incoming_message == 'logout':
				send(f'{SERVER_NAME}: {UserID} left.')
				print(f'{UserID} {incoming_message}.')
				loop = False
				logout(conn)
				break

			# Error message for trying to create a new user when logged in
			if text[0] == 'newuser':
				send(f'{SERVER_NAME}: Error, you cannot create a new user while logged in.')
				continue

			send(f'{UserID}: {incoming_message}.')
			print(f'{UserID}: {incoming_message}.')

logout(conn)
