import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

import static java.util.stream.Collectors.*;

public class GroupingTests {
  static List<String> givenList;
  @BeforeAll
  public static void setUp(){
    Random r = new Random();
    givenList = r.ints(1,1000).boxed().limit(500).map(Object::toString).toList();
  }
  @Test
  public void groupTest() {
    Assertions.assertEquals(group(givenList),Grouping.group(givenList));
  }
  @Test
  public void multiGroupTest() {
    Assertions.assertEquals(multiGroup(givenList),Grouping.multiGroup(givenList));
  }
  @Test
  public void groupAndConcatenateTest() {
    Assertions.assertEquals(groupAndConcatenate(givenList),Grouping.groupAndConcatenate(givenList));
  }

  public static Map<Integer, Set<String>> group(List<String> data){
    return data.stream()
            .collect(groupingBy(String::length, toSet()));
  }

  public static Map<Character, Map<Integer,Set<String>>> multiGroup(List<String> data){
    return data.stream()
            .collect(groupingBy(x->x.charAt(0),groupingBy(String::length, toSet())));

  }

  public static Map<Integer,String> groupAndConcatenate(List<String> data){
    return data.stream()
            .collect(groupingBy(String::length,joining("-")));
  }
}