
package decorator;

public class BasicGradeResult implements GradeResult {
  
  private double score;
  private String description;
  
  public BasicGradeResult(double score, String description) {
    if (score < 0 || score > 100) {
      throw new IllegalArgumentException(
        "Оценка должна быть от 0 до 100"
      );
    }
    
    this.score = score;
    this.description = description;
  }
  
  @Override
  public double getScore() {
    return score;
  }
  
  @Override
  public String getDescription() {
    return description;
  }
}
