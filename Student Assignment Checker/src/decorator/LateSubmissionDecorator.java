
package decorator;

public class LateSubmissionDecorator extends GradeDecorator {
  
  private final double penalty;
  
  public LateSubmissionDecorator(GradeResult wrappedResult,
                                 double penalty) {
    super(wrappedResult);
    
    if (penalty < 0 || penalty > 100) {
      throw new IllegalArgumentException(
        "Штраф должен быть от 0 до 100"
      );
    }
    
    this.penalty = penalty;
  }
  
  @Override
  public double getScore() {
    return Math.max(0, super.getScore() - penalty);
  }
  
  @Override
  public String getDescription() {
    return super.getDescription()
      + "\nШтраф за просрочку: -" + penalty + " баллов";
  }
}
