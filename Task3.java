import java.util.function.BiFunction;
import java.util.function.Function;

public class Task3 {
    public static void main(String[] args) {
        String word = "hello";
        String name = "Andrey";
        sayGreeting(word, name);
    }

    static void sayGreeting(String word, String name) {
        Function<String, Function<String, String>> greet = createGreeting();
        System.out.println(greet.apply(word).apply(name));
    }

    static Function<String, Function<String, String>> createGreeting() {
        BiFunction<String, String, String> concatGreeting = (a, b) -> a + ", " + b + "!";
        return curry(concatGreeting);
    }

    static <A, B, C> Function<A, Function<B, C>> curry(BiFunction<A, B, C> fn) {
        return a -> b -> fn.apply(a, b);
    }
}



