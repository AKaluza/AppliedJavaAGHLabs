import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public class ToCollectionsTest {
  @Test
  public void testSolution() {
    ToCollection toCollection = new ToCollection();
    List<String> givenList = Arrays.asList("a", "bb", "ccc", "bb", "ccc","dd","ee","bb");
    Assertions.assertEquals(get(givenList).toString(),toCollection.get(givenList).toString());
  }

  public ToCollection.Answer get(List<String> data) {
    ToCollection.Answer answer = new ToCollection.Answer();
    answer.list = data.stream().collect(toCollection(LinkedList::new));
    answer.set = data.stream().collect(toUnmodifiableSet());
    answer.map = data.stream().collect(toMap(Function.identity(), String::length, (item, identicalItem) -> item));
    return answer;
  }
}