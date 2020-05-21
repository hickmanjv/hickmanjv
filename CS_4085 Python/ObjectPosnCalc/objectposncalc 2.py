#************************************************************
# Name: Joshua Hickman                                      *
# Pawprint: hickmanjv                                       *
# Assignment: Object Position Calculation                   *
# Date: Feb 2, 2020                                         *
#************************************************************

def main():

    # Explain to the user what the program is for
    print("This program will calculate the final position of an object after\n" +
          "recieving input from the user regarding: initial position, velocity,\n" +
          "acceleration, and how much time the object traveled.")
    print("\nPlease only enter positive values...")

    # Get float value for the object's initial position
    initial_position = float(input("\nPlease enter the object's initial position: "))

    # Error handling for negative values entered as input
    while(initial_position < 0):
        print("\nERROR: only positive values are accepted for this program!\n")
        initial_position = float(input("Please enter the object's initial position: "))

    # Get float value for the objects initial velocity
    initial_velocity = float(input("Please enter the object's initial velocity: "))

    # Error handling for negative values entered as input
    while(initial_velocity < 0):
        print("\nERROR: only positive values are accepted for this program!\n")
        initial_velocity = float(input("Please enter the object's initial velocity: "))

    # Get float value for the objects acceleration   
    acceleration = float(input("Please enter the object's acceleration: "))

    # Error handling for negative values entered as input
    while(acceleration < 0):
        print("\nERROR: only positive values are accepted for this program!\n")
        acceleration = float(input("Please enter the object's acceleration: "))

    # Get float value for the time the object traveled   
    time = float(input("Please enter how much time has passed: "))

    # Error handling for negative values entered as input
    while(time < 0):
        print("\nERROR: only positive values are accepted for this program!\n")
        time = float(input("Please enter how much time has passed: "))

    # Calculate final position of the object   
    final_position = ObjectPositionCalc(initial_position, initial_velocity, acceleration, time)

    # Show the user how far the object traveled
    print("\nThe final position of the object is", format(final_position, '.1f'), "meters.")
    

#*********************************************************************************
# Function to calculate the final position of an object in meters                *
#   - This function will use the formula for calculating an objects displacment  *
#*********************************************************************************

def ObjectPositionCalc(init_position, init_velocity, acceleration, time):
    
    return (init_position + (init_velocity * time) + (0.5 * (acceleration * (time * time))))


#*************************
# Call the main program  *
#*************************
main()
