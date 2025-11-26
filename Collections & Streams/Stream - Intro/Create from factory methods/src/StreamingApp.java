import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

record ArrayData(int[] intArray, long[] longArray, double[] doubleArray){}

record StreamData( IntStream integerStream, LongStream  longStream, DoubleStream doubleStream){}

public class StreamingApp {
    public static void main(String[] args){
        ArrayData arr = new ArrayData(
                new int[]{1,2,3,4},
                new long[] {1,2,3,5,6},
                new double[] {1.2,2.3,4.5,5.6});
        StreamData data = createStreams(arr);
        data.integerStream().forEach(System.out::println);
        data.longStream().forEach(System.out::println);
        data.doubleStream().forEach(System.out::println);
    }

    public static StreamData createStreams(ArrayData arr) {

        IntStream integerStream = IntStream.of(arr.intArray());

        LongStream longStream = LongStream.of(arr.longArray());

        DoubleStream doubleStream = DoubleStream.of(arr.doubleArray());

        return new StreamData(integerStream,longStream,doubleStream);
    }
}