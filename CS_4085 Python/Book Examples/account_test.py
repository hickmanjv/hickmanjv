import bankaccount as ba

def main():
    # Get the starting account balance
    start_bal = float(input('Enter your starting balance: '))

    # Create a BankAccount object
    savings = ba.BankAccount(start_bal)

    # using an alternate way to use __str__ function from a class
    message = str(savings)
    print(message)
    
    # Deposit the users paycheck
    # This won't account for negative values btw
    pay = float(input('How much were you paid this week? '))
    print('I will deposit $', format(pay, ',.2f'), ' into your account')
    savings.deposit(pay)

    # Display the balance
    """print('Your account balance is $',
          format(savings.get_balance(), ',.2f'))"""
    print(savings)

    # Get the amount to withdraw
    cash = float(input('How much would you like to withdraw? '))
    print('I will attempt to withdraw $', format(cash, ',.2f'),
          ' from your account')
    savings.withdraw(cash)

    # Display the balance
    """print('Your account balance is $',
          format(savings.get_balance(), ',.2f'))"""
    print(savings)
    
# Call the main function
main()
