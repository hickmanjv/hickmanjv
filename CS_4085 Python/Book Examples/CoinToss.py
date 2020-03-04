""" This will demonstrate basic class functionality in
    Python
"""

import random


class Coin:
    """ Class for the coin object, will provide methods
    for displaying the side of the coin and tossing it
    """
    # This method initializes the coins as Heads up
    # the public sideup attribute initially set to Heads
    def __init__(self):
        self.sideup = 'Heads'

    # This method will generate a random number, 0 or 1
    # and based on the result set the side of the coin to
    # either Heads or Tails
    def toss(self):
        if random.randint(0,1) == 0:
            self.sideup = 'Heads'
        else:
            self.sideup = 'Tails'

    # This method will return the value of the side that
    # is currently facing up on the coin
    def get_sideup(self):
        return self.sideup

class TrustyCoin:
    """
    """
    # This method initializes the coins as Heads up
    # the private sideup attribute initially set to Heads
    def __init__(self):
        self.__sideup = 'Heads'

    # This method will generate a random number, 0 or 1
    # and based on the result set the side of the coin to
    # either Heads or Tails
    def toss(self):
        if random.randint(0,1) == 0:
            self.__sideup = 'Heads'
        else:
            self.__sideup = 'Tails'

    # This method will return the value of the side that
    # is currently facing up on the coin
    def get_sideup(self):
        return self.__sideup

def main():

    # creating an object of the coin class
    my_coin = Coin()
    trustworthy_coin = TrustyCoin()
    
    # printing the current side facing up on the coin
    print('This side is up on Coin: ', my_coin.get_sideup())
    print('This side is up on TrustyCoin: ', trustworthy_coin.get_sideup())
    
    # sideup is not private so I can change it here
    my_coin.sideup = 'Tails'

    # sideup is private so this change won't occur
    trustworthy_coin.sideup = 'Tails'
    
    print('\nManipulating the side on Coin from Heads to Tails: ', my_coin.get_sideup())
    print('Manipulating the side on TrustyCoin from Heads to Tails: ', trustworthy_coin.get_sideup())
    
    # flipping the coin
    print('\nI am tossing the coins...')
    my_coin.toss()
    trustworthy_coin.toss()
    
    # printing the current side facing up on the coin
    print('\nThis side is up on Coin: ', my_coin.get_sideup())
    print('This side is up on TrustyCoin: ', trustworthy_coin.get_sideup())

main()
