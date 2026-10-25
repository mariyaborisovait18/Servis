
package decorator;

public abstract class GradeDecorator implements GradeResult {
  
  protected final GradeResult wrappedResult;
  
  public GradeDecorator(GradeResult wrappedResult) {
    if (wrappedResult == null) {
      throw new IllegalArgumentException(
        "Результат проверки не может быть null"
      );
    }
    
    this.wrappedResult = wrappedResult;
  }
  
  @Override
  public double getScore() {
    return wrappedResult.getScore();
  }
  
  @Override
  public String getDescription() {
    return wrappedResult.getDescription();
  }
}
