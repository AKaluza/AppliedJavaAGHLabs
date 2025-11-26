import java.util.Arrays;


public class StreamingApp {
    public static void main(String[] args) {
        System.out.println(aggregateElements(new int[]{1,2,3,4,5}));
    }
    public static String aggregateElements(int[] numbers){
        int sum  = Arrays.stream(numbers).sum();
        int max = Arrays.stream(numbers).max().orElseThrow();
        int min = Arrays.stream(numbers).min().orElseThrow();
        long count = Arrays.stream(numbers).count();
        double average = Arrays.stream(numbers).average().orElseThrow();
        String answer = "Statiscics for " + Arrays.toString(numbers) +":"+
                "\nsum = "+sum+
                "\nmax = "+max+
                "\nmin = "+min+
                "\ncount = "+count+
                "\naverage = "+average;
        return answer;
    }
}



