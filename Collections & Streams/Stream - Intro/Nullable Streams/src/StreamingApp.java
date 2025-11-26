import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class StreamingApp {
    public static void main(String[] args){
        Integer[] numbers1 = {1,2,3,4};
        Integer[] numbers2 = null;
        System.out.println(count1(numbers1));
        try {
            System.out.println(count1(numbers2));
        }catch(NullPointerException ex)  {
            System.out.println(ex.getMessage());
        }
        try {
            System.out.println(count2(numbers2));
        }catch(NullPointerException ex)  {
            System.out.println(ex.getMessage());
        }

    }

    //count numbers
    public static long count1(Integer[] numbers) {
        return Stream.of(numbers).count();
    }

    //count numbers
    public static long count2(Integer[] numbers) {
        return Stream.ofNullable(numbers).flatMap(Stream::of).count();
    }
}