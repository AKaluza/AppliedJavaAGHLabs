import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Aggregating {
    public static void main(String[] args){
        List<String> givenList = Arrays.asList(
                "xa", "xccc", "xdd","xee","xf","xeee","xg",
                "ya", "ybb", "yccc", "ydd","yee","ybb","yf","yeee","yg");
        groupAndThen(givenList).forEach((key,value)->System.out.println(key+"="+value));
        groupAndThenByMap(givenList).forEach((key,value)->System.out.println(key+"="+value));
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


record Stat(
        List<String> texts,
        IntSummaryStatistics summary){
  public String toString(){
      StringBuilder sb = new StringBuilder();
      return sb.append("Stat:< texts=").append(texts)
              .append(", summary:").append(summary)
              .append(" >").toString();
  }
}