import coin

def main():
    # create an object of the Coin class
    my_coin = coin.Coin()

    # Display the side of the coin that is facing up
    print('This side is up: ', my_coin.get_sideup())

    # Toss the coin 10 times:
    print('I am going to toss the coin 10 times:')
    for count in range(10):
        my_coin.toss()
        print(my_coin.get_sideup())

# Call the main function
main()
