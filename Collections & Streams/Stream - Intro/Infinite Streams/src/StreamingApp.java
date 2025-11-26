import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamingApp {

    public static void main(String[] args){
        fibbonaciGenerateStream().limit(10).forEach(System.out::print);
        System.out.println();
        fibbonaciIterateStream().limit(10).forEach(System.out::print);
    }

    public static IntStream fibbonaciGenerateStream(){
        return IntStream.generate(Fib::next);
    }


    public static Stream<Integer> fibbonaciIterateStream(){
        // Here, we have set  Pair(1,1) as the seed value, which becomes the first element of our stream.
        // This value is passed as input to the lambda expression x->x.next()), which returns Pair(1,2).
        // This value, in turn, is passed as input in the next iteration
        // so next should return nexr FibPair and toInt should return first element of this Pair

        return Stream.iterate(
               new FibPair(1,1), FibPair::next).map(FibPair::toInt);
    }

}

class Fib{
    private static int a = 0;
    private static int b = 1;
    public static int next(){
        int t = a;
        a = b;
        b = t + b;
        return a;
    }
}

class FibPair{
    int a;
    int b;
    FibPair(int a, int b){
        this.a = a;
        this.b = b;
    }
    public FibPair next(){
        return new FibPair(b,a+b);
    }
    public int toInt(){
        return a;
    }
}