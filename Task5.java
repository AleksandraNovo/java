import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Task5 {
    public static void main(String[] args) {
        String text = "This is a sample sentence demonstrating custom Spliterator implementation";
        Stream<String> wordStream = StreamSupport.stream(new WordSpliterator(text), false);
        wordStream.forEach(System.out::println);
    }
}

class WordSpliterator implements Spliterator<String> {
    private final String text;
    private int currentChar = 0;

    public WordSpliterator(String text) {
        this.text = text;
    }

    @Override
    public boolean tryAdvance(Consumer<? super String> action) {
        while (currentChar < text.length() && Character.isWhitespace(text.charAt(currentChar))) {
            currentChar++;
        }
        if (currentChar >= text.length()) {
            return false;
        }
        int start = currentChar;
        while (currentChar < text.length() && !Character.isWhitespace(text.charAt(currentChar))) {
            currentChar++;
        }
        action.accept(text.substring(start, currentChar));
        return true;
    }

    @Override
    public Spliterator<String> trySplit() {
        if (estimateSize() <= 1) {
            return null;
        }
        for (int splitPos = Math.toIntExact(estimateSize() / 2 + currentChar); splitPos < text.length(); splitPos++) {
            if (Character.isWhitespace(text.charAt(splitPos))) {
                Spliterator<String> spliterator = new WordSpliterator(text.substring(currentChar, splitPos));
                currentChar = splitPos;
                return spliterator;
            }
        }
        return null;
    }

    @Override
    public long estimateSize() {
        return text.length() - currentChar;
    }
    @Override
    public int characteristics() {
        return SIZED | SUBSIZED | CONCURRENT | IMMUTABLE | ORDERED;
    }
}
