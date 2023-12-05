package src.Task2;

public class TooLongTextAnalyzer implements TextAnalyzer {

  private int maxLength;

  TooLongTextAnalyzer(int inMaxLength) {
    maxLength = inMaxLength;
  }

  @Override
  public Label processText(String text){
    if (text != null && text.length() > maxLength) {
      return Label.LENGTH;
    } else {
      return Label.OK;
    }
  }
}
