import java.util.Arrays;
import java.util.stream.DoubleStream;

public class StreamingApp {
    public static void main(String[] args){
        double[] elements = {3.0, 4.5, 6.7, 2.3};
       createStreamFromArray(elements).forEach(System.out::println);
    }
    public static DoubleStream createStreamFromArray(double[] elements) {

        DoubleStream stream = Arrays.stream(elements);

        return stream;
    }
}