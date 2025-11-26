import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class StreamingAppTest {
  @Test
  public void testSolution() {
    Random r = new Random();
    Double lim = r.nextDouble(3,5);
    Double[] elements = r.doubles(1,10).boxed().limit(10).toArray(Double[]::new);
    Assertions.assertEquals(processStream(elements,lim),StreamingApp.processStream(elements,lim));
  }
  //Count the number of elements that are greater than lim
  public String processStream(Double[] elements, Double lim) {


    Stream<Double> stream = Stream.of(elements);

    // Pipeline of stream operations
    long numberOfElements = stream
            .map(Double::intValue)
            .filter(e->e >lim )
            .count();
    return "Number of elements from" + System.lineSeparator()+ Arrays.toString(elements) +
            System.lineSeparator()+"that are greater than " + lim +" is equal: "+ numberOfElements;
  }
}