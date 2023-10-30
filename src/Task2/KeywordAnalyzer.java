package src.Task2;

public abstract class KeywordAnalyzer implements TextAnalyzer {

  String [] keywords;

  @Override
  public Label processText(String text) {
    for (String keyword : keywords) {
      if(this instanceof SpamAnalyzer && text != null && text.contains(keyword)){
        return Label.SPAM;
      } else if(this instanceof NegativeTextAnalyzer && text != null && text.contains(keyword)){
        return Label.NEGATIVE_CONTENT;
      }
    }
    return Label.OK;
  }
}
