import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamingAppTest {
  @Test
  public void testSolution() {
    String[] strings = {"a","b","c","d","e","f"};
    int[] numbers = IntStream.range(0,10).toArray();
    String separator = ":";
    Assertions.assertAll(

           ()-> Assertions.assertEquals(joinString(strings,separator), StreamingApp.joinString(strings,separator),
                   "Invalid joinString("+strings+','+separator+")\n"),
            ()-> Assertions.assertEquals(sumElements(numbers), StreamingApp.sumElements(numbers),
                    "Invalid sumElements("+numbers+ ")\n")
   );
  }
  // concatenates the elements of a string array i.e.
  // String joined = String.join(separator, strings);
  public String joinString(String[] strings,final String separator){

    return Arrays.stream(strings)
            .reduce((a, b) -> !"".equals(a)?  a + separator + b : b).orElse("");
  }
  //Here it is used an initial value of 0 as the first parameter of the reduce() operation
  // and it is provided an accumulator function to add the elements of the stream.
  public int sumElements(int[] numbers){


    return Arrays.stream(numbers).reduce(0, (a,b)->a+b);

  }
}