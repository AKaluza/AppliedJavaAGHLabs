import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlatMap {
    public static void main(String[] args){
        List<List<Integer>> data = List.of(List.of(1,2,3,4,5,6),List.of(7,8,9,10));
        System.out.print(flat(data));
    }
    public static Map<Integer, List<Integer>> flat(List<List<Integer>> list){
        return list.stream().collect(
                Collectors.groupingBy(
                        Collection::size,
                        Collectors.flatMapping(
                                l->l.stream()
                                        .filter(i->i %2 ==0),
                                Collectors.toList()
                        )
                )

        );
    }
}