import java.util.Arrays;
import java.util.OptionalInt;
import java.util.function.IntPredicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class StreamingApp {
    public static void main(String[] args){
        Supplier<IntStream> elements = ()-> IntStream.range(1,10);

        System.out.println(findAnyMatch(elements.get(),5));
        System.out.println(findFromStream(elements.get()).orElseThrow());
        System.out.println(findAllMatch(elements.get(), e->(e<11)));
        System.out.println(findNoneMatch(elements.get(), e->(e<1)));
        System.out.println(Arrays.toString(filterStream(elements.get(), e -> (e > 4)).toArray()));

    }

    //check if stream elements contains number
    public static boolean findAnyMatch(IntStream elements, int number){

        boolean isPresent = elements
                .anyMatch(e->e == number);
       return isPresent;
    }
    //return first number from the stream elements
    public static OptionalInt findFromStream(IntStream elements) {

        return elements.findFirst();

    }
    // check if all numbers fulfills predictor condition
    public static boolean findAllMatch(IntStream elements, IntPredicate predictor){

        return  elements.allMatch( predictor);

    }
    // check if no number fulfills predictor condition
    public static boolean findNoneMatch(IntStream elements, IntPredicate predictor){

        return elements.noneMatch(predictor);

    }
    // filter stream according to predictor
    public static IntStream filterStream(IntStream elements, IntPredicate predictor) {


        return elements.filter(predictor);
    }



}