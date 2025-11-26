import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class StreamingAppTest {
  @Test
  public void createStreamsTest() {
    Random r = new Random();
    ArrayData expected = new ArrayData(
            r.ints().limit(10).toArray(),
            r.longs().limit(5).toArray(),
            r.doubles().limit(10).toArray());
    StreamData stream = StreamingApp.createStreams(expected);
    Assertions.assertAll(
            ()->Assertions.assertArrayEquals(expected.intArray(),stream.integerStream().toArray()),
            ()->Assertions.assertArrayEquals(expected.longArray(),stream.longStream().toArray()),
            ()->Assertions.assertArrayEquals(expected.doubleArray(),stream.doubleStream().toArray()));
  }
}