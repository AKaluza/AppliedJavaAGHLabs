import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class StreamingApp {
    public static void main(String[] args){
        Double[] elements = DoubleStream.iterate(1,e->e+0.2).boxed().limit(10).toArray(Double[]::new);
        System.out.println(processStream(elements,1.7));
    }

    //Count the number of elements that are greater than lim
    public static String processStream(Double[] elements, Double lim) {


        Stream<Double> stream = Stream.of(elements);

        // Pipeline of stream operations
        long numberOfElements = stream
                .map(x -> x.doubleValue())
                .filter(e->e >lim )
                .count();
        return  "Number of elements from"+System.lineSeparator()+ Arrays.toString(elements) + System.lineSeparator()+
                "that are greater than " + lim +" is equal: "+ numberOfElements;
    }
}

