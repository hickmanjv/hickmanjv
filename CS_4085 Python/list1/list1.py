"""
Name: Joshua Hickman
Pawprint: hickmanjv
Assignment: Challenge: Lists1
Date: 03/27/20
"""

def display_list(label, items):
    """ This function will print the label provided to the function
    and then print each item in the list that is provied """
    print(label)
    #print(*items, sep='\n')   needs to be 'for-in'  for the requirements
    for item in items:
        print(item)

def main():
    """ This is the main function which will create a list of food items
    then print them in various ways to display the different functions
    and abilities of lists in python """
    
    foods = ['pizza', 'salad', 'hamburger', 'steak', 'apple', 'orange']

    display_list("foods in original order:", foods)

    # sorting the food list in-place 
    foods.sort()
    display_list("foods in ascending alphabetical order:", foods)

    # sorting the food list in-place but displaying in reverse
    foods.sort(reverse = True)
    display_list("foods in descending alphabetical order:", foods)

    # copying the sorted foods list into another list variable
    foods2 = sorted(foods)
    display_list("foods2 in ascending alphabetical order:", foods2)
    display_list("foods still in descending alphabetical order:", foods)
    
    # reversing the sorted list that had already been reversed
    foods.reverse()
    display_list("foods in ascending alphabetical order:", foods)

    # appending more foods to the list
    foods.append('carrots')
    foods.append('milk')
    display_list("sorted foods with carrots and milk appended to the end:", foods)

    # sorting the list that had the appended items tacked on
    foods.sort()
    display_list("foods in ascending alphabetical order:", foods)

    # finding the index of pizza in the list
    pizza_index = foods.index('pizza')
    print("Pizza is at", pizza_index)

    # inserting a new food in at the index that pizza was in
    foods.insert(pizza_index, 'fries')

    # finding the new index of pizza in the list
    pizza_index = foods.index('pizza')
    print("Pizza is now at", pizza_index)


# call the main function
main()
