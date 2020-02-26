import pytest
import System
import TA

# This will check to make sure a specific TA makes assignments for a specific class
def test_correct_ta(grading_system):
    grading_system.login('cmhbf5', 'bestTA')
    grading_system.usr.create_assignment('assignment_final', '05/10/20', 'cloud_computing')
    assert grading_system.usr.name == 'heisenberg'

@pytest.fixture
def grading_system():
    gradingSystem = System.System()
    gradingSystem.load_data()
    return gradingSystem


# fails pytest - made to fail
