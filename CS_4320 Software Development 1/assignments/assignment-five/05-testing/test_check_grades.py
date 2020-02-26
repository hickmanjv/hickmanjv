import pytest
import System
import Student

def test_grades(grading_system):
    grading_system.login('akend3', '123454321')
    grades = grading_system.usr.check_grades('databases')
    assert grading_system.usr.users['akend3']['courses']['databases']['assignment1']['grade'] == 23

@pytest.fixture
def grading_system():
    gradingSystem = System.System()
    gradingSystem.load_data()
    return gradingSystem



