#*******************************************************************************************************************
# Name: Joshua Hickman
# Pawprint: hickmanjv
# Assignment: Improved Object Position Calculation
# Date: Feb 7, 2020
#
# - I didn't realize we were going to implement more of the functions and exception handling
#  with this assignment when I did the previous one. Will clean it up here
#*******************************************************************************************************************

def main():

    # Explain to the user what the program is for
    print("This program will calculate the final position of an object after\n" +
          "recieving input from the user regarding: initial position, velocity,\n" +
          "acceleration, and how much time the object traveled.")
    print("\nPlease only enter positive values...")

    # Set boolean value for program loop
    run_calculation = True

    # Loop to keep running program
    while(run_calculation):

        # Block of statements to handle any input errors when obtaining initial position
        while(True):
            try:
                initial_position = float(input("\nPlease enter the object's initial position: "))

                if(initial_position < 0):
                    print('Negative initial positions are not allowed, please enter a positive number.')
                    continue
            except ValueError:
                print('The value you entered is invalid. Please enter a positive numeric value.')
            else:
                break

        # Block of statements to handle any input errors when obtaining initial velocity
        while(True):
            try:
                initial_velocity = float(input("\nPlease enter the object's initial velocity: "))

                if(initial_velocity < 0):
                    print('Negative initial velocities are not allowed, please enter a positive number.')
                    continue
            except ValueError:
                print('The value you entered is invalid. Please enter a positive numeric value.')
            else:
                break

        # Block of statements to handle any input errors when obtaining acceleration
        while(True):
            try:
                acceleration = float(input("\nPlease enter the object's acceleration: "))

                if(acceleration < 0):
                    print('Negative acceleration is not allowed, please enter a positvie number.')
                    continue
            except ValueError:
                print('The value you entered is invalid. Please enter a positive numeric value.')
            else:
                break

        # Block of statements to handle any input errors when obtaining time
        while(True):
            try:
                time = float(input("\nPlease enter how much time has passed in seconds: "))
                
                if(time < 0):
                    print('Negative time values are not allowed, please enter a positve number.')
                    continue
            except ValueError:
                print('The value you entered is invalid. Please enter a positive numeric value.')
            else:
                break
                
        # Calculate final position of the object   
        final_position = Calc_Displacement(initial_position, initial_velocity, acceleration, time)

        # Show the user how far the object traveled
        print("\nThe final position of the object is", format(final_position, '.1f'), "meters.\n")

        # Prompt the user to re-run the program
        another_calculation = input("\nDo you want to run another calculation? (y/n): ")

        # Refresh boolean variable to continue or exit main while loop
        if (another_calculation == "y" or another_calculation == "Y"):          #  found  this method:  if another_calculation in ["y", "Y"]:
            run_calculation = True                                                                   #     run_calculation = False              credit:  pseudocubic on stackoverflow.com/questions/21790669
        else:                                                                                                   # "" I couldn't find documentation on why this worked. ""
            run_calculation = False
        
    

#*************************************************************************************************
# Function to calculate the final position of an object in meters
#   - This function will use the formula for calculating an objects displacment
#*************************************************************************************************

def Calc_Displacement(init_position, init_velocity, acceleration, time):
    
    return (init_position + (init_velocity * time) + (0.5 * (acceleration * (time * time))))


#*******************************
# Call the main program
#*******************************
main()
