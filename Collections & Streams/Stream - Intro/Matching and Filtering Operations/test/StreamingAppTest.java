import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertAll;


public class StreamingAppTest {

  @RepeatedTest(10)
  public void testSolution() {
    Random r = new Random();
    int[] rand = r.ints(1,10).limit(20).toArray();
    Supplier<IntStream> elements = ()-> Arrays.stream(rand);
    assertAll(
            ()-> Assertions.assertEquals(findAnyMatch(elements.get(),3), StreamingApp.findAnyMatch(elements.get(),3)),
            ()-> Assertions.assertEquals(findFromStream(elements.get()).getAsInt(), StreamingApp.findFromStream(elements.get()).getAsInt()),
            ()-> Assertions.assertEquals(findAllMatch(elements.get(),e->e>3), StreamingApp.findAllMatch(elements.get(),e->e>3)),
            ()-> Assertions.assertEquals(findNoneMatch(elements.get(),e->e<3), StreamingApp.findNoneMatch(elements.get(),e->e<3)),
            ()-> Assertions.assertArrayEquals(filterStream(elements.get(),e->e>5).toArray(), StreamingApp.filterStream(elements.get(),e->e>5).toArray())

    );
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