package src.Task5;
import static src.Task5.Map.map;

import java.util.Arrays;
import java.util.List;
public class Main5 {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    List<String> strings = map(numbers, n -> "Номер: " + n.toString());
    System.out.println(strings);
    List<String> names = Arrays.asList("aaa", "aaaaa", "aa", "aaaaaaa");
    List<Integer> nameLengths = map(names, String::length);
    System.out.println(nameLengths);
  }
}
