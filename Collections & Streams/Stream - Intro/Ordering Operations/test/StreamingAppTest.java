import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamingAppTest {

  //sorts the stream elements according to the natural order
  public static Stream<Integer> sortElementsReference(Stream<Integer> productCategories) {
    Stream<Integer>  sortedStream = productCategories.sorted();
    return sortedStream;
  }
  //sorts the stream elements according to a formula: a < b iff b-a < 0
  public static Stream<Integer> sortElementsWithComparatorReference(Stream<Integer> productCategories) {
    Stream<Integer>  sortedStream = productCategories.sorted((o1, o2) -> o2 - o1);
    return sortedStream;
  }
  @Test
  public void testSolution() {
    Random r = new Random();
    List<Integer> data = r.ints().boxed().limit(10).toList();
    Supplier<Stream<Integer>> productCategoriesSup = () ->data.stream();
    Stream<Integer>  sortAsscendingExpected = sortElementsReference(productCategoriesSup.get());
    Stream<Integer> sortDescendingExpected = sortElementsWithComparatorReference(productCategoriesSup.get());
    Stream<Integer>  sortAsscendingActual = StreamingApp.sortElements(productCategoriesSup.get());
    Stream<Integer> sortDescendingActual = StreamingApp.sortElementsWithComparator(productCategoriesSup.get());

    Assertions.assertAll(
            ()->Assertions.assertArrayEquals(sortAsscendingExpected.toArray(),sortAsscendingActual.toArray()),
            ()->Assertions.assertArrayEquals(sortDescendingExpected.toArray(),sortDescendingActual.toArray())
    );
  }
}