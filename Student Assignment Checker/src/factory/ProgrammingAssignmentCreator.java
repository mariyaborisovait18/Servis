package factory;

import model.Assignment;
import model.ProgrammingAssignment;

public class ProgrammingAssignmentCreator extends AssignmentCreator {
  
  @Override
  public Assignment createAssignment() {
    return new ProgrammingAssignment(
      "Алгоритмы сортировки",
      100,
      "Java"
    );
  }
}