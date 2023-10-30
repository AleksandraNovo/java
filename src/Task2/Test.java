package src.Task2;

import java.util.ArrayList;
import java.util.List;

public class Test {

  static Label checkLabels(List<TextAnalyzer> checkClasses, String comment) {
    for (TextAnalyzer analyzer : checkClasses) {
      Label result = analyzer.processText(comment);
      if(result == Label.OK) {
        continue;
      } else {
        return result;
      }
    }
    return Label.OK;
  }

  public static void main(String[] args) {
    TextAnalyzer spam = new SpamAnalyzer(new String[]{"spam1", "spam2", "spam3"});
    TextAnalyzer negative = new NegativeTextAnalyzer();
    TextAnalyzer lengthAnalyzer = new TooLongTextAnalyzer(100);
    ArrayList<TextAnalyzer> checkClasses = new ArrayList<>();
    checkClasses.add(spam);
    checkClasses.add(negative);
    checkClasses.add(lengthAnalyzer);

    System.out.println(checkLabels(checkClasses, "This is spam comment with words"));
  }
}
