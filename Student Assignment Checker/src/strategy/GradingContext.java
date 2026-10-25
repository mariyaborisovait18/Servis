
package strategy;

public class GradingContext {
  
  private GradingStrategy strategy;
  
  public GradingContext(GradingStrategy strategy) {
    setStrategy(strategy);
  }
  
  public void setStrategy(GradingStrategy strategy) {
    if (strategy == null) {
      throw new IllegalArgumentException(
        "Стратегия оценивания не может быть null"
      );
    }
    
    this.strategy = strategy;
  }
  
  public double calculateGrade(int achieved, int total) {
    return strategy.grade(achieved, total);
  }
  
  
  
  public double calculateEssayGrade(
    int content,
    int structure,
    int grammar) {
    
    return strategy.gradeByCriteria(
      content,
      structure,
      grammar
    );
  }
  
  
}
