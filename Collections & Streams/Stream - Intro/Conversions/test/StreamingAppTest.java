import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class StreamingAppTest {
  private Random r = new Random();

  @Test
  public void testSolution() {
    int[] arrayInt = r.ints().limit(10).toArray();
    Integer[] arrayInteger = r.ints().limit(10).boxed().toArray(Integer[]::new);

    Supplier<IntStream> stream1 = ()->Arrays.stream(arrayInt);
    Supplier<Stream<Integer>> stream2 = ()->Arrays.stream(arrayInteger);

    // put your test here
    assertAll(
            ()->assertArrayEquals(intStream2Stream(stream1.get()).toArray(),StreamingApp.intStream2Stream(stream1.get()).toArray()),
            ()->assertArrayEquals(stream2IntStream(stream2.get()).toArray(),StreamingApp.stream2IntStream(stream2.get()).toArray()),
            ()->assertArrayEquals(int2Integer(arrayInt),StreamingApp.int2Integer(arrayInt)),
            ()->assertArrayEquals(integer2int(arrayInteger),StreamingApp.integer2int(arrayInteger))
    );
  }

  /**
   * IntStream->Stream<Integer>
   */
  public static Stream<Integer> intStream2Stream(IntStream stream){
    return stream.boxed();
  }

  /**
   * Stream<Integer>->IntStream
   */

  public static IntStream stream2IntStream(Stream<Integer> stream){
    return stream.mapToInt(Integer::intValue);
  }

  /**
   * int[] -> IntStream -> Stream<Integer> -> Integer[]
   */

  public static Integer[] int2Integer(int[] num ){


    //1. int[] -> IntStream
    IntStream stream = Arrays.stream(num);

    //2. IntStream -> Stream<Integer>
    Stream<Integer> boxed = stream.boxed();

    //3. Stream<Integer> -> Integer[]
    Integer[] result = boxed.toArray(Integer[]::new);

    return result;
  }

  /**
   *  Integer[]->Stream<Integer>->int[]
   */
  public static int[] integer2int(Integer[] num){

    //1. Integer[] -> Stream<Integer>
    Stream<Integer> stream = Arrays.stream(num);

    //2. Stream<Integer> -> IntStream
    IntStream intStream = stream.mapToInt(Integer::intValue);

    //3. IntStream -> Integer[]
    int[] result = intStream.toArray();

    return result;
  }

}