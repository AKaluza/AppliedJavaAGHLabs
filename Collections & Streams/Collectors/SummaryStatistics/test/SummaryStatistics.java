import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.Random;

public class SummaryStatistics {
  @Test
  public void testSolution() {
    Random r = new Random();
    double[] nums = r.doubles(1,100).limit(20).toArray();
    Assertions.assertEquals(stat(nums).toString(),SummaryStatistics.stat(nums).toString());
  }
  public static DoubleSummaryStatistics stat(double[] data){
    return  Arrays.stream(data).collect(
            DoubleSummaryStatistics::new,
            DoubleSummaryStatistics::accept,
            DoubleSummaryStatistics::combine
    );
  };
}