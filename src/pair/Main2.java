package src.pair;

public class Main2 {
  public static void main(String[] args) {
    Pair<Integer, String> pair = new Pair<>(5, "apple");
    System.out.println(pair.min()); // Output: 5
    System.out.println(pair.max()); // Output: apple

    Pair<Double, Double> pair2 = new Pair<>(3.14, 2.71);
    System.out.println(pair2.min()); // Output: 2.71
    System.out.println(pair2.max()); // Output: 3.14
  }
}
