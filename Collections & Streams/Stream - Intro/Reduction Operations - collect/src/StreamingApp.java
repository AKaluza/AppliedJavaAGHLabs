import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamingApp {
    //use collect to join strings
    public static String joinnStrings(Stream<String> products) {
        return products.collect(Collectors.joining());
    }
}