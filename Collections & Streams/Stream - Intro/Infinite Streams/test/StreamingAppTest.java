import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamingAppTest {
  @Test
  public void testSolution() {
    Assertions.assertAll(
            ()->Assertions.assertArrayEquals(fibbonaciGenerateStream().limit(15).toArray(),
                    StreamingApp.fibbonaciGenerateStream().limit(15).toArray()),
           ()->Assertions.assertArrayEquals(fibbonaciIterateStream().limit(15).toArray(),
                    StreamingApp.fibbonaciIterateStream().limit(15).toArray())
    );
  }
  public static IntStream fibbonaciGenerateStream(){
    return IntStream.generate(Fib::next);
  }


  public static Stream<Integer> fibbonaciIterateStream(){
    //Here, we have set  Pair(1,1) as the seed value, which becomes the first element of our stream.
    // This value is passed as input to the lambda expression x->x.next()), which returns Pair(1,2).
    // This value, in turn, is passed as input in the next iteration

    return Stream.iterate(
            new FibPair(1, 1), FibPair::next).map(FibPair::toInt);
  }
  static class Fib{
    private static int a = 0;
    private static int b = 1;
    public static int next(){
      int t = a;
      a = b;
      b = t + b;
      return a;
    }
  }

  static class FibPair{
    int a;
    int b;
    FibPair(int a, int b){
      this.a = a;
      this.b = b;
    }
    public FibPair next(){
      return new FibPair(b, a + b);
    }
    public int toInt(){
      return a;
    }
  }

}



