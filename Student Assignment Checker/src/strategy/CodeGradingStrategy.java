
package strategy;

public class CodeGradingStrategy implements GradingStrategy {
  
  @Override
  public double grade(int achieved, int total) {
    
    if (total <= 0) {
      throw new IllegalArgumentException(
        "Количество тест-кейсов должно быть больше 0"
      );
    }
    
    if (achieved < 0 || achieved > total) {
      throw new IllegalArgumentException(
        "Некорректное количество пройденных тест-кейсов"
      );
    }
    
    double score = (double) achieved / total * 100;
    
    // Если пройдено меньше 50% тест-кейсов
    if (score < 50) {
      score = Math.min(score, 40);
    }
    
    // Бонус за прохождение 80% и более тест-кейсов
    if (score >= 80) {
      score += 5;
    }
    
    // Оценка не должна превышать 100 баллов
    score = Math.min(score, 100);
    
    return Math.round(score * 100.0) / 100.0;
  }
}
