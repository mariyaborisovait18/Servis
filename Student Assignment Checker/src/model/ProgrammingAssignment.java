package model;

public class ProgrammingAssignment extends Assignment {
  
  private String programmingLanguage;
  
  public ProgrammingAssignment(String title, int maxScore,
                               String programmingLanguage) {
    super(title, maxScore);
    this.programmingLanguage = programmingLanguage;
  }
  
  public String getProgrammingLanguage() {
    return programmingLanguage;
  }
  
  @Override
  public String getType() {
    return "Programming";
  }
}