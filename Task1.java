import java.util.function.BiFunction;
import java.util.function.Function;

public class Task1 {
    public static void main(String[] args) {
        Integer value = 7;
        multiplyByTwo(value);
    }

    static void multiplyByTwo(Integer n) {
        Function<Integer, Integer> resultFunction = createMultiplier(2);
        System.out.println("Result: " + resultFunction.apply(n));
    }

    static <A, B, C> Function<B, C> createMultiplier(A a) {
        return b -> {
            BiFunction<A, B, C> multiplier = (inputA, inputB) -> {
                return null;
            };
            return multiplier.apply(a, b);
        };
    }
}