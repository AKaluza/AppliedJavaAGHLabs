import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilteringTest {
  Random r = new Random();
  List<String> strings = r.ints(1,100).boxed().limit(50).map(Object::toString).toList();
  @Test
  public void filterTest() {
    Assertions.assertEquals(filter(strings),Filtering.filter(strings));
  }
  public static Map<Integer, List<String>> filter(List<String> strings){
    return strings.stream()
            .collect(
                    Collectors.groupingBy(String::length,
                            Collectors.filtering(s->!s.contains("0"),
                                    Collectors.toList()))
            );
  }
}