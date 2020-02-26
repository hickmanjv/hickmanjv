import pytest
import System

#Test the program to see if it assigns the right user information upon login
def test_password(grading_system):
    username = 'akend3'
    password = '123454321'
    grading_system.check_password(username, password)
    assert grading_system.users['akend3']['password'] == '123454321'


@pytest.fixture
def grading_system():
    gradingSystem = System.System()
    gradingSystem.load_data()
    return gradingSystem


# passed pytest
