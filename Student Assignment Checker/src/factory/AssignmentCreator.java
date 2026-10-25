package factory;

import model.Assignment;

public abstract class AssignmentCreator {
  
  public abstract Assignment createAssignment();
  
  public void showAssignment() {
    Assignment assignment = createAssignment();
    
    System.out.println("Задание создано!");
    System.out.println("Название: " + assignment.getTitle());
    System.out.println("Тип: " + assignment.getType());
    System.out.println("Максимальный балл: "
      + assignment.getMaxScore());
  }
}