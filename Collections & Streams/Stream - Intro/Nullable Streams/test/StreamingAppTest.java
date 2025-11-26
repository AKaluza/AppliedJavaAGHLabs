import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.Stream;

public class StreamingAppTest {
  @Test
  public void testException() {
    Assertions.assertAll(
            ()->Assertions.assertThrows(NullPointerException.class, ()->StreamingApp.count1(null)),
            ()->Assertions.assertDoesNotThrow( ()->StreamingApp.count2(null))
    );
  }
  @RepeatedTest(10)
  public void testRandom(){
    Random r = new Random();
    int num = r.nextInt(0,10);
    Integer[] numbers =  r.ints(0,10).boxed().limit(num).toArray(Integer[]::new);
    Assertions.assertEquals(count2(numbers),StreamingApp.count1(numbers));
  }
  public static long count2(Integer[] numbers) {
    return Stream.ofNullable(numbers).flatMap(Stream::of).count();
  }
}