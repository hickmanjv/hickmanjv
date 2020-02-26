import pytest
import System
import Staff
import datetime

# this will ensure you are creating an assignment that doesn't have a due date in the past
# work around with assigning 'due' variable. Would do mos of this in the create_assignment
# function to prevent it there. Can't change functions for the assignment
def test_create_old_due_date(grading_system):
    grading_system.login('goggins', 'augurrox')
    due = '02/26/19'
    present = datetime.datetime.now()
    assignment_due = datetime.datetime.strptime(due, '%m/%d/%y')
    grading_system.usr.create_assignment('assignment6', due, 'comp_sci')
    assert assignment_due.date() > present.date()

@pytest.fixture
def grading_system():
    gradingSystem = System.System()
    gradingSystem.load_data()
    return gradingSystem
