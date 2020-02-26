import pytest
import System
import Student

def test_ontime(grading_system):
    grading_system.login('akend3', '123454321')
    grading_system.usr.check_ontime('2/19/20', '2/2/20')
    assert grading_system.usr.check_ontime('2/19/20', '2/2/20') == False

@pytest.fixture
def grading_system():
    gradingSystem = System.System()
    gradingSystem.load_data()
    return gradingSystem


# failed pytest evaluated to true, but supposed to be false
