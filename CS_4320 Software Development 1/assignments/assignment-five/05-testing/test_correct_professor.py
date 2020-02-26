import pytest
import System
import Professor

# This will check to ensure that professor Jurczyk can only create an assignment
def test_correct_professor(grading_system):
    grading_system.login('goggins', 'augurrox')
    grading_system.usr.create_assignment('assignment10', '03/20/20', 'comp_sci')
    assert grading_system.usr.name == 'jurczyk'

@pytest.fixture
def grading_system():
    gradingSystem = System.System()
    gradingSystem.load_data()
    return gradingSystem


# fails pytest - made to fail
