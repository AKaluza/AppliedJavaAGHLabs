import java.util.function.BiFunction;
import java.util.function.Supplier;

public class Task {
    /* TODO: implement Supplier<String> message = ... and BiFunction<Integer,Integer,Integer> sum = ... */
    Supplier<String> message = () -> "Hello Lambda!";
    BiFunction<Integer,Integer,Integer> sum = (a,b) -> a+b;

    public static void main(String[] args) {
        // Uncomment after implementing:
        Task task = new Task();
        System.out.println(task.message.get());
        System.out.println(task.sum.apply(3, 4));
    }
}