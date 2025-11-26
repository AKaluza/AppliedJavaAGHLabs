import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamingApp {
    public static void main(String[] args){
        Double[] elements = {3.0, 4.5, 6.7, 2.3};
        createStreamFromCollection(elements).forEach(System.out::println);
    }

    public static Stream<Double>  createStreamFromCollection(Double[] elements  ) {
        List<Double> elementsInCollection = Arrays.asList(elements);

        Stream<Double> stream = elementsInCollection.stream();

        return stream;
        
    }

}