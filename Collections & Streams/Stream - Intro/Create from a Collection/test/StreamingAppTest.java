import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.Random;

public class StreamingAppTest {

  @Test
  public void createStreamFromCollectionTest() {
    Random r = new Random();
    Double[] elements = r.doubles().boxed().limit(20).toArray(Double[]::new);
    Assertions.assertArrayEquals(elements, StreamingApp.createStreamFromCollection(elements).toArray());
  }
}