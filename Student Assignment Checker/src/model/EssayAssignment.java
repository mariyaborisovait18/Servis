package model;

public class EssayAssignment extends Assignment {
  
  private int minWordCount;
  
  public EssayAssignment(String title, int maxScore, int minWordCount) {
    super(title, maxScore);
    this.minWordCount = minWordCount;
  }
  
  public int getMinWordCount() {
    return minWordCount;
  }
  
  @Override
  public String getType() {
    return "Essay";
  }
}