import java.util.function.BiFunction;

public class Task {
    BiFunction<Integer, Integer, Integer> multiply = (var a, var b) -> a * b;

    public static void main(String[] args) {
        /* TODO: implement BiFunction<Integer,Integer,Integer> multiply using (var a, var b) -> ... */

        //  // Uncomment after implementing:
        Task task = new Task();
        System.out.println(task.multiply.apply(6, 7)); // 42
    }
}