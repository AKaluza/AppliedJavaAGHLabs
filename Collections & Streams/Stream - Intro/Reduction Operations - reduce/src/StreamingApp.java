import java.util.Arrays;

public class StreamingApp {
   public static void main(String[] args){
       String[] strings = {"1","2","30"};
       System.out.println(joinString(strings,"-"));
       int[] elements = {1,2,3,4,5};
       System.out.println(sumElements(elements));
   }

    // concatenates the elements of a string array i.e.
    // String joined = String.join(separator, strings);
    public static String  joinString(String[] strings,final String separator){

        return Arrays.stream(strings)
                .reduce((a, b) -> !"".equals(a)?  a + separator + b : b).orElse("");
    }
    //Here it is used an initial value of 0 as the first parameter of the reduce() operation
    // and it is provided an accumulator function to add the elements of the stream.
    public static int sumElements(int[] numbers){


        return Arrays.stream(numbers).reduce(0, Integer::sum);

    }
}