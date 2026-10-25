package factory;

import model.Assignment;
import model.TestAssignment;

public class TestAssignmentCreator extends AssignmentCreator {
  
  @Override
  public Assignment createAssignment() {
    return new TestAssignment("Тест по Java", 100, 20);
  }
}