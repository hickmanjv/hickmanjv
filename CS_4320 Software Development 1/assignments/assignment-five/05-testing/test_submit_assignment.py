import pytest
import System
import Student

def test_submit(grading_system):
    grading_system.login('akend3', '123454321')
    grading_system.usr.submit_assignment('comp_sci', 'assignment1', 'Testing..', '2/19/20')
    assert grading_system.usr.check_ontime('2/19/20', '2/2/20') == False


@pytest.fixture
def grading_system():
    gradingSystem = System.System()
    gradingSystem.load_data()
    return gradingSystem

# fails pytest - the function submit_assignment calls function check_ontime() and always
#                     returns True regardless of late submission

