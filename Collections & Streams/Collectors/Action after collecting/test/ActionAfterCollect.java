

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class ActionAfterCollect {
  static ActionAfterCollect actual = new ActionAfterCollect();
  static Random r = new Random();
  static String[][] data;
  static Integer[] numbers;
  @BeforeAll
  public static void setUp() {
    data = r.ints(1,100).limit(20).boxed()
            .distinct()
            .map(x->new String[]{x.toString(),x.toString()}).toArray(String[][]::new);
    numbers = r.ints(1,100).limit(20).boxed().toArray(Integer[]::new);
  }
  @Test
  public void stringsArrayToMapTest() {
    Assertions.assertEquals(stringsArrayToMap(data),actual.stringsArrayToMap(data));
  }
  @Test
  public void stringsArrayToSetTest() {
    Assertions.assertEquals(stringsArrayToSet(data),actual.stringsArrayToSet(data));
  }
  @Test
  public void reverseTest() {
    Assertions.assertEquals(reverse(numbers),actual.reverse(numbers));
  }

  @Test
  public void sliceTest() {
    Assertions.assertEquals(slice(numbers,4,10),actual.slice(numbers,4,10));
  }

  public Map<String,String> stringsArrayToMap(String[][] data){
    return Arrays.stream(data)
            .collect(Collectors.collectingAndThen(
                    Collectors.toMap(p -> p[0], p -> p[1]),
                    Collections::<String, String>
                            unmodifiableMap));
  }
  public Set<String> stringsArrayToSet(String[][] data){
    return Arrays.stream(data)
            .collect(Collectors.collectingAndThen(
                    Collectors.toMap(p->p[0].concat("-").concat(p[1]),p->""),
                    Map<String,String>::keySet));
  };

  List<Integer> reverse(Integer[] list){
    return Arrays.stream(list)
            .collect(Collectors.collectingAndThen(
                    Collectors.toList(),
                    l -> {
                      Collections.reverse(l);
                      return l.stream();
                    }
            )).collect(Collectors.toList());
  }
  List<Integer> slice(Integer[] list, int fromIndex, int toIndex){
    return Arrays.stream(list)
            .collect(Collectors.collectingAndThen(
                    Collectors.toList(),
                    x -> x.stream()
                            .skip(fromIndex)
                            .limit(toIndex - fromIndex + 1)
            )).collect(Collectors.toList());
  }
}