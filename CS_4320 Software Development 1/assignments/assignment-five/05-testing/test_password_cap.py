import pytest
import System

# Will test to make sure the first letter of the password is capitalized
def test_pass_caps(grading_system):
    username = 'hdjsr7'
    password = 'pass1234'
    grading_system.check_password(username, password)
    assert str.istitle(grading_system.users['hdjsr7']['password']) == True
    
@pytest.fixture
def grading_system():
    gradingSystem = System.System()
    gradingSystem.load_data()
    return gradingSystem


# fails pytest
