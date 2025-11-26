import java.util.Arrays;
import java.util.DoubleSummaryStatistics;

import static java.util.stream.Collectors.summarizingDouble;

public class SummaryStatistics {
    public static void main(String[] args){
        double[] data = {1,2.1,3.2,4.3};
        System.out.println(stat(data));
    }
  public static DoubleSummaryStatistics stat(double[] data){
      return  Arrays.stream(data).collect(
                  DoubleSummaryStatistics::new,
                  DoubleSummaryStatistics::accept,
                  DoubleSummaryStatistics::combine
      );
  };
}