import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.DoubleStream;



public class StreamingAppTest {

  @Test
  public void createStreamFromArrayTest() {
    Random r = new Random();
    double[] elements = DoubleStream.generate(r::nextDouble).limit(20).toArray();
    Assertions.assertArrayEquals(elements, StreamingApp.createStreamFromArray(elements).toArray());
  }
}