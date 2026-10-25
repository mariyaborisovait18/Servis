
package decorator;

public class PlagiarismCheckDecorator extends GradeDecorator {
  
  public PlagiarismCheckDecorator(GradeResult wrappedResult) {
    super(wrappedResult);
  }
  
  @Override
  public String getDescription() {
    return super.getDescription()
      + "\nПроверка на плагиат: требуется ручная проверка";
  }
}
