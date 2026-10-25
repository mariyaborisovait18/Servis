
package strategy;

public class TestGradingStrategy implements GradingStrategy {
  
  @Override
  public double grade(int achieved, int total) {
    
    if (total <= 0) {
      throw new IllegalArgumentException(
        "Количество вопросов должно быть больше 0"
      );
    }
    
    if (achieved < 0 || achieved > total) {
      throw new IllegalArgumentException(
        "Некорректное количество правильных ответов"
      );
    }
    
    return (double) achieved / total * 100;
  }
}
