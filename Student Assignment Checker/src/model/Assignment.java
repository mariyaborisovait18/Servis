package model;

public abstract class Assignment {
  
  private String title;
  private int maxScore;
  
  public Assignment(String title, int maxScore) {
    this.title = title;
    this.maxScore = maxScore;
  }
  
  public String getTitle() {
    return title;
  }
  
  public int getMaxScore() {
    return maxScore;
  }
  
  public abstract String getType();
}