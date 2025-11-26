import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.summarizingInt;

public class AggregatingTests {
    static List<String> givenList;
    @BeforeAll
    public static void setUp(){
        Random r = new Random();
        givenList = r.ints(1,1000).boxed().limit(500).map(Object::toString).toList();
    }
  @Test
  public void groupAndThenTest() {
        Assertions.assertEquals(groupAndThen(givenList).toString(),Aggregating.groupAndThen(givenList).toString());
  }

  @Test
  public void groupAndThenByMapTest() {
        Assertions.assertEquals(groupAndThenByMap(givenList).toString(),Aggregating.groupAndThenByMap(givenList).toString());
  }


  public static Map<Character,Stat> groupAndThen(List<String> data){
    return data.stream()
            .collect(groupingBy(x->x.charAt(0),collectingAndThen(toList(), list->{
              List<String> texts = list.stream().toList();
              IntSummaryStatistics summary = list.stream()
                      .collect(summarizingInt(String::length));
              return new Stat(texts,summary);
            })));
  }
  public static Map<Character,Stat> groupAndThenByMap(List<String> data){
    return data.stream()
            .collect(Collectors.toMap(
                    x->x.charAt(0),
                    y-> {
                      int n = y.length();
                      return new Stat(List.of(y),  new IntSummaryStatistics(1,n,n,n));
                    },
                    (stat1,stat2)-> {
                      List<String> texts = new LinkedList<>();
                      IntSummaryStatistics summary = new IntSummaryStatistics();
                      texts.addAll(stat1.texts());
                      texts.addAll(stat2.texts());
                      summary.combine(stat1.summary());
                      summary.combine(stat2.summary());
                      return  new Stat(texts, summary);
                    }
            ));
  }
}