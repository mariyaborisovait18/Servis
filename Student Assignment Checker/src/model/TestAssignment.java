package model;

public class TestAssignment extends Assignment {
  
  private int questionCount;
  
  public TestAssignment(String title, int maxScore, int questionCount) {
    super(title, maxScore);
    this.questionCount = questionCount;
  }
  
  public int getQuestionCount() {
    return questionCount;
  }
  
  @Override
  public String getType() {
    return "Test";
  }
}