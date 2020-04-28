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

""" ************************************************************ """

def get_message():
	"""
	This function will recieve an incoming message and decode it
	returning the decoded string making for easier manipulation
	"""
	incoming_message = client_socket.recv(1024)
	incoming_message = incoming_message.decode()
	return incoming_message

def send(message):
	"""
	This function will encode a string and send it to the client
	side. Default encoding for this version of Python is utf-8
	"""
	message = message.encode()
	client_socket.send(message)

def logout(client_socket):
	"""
	Close the socket
	"""
	#client_socket.shutdown()
	client_socket.close()

def login(UserID, Password):
	"""
	This function doesn't seem to be useful on the client side
	based on the sample output. The client invokes login in to 
	the server and the server verifies the information and lets
	the client login. The client shouldn't have access to login
	credentials on its side. If information were to be sent, 
	pickle the python object and send over.
	"""
	user_dictionary = {UserID : Password}
	message = pickle.dumps(user_dictionary)
	send(message)

def newuser(UserID, Password):
	"""
	This function doesn't seem to be useful on the client side
	we are just sending the information for processing on server
	side. If you were to send the information, make it an object
	and send over by pickling.
	"""
	user_dictionary = {UserID : Password}
	message = pickle.dumps(user_dictionary)
	send(message)

"""  ************************************************************ """

client_socket = socket.socket()
client_socket.connect((HOST, PORT))

print('\nMy chat room client. Version 1.00')

while True:
		
	message = input(str(">> "))
	
	if message == 'logout':
		send(message)
		logout(client_socket)
		break
	else:
		send(message)

	incoming_message = get_message()
	print(incoming_message)