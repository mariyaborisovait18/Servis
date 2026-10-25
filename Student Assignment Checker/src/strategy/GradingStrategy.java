
package strategy;

public interface GradingStrategy {
  
  double grade(int achieved, int total);
  
  default double gradeByCriteria(
    int content,
    int structure,
    int grammar) {
    
    throw new UnsupportedOperationException(
      "Эта стратегия не поддерживает оценивание по критериям"
    );
  }
}
