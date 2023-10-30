package src.Task4;

public class Test {

  public static void main(String[] args) {

    callLambda((int number) -> {
      if (number > 0){
        return("Число положительное.");
      } else if (number < 0){
        return("Число отрицательное.");
      } else {
        return("Число равно нулю.");
      }
    }, -1);
  }
  static void callLambda (Checkable obj, int number){
    System.out.println(obj.checkNumber(number));
  }
}
