import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class Grouping {
    public static void main(String[] args){
        List<String> givenList = Arrays.asList(
                "xa", "xbb", "xccc", "xdd","xee","xbb","xf","xeee","xg",
                "ya", "ybb", "yccc", "ydd","yee","ybb","yf","yeee","yg");
        System.out.println(group(givenList));
        System.out.println();
        System.out.println(multiGroup(givenList));
        System.out.println();
        System.out.println(groupAndConcatenate(givenList));
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