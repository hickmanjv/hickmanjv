import pytest
import System
import Staff

def test_change_grade(grading_system):
    grading_system.login('goggins', 'augurrox')
    grading_system.usr.change_grade('yted91', 'software_engineering', 'assignment1', 77)
    grading_system.usr.change_grade('yted91', 'software_engineering', 'assignment2', 56)
    assert grading_system.usr.users['yted91']['courses']['software_engineering']['assignment1']['grade'] == 77



@pytest.fixture
def grading_system():
    gradingSystem = System.System()
    gradingSystem.load_data()
    return gradingSystem

# This does not work as intended, every time you change a grade it always
# sets itself to 0 on that assignment


# failed pytest
