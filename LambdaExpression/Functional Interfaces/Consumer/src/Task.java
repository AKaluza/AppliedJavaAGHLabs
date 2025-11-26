import java.util.function.Consumer;
import static org.junit.jupiter.api.Assertions.*;

public class Task {
    /* TODO: Consumer<String> shout = ... */
    private  Consumer<String> shout = s -> System.out.println(s.toUpperCase() + "!");

    public Consumer<String> getShout() {
        return shout;
    }

    public static void main(String[] args) {
         // // Uncomment after implementing:
         Task task = new Task();
         task.shout.accept("hello");
    }
}