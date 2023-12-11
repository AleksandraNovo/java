import java.util.function.BiFunction;
import java.util.function.Function;

public class Task2 {
    public static void main(String[] args) {
        String string = "ilovejava";
        substringFiveSymbols(string);
    }

    static void substringFiveSymbols(String str) {
        Function<String, String> result = createSubstringFunction(5);
        System.out.println("result: " + result.apply(str));
    }

    static <A, B, C> Function<B, C> createBoundFunction(BiFunction<A, B, C> fn, A a) {
        return b -> fn.apply(a, b);
    }

    static Function<String, String> createSubstringFunction(int endIndex) {
        BiFunction<Integer, String, String> substringFn = (end, string) -> string.substring(0, end);
        return createBoundFunction(substringFn, endIndex);
    }
}