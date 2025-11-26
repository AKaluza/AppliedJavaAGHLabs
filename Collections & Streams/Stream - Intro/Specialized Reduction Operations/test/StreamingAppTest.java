import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class StreamingAppTest {
  @Test
  public void testSolution() {
    Random r = new Random();
    int num = r.nextInt(5,10);
    int[] numbers =r.ints(1,10).limit(num).toArray();
    Assertions.assertEquals(aggregateElements(numbers),StreamingApp.aggregateElements(numbers));
  }
  public static String aggregateElements(int[] numbers){
    int sum  = Arrays.stream(numbers).sum();
    int max = Arrays.stream(numbers).max().getAsInt();
    int min = Arrays.stream(numbers).min().getAsInt();
    long count = Arrays.stream(numbers).count();
    double average = Arrays.stream(numbers).average().getAsDouble();
    String answer = "Statiscics for " + Arrays.toString(numbers) +":"+
            "\nsum = "+sum+
            "\nmax = "+max+
            "\nmin = "+min+
            "\ncount = "+count+
            "\naverage = "+average;
    return answer;
  }
}