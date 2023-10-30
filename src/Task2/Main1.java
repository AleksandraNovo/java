package src.Task2;

public class Main1 extends Task2 {
  public static void main(String[] args) {
    Tuple<String> tuple = new Tuple<>(5);

    tuple.add("Element 1");
    tuple.add("Element 3");
    tuple.add("Element 4", 1);

    System.out.println(tuple.get(0));
    System.out.println(tuple.get(1));
    System.out.println(tuple.get(2));
    tuple.remove(2);
    System.out.println(tuple.isEmpty());
    tuple.remove("Element 4");
    System.out.println(tuple.isEmpty());
    String defaultValue = "Default";
    System.out.println(tuple.orElse(0, defaultValue));
  }
}