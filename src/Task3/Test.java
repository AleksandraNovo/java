package src.Task3;

public class Test {

  public static void main(String[] args) {
    Printable p = (() -> {
      System.out.println("Лямбда-выражение выполнено");
    });

    Printable p1 = new Printable() {
      @Override
      public void print() {
        System.out.println("Лямбда-выражение выполнено25");
      }
    };

    callLambda(p);
    callLambda(p1);
  }

  static void callLambda(Printable obj) {
    obj.print();
  }
}
