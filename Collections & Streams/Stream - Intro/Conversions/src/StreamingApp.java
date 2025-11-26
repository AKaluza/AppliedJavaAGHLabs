import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

record Answer(int[] result,int[] oneLineResult){}

public class StreamingApp {
    public static void main(String[] args){
        Integer[] arrayInteger = {1,2,3,4};
        int[]  arrayInt= {5,6,7,8};
        IntStream stream1 = Arrays.stream(arrayInt);
        Stream<Integer> stream2 = Arrays.stream(arrayInteger);

        stream2IntStream(stream2).forEach(System.out::println);
        intStream2Stream(stream1).forEach(System.out::println);
        System.out.println(Arrays.toString(int2Integer(arrayInt)));
        System.out.println(Arrays.toString(integer2int(arrayInteger)));

    }


    //IntStream->Stream<Integer>
    public static Stream<Integer> intStream2Stream(IntStream stream){
        return stream.boxed();
    }


     //Stream<Integer>->IntStream
    public static IntStream stream2IntStream(Stream<Integer> stream){
        return stream.mapToInt(Integer::intValue);
    }


     //int[] -> IntStream -> Stream<Integer> -> Integer[]

    public static Integer[] int2Integer(int[] num ){


        //1. int[] -> IntStream
        IntStream stream = Arrays.stream(num);

        //2. IntStream -> Stream<Integer>
        Stream<Integer> boxed = stream.boxed();

        //3. Stream<Integer> -> Integer[]
        Integer[] result = boxed.toArray(Integer[]::new);

        return result;
    }


     //Integer[]->Stream<Integer>->int[]

    public static int[] integer2int(Integer[] num){

        //1. Integer[] -> Stream<Integer>
        Stream<Integer> stream = Arrays.stream(num);

        //2. Stream<Integer> -> IntStream
        IntStream intStream = stream.mapToInt(Integer::intValue);

        //3. IntStream -> int[]
        int[] result = intStream.toArray();

        return result;
    }


}