"""
Name: Joshua Hickman
Pawprint: hickmanjv
Assignment: Challenge Gradebook
Date: 03/13/20
"""

def calc_student_average(gradebook):
    """
    Function that will take in a list of students and return
    a list of average grades for each student
    """
    return [sum(grades)/len(grades) for grades in gradebook]

def calc_assignment_average(assignment_list):
    """
    Function that will take in a list of assignments and return
    a list of average grades for each assignment
    """
    return [sum(grades)/len(grades) for grades in assignment_list]

def change_list(gradebook):
    """
    Function that will take in a 2D list and change rows and columns
    in this case, swapping student rows, assignment columns for :
    assignment rows, student columns
    """
    return [[column[i] for column in gradebook] for i in range(len(gradebook[0]))]

def print_student_avg(student_grades):
    """
    Function that will take in a list and print the average of each student
    with formatting
    """
    print("Student Averages:")
    formatted_list = ["%.2f"%grade for grade in student_grades]
    for grade in range(len(formatted_list)):
        print('Student ' + str(grade + 1) + ':  ' + formatted_list[grade])
        
def print_assignment_avg(assignment_grades):
    """
    Function that will take in a list and print the average for each
    assignment with formatting
    """
    print("Assignment Averages:")
    formatted_list = ["%.2f"%grade for grade in assignment_grades]
    for grade in range(len(formatted_list)):
        print('Assignment ' + str(grade + 1) + ':  ' + formatted_list[grade])
    
def main():
    """  This program will -
    Display the average of each student's grade.
    Display tthe average for each assignment. """

    # 2D list of students grades for each assignment, each set is one student
    # 10 students total, 15 assignments each
    gradebook = [[61, 74, 69, 62, 72, 66, 73, 65, 60, 63, 69, 63, 62, 61, 64],
             [73, 80, 78, 76, 76, 79, 75, 73, 76, 74, 77, 79, 76, 78, 72],
             [90, 92, 93, 92, 88, 93, 90, 95, 100, 99, 100, 91, 95, 99, 96],
             [96, 89, 94, 88, 100, 96, 93, 92, 94, 98, 90, 90, 92, 91, 94],
             [76, 76, 82, 78, 82, 76, 84, 82, 80, 82, 76, 86, 82, 84, 78],
             [93, 92, 89, 84, 91, 86, 84, 90, 95, 86, 88, 95, 88, 84, 89],
             [63, 66, 55, 67, 66, 68, 66, 56, 55, 62, 59, 67, 60, 70, 67],
             [86, 92, 93, 88, 90, 90, 91, 94, 90, 86, 93, 89, 94, 94, 92],
             [89, 80, 81, 89, 86, 86, 85, 80, 79, 90, 83, 85, 90, 79, 80],
             [99, 73, 86, 77, 87, 99, 71, 96, 81, 83, 71, 75, 91, 74, 72]]

    # This is the class average for each student
    student_grades = calc_student_average(gradebook)
    # This will change the gradebook list from a list of student grades
    # to a list of assignment grades
    assignment_list = change_list(gradebook)
    # This is the average grade for each assignment
    assignment_grades = calc_assignment_average(assignment_list)
    # prints the assignment averages w/ formatting
    print_assignment_avg(assignment_grades)
    print()
    # prints the student averages w/ formatting
    print_student_avg(student_grades)
    print()

# Calling the main function
main()
    
