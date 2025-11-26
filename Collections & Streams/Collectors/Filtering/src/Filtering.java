import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Filtering {
  public static void main(String args[]) {
    List<String> strings = List.of("1", "2","11", "10", "112","110");
    System.out.println(filter(strings));
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