import javax.print.attribute.standard.Fidelity;
import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public class ToCollection {
    public static void main(String[] args){
        ToCollection toCollection = new ToCollection();
        List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd","ee","bb");
        System.out.println(toCollection.get(givenList));
    }

  public Answer get(List<String> data){
        Answer answer = new Answer();
        answer.list = data.stream().collect(toCollection(LinkedList::new));
        answer.set = data.stream().collect(toUnmodifiableSet());
        answer.map = data.stream().collect(toMap(Function.identity(),String::length,(item, identicalItem) -> item));
      return answer;
  };
   static class Answer{
      List<String> list;
      Set<String> set;
      Map<String,Integer> map;
      public String toString(){
          StringBuilder sb = new StringBuilder();
          sb.append( list.toString()).append('\n')
                  .append(set.toString()).append('\n')
                  .append(map.toString()).append('\n');
          return sb.toString();
      }
  }
}