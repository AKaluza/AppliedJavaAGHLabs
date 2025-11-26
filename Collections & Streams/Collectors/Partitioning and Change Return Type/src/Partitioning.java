import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Partitioning {
    public static void main(String[] args){
        List<Integer> numbers = IntStream.rangeClosed(1,20).boxed().toList();
        System.out.println(partition(numbers));
        System.out.println(partitionAndCount(numbers));
    }

    public static Map<Boolean,List<Integer>> partition(List<Integer> numbers){
        return numbers.stream()
                .collect(Collectors.partitioningBy(s-> s %2 == 0));
    }

    public static Map<Boolean, IntSummaryStatistics> partitionAndCount(List<Integer> numbers){
        return numbers.stream()
                .collect(Collectors.partitioningBy(s->s%2 == 0,Collectors.summarizingInt(s->s)));
    }

}