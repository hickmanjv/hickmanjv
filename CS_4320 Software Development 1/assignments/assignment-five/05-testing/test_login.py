import pytest
import System

#Test the program to see if it assigns the right user information upon login
def test_login(grading_system):
    username = 'akend3'
    password = '123454321'
    grading_system.login(username, password)
    assert 'student' in grading_system.users['akend3']['role']

@pytest.fixture
def grading_system():
    gradingSystem = System.System()
    gradingSystem.load_data()
    return gradingSystem


# passed pytest
