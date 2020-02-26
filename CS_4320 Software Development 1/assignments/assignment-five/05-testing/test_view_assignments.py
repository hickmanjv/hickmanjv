import pytest
import System
import Student

# IMPORTANT - The code only uses assignments from 'comp_sci'
#                         but each course has only "assignment1" and "assignment2" by default
#                         so it will always pass pytest unless you add and check an alternate\
#                         will add a section to create the assignment here
def test_view_assignments(grading_system):
    
    #added to ensure there is the appropriate assignment tested for 
    grading_system.login('goggins', 'augurrox')
    grading_system.usr.create_assignment('assignment5', '03/10/20', 'databases')

    # actual test
    grading_system.login('akend3', '123454321')
    grading_system.usr.view_assignments('databases')
    assert 'assignment5' in grading_system.usr.users['akend3']['courses']['databases']

@pytest.fixture
def grading_system():
    gradingSystem = System.System()
    gradingSystem.load_data()
    return gradingSystem


# fails pytest
