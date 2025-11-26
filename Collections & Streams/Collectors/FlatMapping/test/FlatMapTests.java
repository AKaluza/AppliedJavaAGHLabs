import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FlatMapTests {

  @Test
  public void flatTest() {
      Random r = new Random();
      Supplier<List<Integer>> rllist =()-> r.ints(1,100).boxed().limit(20).toList();
      List<List<Integer>> list = List.of(rllist.get(),rllist.get(),rllist.get());
      Assertions.assertEquals(flat(list),FlatMap.flat(list));
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