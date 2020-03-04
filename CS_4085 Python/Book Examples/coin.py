import random

class Coin:
    """ Class for the coin object, will provide methods
    for displaying the side of the coin and tossing it
    """
    # This method initializes the coins as Heads up
    # the public sideup attribute initially set to Heads
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
