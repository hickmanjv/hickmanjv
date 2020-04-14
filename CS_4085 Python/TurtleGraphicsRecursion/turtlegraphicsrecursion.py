"""
Name: Joshua Hickman
Pawprint: hickmanjv
Assignment: Challenge: Recursion and Python Turtle Graphics
Date: 04/08/20
"""

import turtle as t

def draw_tree(branch_length):
    
    if branch_length > 5:
        t.forward(branch_length)
        t.left(30)
        draw_tree(branch_length/1.2)
        t.right(60)     # needs to be double to go the other way
        draw_tree(branch_length/1.2)
        t.left(30)      # back 30 to get back to center
        t.backward(branch_length)

def main():
    t.showturtle()
    t.setup(800, 800)
    t.speed(0)
    t.bgcolor('gray')

    # initialzing position of 'turtle'
    t.left(90)
    t.penup()
    t.backward(200)
    t.pendown()

    # draw the fractal tree
    draw_tree(50)
    
    # keeps graphics window open
    t.done()

# call the main funciton
main()
