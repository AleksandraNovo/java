package src.Task5;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Map {
  public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
    List<R> result = new ArrayList<>();
    for (T element : list) {
      R mappedElement = function.apply(element);
      result.add(mappedElement);
    }
    return result;
  }
}
