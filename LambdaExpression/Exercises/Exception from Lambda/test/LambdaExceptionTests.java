import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


import java.util.Arrays;
import java.util.Random;
import java.util.stream.DoubleStream;

public class LambdaExceptionTests {
  String expected = """
The average is 2.5
EmptyArrayException: Array Empty
""";
  @Test
  public void testSolution()  {
    Random r = new Random();
    double[] data = DoubleStream.generate(r::nextDouble).limit(10).toArray();
    Assertions.assertDoesNotThrow(
            ()->Assertions.assertEquals(average(data),
                    LambdaExceptionDemo.average(data),"Invalid average for" + Arrays.toString(data))
    );
  }

  @Test
  public void testNull(){
    Assertions.assertThrows(Exception.class,()->LambdaExceptionDemo.average(new double[0]));
  }
  public static double average(double[] vals) throws EmptyArrayException {
    // This block lambda computes the average of an array of doubles.
    DoubleNumericArrayFunc f = (n) -> {
      double sum = 0;
      if(n.length == 0)
        throw new EmptyArrayException();
      for(int i=0; i < n.length; i++)
        sum += n[i];
      return sum / n.length;
    };
    return f.func(vals);
  }
}