import java.util.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;




public class ActionAfterCollect {
    public static void main(String[] args){
        ActionAfterCollect afterCollect = new ActionAfterCollect();
        String[][] data = new String[][] {
                { "1", "Geeks" },
                { "2", "For" },
                { "3", "Geeks" }};
        Integer[] list = IntStream.rangeClosed(0, 10).boxed().toArray(Integer[]::new);
        System.out.println(afterCollect.stringsArrayToMap(data));
        System.out.println(afterCollect.stringsArrayToSet(data));
        System.out.println((afterCollect.reverse(list)));
        System.out.println(afterCollect.slice(list,4,8));
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