"""
Name: Joshua Hickman
Pawprint: hickmanjv
Assignment: Challenge Tweet Manager
Date: 04/27/20
"""

import Tweet as tw
import pickle

# opening the pickled file and creating a global list of tweets, empty list if no file
try:
    with open('tweets.txt', 'rb') as file:
        tweet_list = pickle.load(file)
except:
    tweet_list = []

def display_menu():
    """ This function will display the program menu to the user """
    
    print("\nTweet Menu")
    print("------------------")
    print("1. Make a Tweet")
    print("2. View Recent Tweets")
    print("3. Search Tweets")
    print("4. Quit\n")


def make_tweet():
    """ This function will take in the information required to make a tweet
    and then append it to the tweet list, while checking for errors """
    
    author = input('What is your name? ')
    
    while True:
        message = input('What would you like to tweet? ')
        if len(message) > 140:
            print('Tweets can only be 140 characters!')
        else:
            tweet = tw.Tweet(author, message)
            tweet_list.append(tweet)
            print(tweet.get_author() + ', your tweet has been saved.')
            break

def view_tweets():
    """ This function will display the last 5 tweets that have been made
    in the program """
    
    print('\nRecent Tweets')
    print('------------------')

    if tweet_list:
        for tweet in tweet_list[-5:]:
            print(tweet.get_author() + ' - ' + tweet.get_age())
            print(tweet.get_text() + '\n')
    else:
        print('There are no recent tweets')

def search_tweets():
    """ This function will accept a phrase from the user and display
    any tweets that have that phrase in their message body to the
    user """
    
    check = 'no'
    
    if tweet_list:
        phrase = input("What would you like to search for? ")
        print('\nSearch Results')
        print('---------------------')
              
        for tweet in tweet_list:
            if phrase in tweet.get_text():
                print(tweet.get_author() + ' - ' + tweet.get_age())
                print(tweet.get_text() + '\n')
                check = 'yes'

        if check == 'no':
            print('No tweets contained ' + phrase)
    else:
        print('There are no tweets to search')
                

def main():
    """ This program will display a menu to the user, accept input
    that will be used for the make_tweet() funciton and save it to
    the tweet list if used. Or view and search tweets based on menu
    option chosen."""
    
    while(True):
        display_menu()
        menu_choice = input("What would you like to do? ")

        if menu_choice == '1':
            make_tweet()
            # saving the tweet to the pickled file
            with open('tweets.txt', 'wb') as file:
                pickle.dump(tweet_list, file)
        elif menu_choice == '2':
            view_tweets()
        elif menu_choice == '3':
            search_tweets()
        elif menu_choice == '4':
            print('Thank you for using the Tweet Manager!')
            break
        else:
            print('\nPlease enter 1, 2, 3, or 4 for the corresponding menu option')

# call the main function
main()
        
