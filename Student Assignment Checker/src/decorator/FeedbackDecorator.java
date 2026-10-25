
package decorator;

public class FeedbackDecorator extends GradeDecorator {
  
  private final String feedback;
  
  public FeedbackDecorator(GradeResult wrappedResult, String feedback) {
    super(wrappedResult);
    
    if (feedback == null || feedback.isBlank()) {
      throw new IllegalArgumentException(
        "Комментарий не может быть пустым"
      );
    }
    
    this.feedback = feedback;
  }
  
  @Override
  public String getDescription() {
    return super.getDescription()
      + "\nКомментарий преподавателя: " + feedback;
  }
}
