
package strategy;

public class EssayGradingStrategy implements GradingStrategy {
  
  @Override
  public double grade(int achieved, int total) {
    
    if (total <= 0) {
      throw new IllegalArgumentException(
        "Максимальный балл должен быть больше 0"
      );
    }
    
    if (achieved < 0 || achieved > total) {
      throw new IllegalArgumentException(
        "Некорректная сумма баллов за эссе"
      );
    }
    
    return (double) achieved / total * 100;
  }
  
  @Override
  public double gradeByCriteria(
    int content,
    int structure,
    int grammar) {
    
    validateScore(content);
    validateScore(structure);
    validateScore(grammar);
    
    double result = content * 0.5
      + structure * 0.3
      + grammar * 0.2;
    
    return Math.round(result * 100.0) / 100.0;
  }
  
  private void validateScore(int score) {
    if (score < 0 || score > 100) {
      throw new IllegalArgumentException(
        "Балл за критерий должен быть от 0 до 100"
      );
    }
  }
}
