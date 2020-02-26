import pytest
import System
import Staff
import Professor

def test_add_student(grading_system):
    grading_system.login('goggins', 'augurrox')
    grading_system.usr.add_student('akend3', 'cloud_computing')
    assert 'cloud_computing' in grading_system.usr.users['akend3']['courses']
    

@pytest.fixture
def grading_system():
    gradingSystem = System.System()
    gradingSystem.load_data()
    return gradingSystem


# Failed pytest
