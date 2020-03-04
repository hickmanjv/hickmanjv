# Bank Account Class

class BankAccount:

    # Method accepts an arguement for the account
    # balance. It's assigned to the __balance attribute
    def __init__(self, bal):
        self.__balance = bal

    # Method to make a deposit into the account
    def deposit(self, amount):
        self.__balance += amount

    # Method to make a withdraw on the account
    # This will not occur if funds are not available in
    # the amount requested
    def withdraw(self, amount):
        if self.__balance >= amount:
            self.__balance -= amount
        else:
            print('Error: Insufficient funds')

    # Method to return the account balance
    def get_balance(self):
        return self.__balance

    # String to indicate an objects state
    def __str__(self):
        return 'The balance is $' + format(self.__balance, ',.2f')
