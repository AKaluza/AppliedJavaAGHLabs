import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class PartitioningTests {
  Random r = new Random();
  List<Integer> numbers = r.ints(1,100).boxed().limit(30).toList();

  @Test
  public void partitionTest() {
    Assertions.assertEquals(partition(numbers).toString(),Partitioning.partition(numbers).toString());
  }
  @Test
  public void partitionAndCountTest() {
    Assertions.assertEquals(partitionAndCount(numbers).toString(),Partitioning.partitionAndCount(numbers).toString());
  }
  public static Map<Boolean, List<Integer>> partition(List<Integer> numbers){
    return numbers.stream()
            .collect(Collectors.partitioningBy(s-> s %2 == 0));
  }

  public static Map<Boolean, IntSummaryStatistics> partitionAndCount(List<Integer> numbers){
    return numbers.stream()
            .collect(Collectors.partitioningBy(s->s%2 == 0,Collectors.summarizingInt(s->s)));
  }
}