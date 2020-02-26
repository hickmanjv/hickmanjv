import pytest
import System
import Staff

# This test will prevent a score of less than 0
# IMPORTANT - the original function change grades is broken on purpose to always set to 0.
#                         if it was correct, I would have asserted to >= 0 so you couldn't have added a
#                         negative grade for a student
def test_correct_grading(grading_system):
    grading_system.login('goggins', 'augurrox')
    grading_system.usr.change_grade('yted91', 'software_engineering', 'assignment1', -1)
    assert grading_system.usr.users['yted91']['courses']['software_engineering']['assignment1']['grade'] >= 1

@pytest.fixture
def grading_system():
    gradingSystem = System.System()
    gradingSystem.load_data()
    return gradingSystem


# fails pytest - made to fail
