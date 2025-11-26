import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamingApp {
    public static void main(String[] args){
        Supplier<Stream<Integer>> productCategoriesSup = ()->Stream.of(4,15,8,7,9,10);
        System.out.println(Arrays.toString(sortElements(productCategoriesSup.get()).toArray()));
        sortElementsWithComparator(productCategoriesSup.get()).forEach(System.out::println);
    }
    //sorts the stream elements according to the natural order
    public static Stream<Integer> sortElements(Stream<Integer> productCategories) {
        Stream<Integer>  sortedStream = productCategories.sorted();
        return sortedStream;
    }
    //sorts the stream elements according to a formula: a < b iff b-a < 0
    public static Stream<Integer> sortElementsWithComparator(Stream<Integer> productCategories) {
        Stream<Integer>  sortedStream = productCategories.sorted((o1, o2) -> o2 - o1);
        return sortedStream;
    }
}