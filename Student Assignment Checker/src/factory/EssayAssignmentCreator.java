package factory;

import model.Assignment;
import model.EssayAssignment;

public class EssayAssignmentCreator extends AssignmentCreator {
  
  @Override
  public Assignment createAssignment() {
    return new EssayAssignment(
      "Искусственный интеллект в образовании",
      100,
      500
    );
  }
}