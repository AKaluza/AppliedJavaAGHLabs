import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class Task {
  /* TODO: Supplier<Integer> random0to9 = ... */
  Supplier<Integer> random0to9 = () -> ThreadLocalRandom.current().nextInt(10);

  public static void main(String[] args) {
//       // Uncomment after implementing:
//       System.out.println(random0to9.get()); // e.g., 7
  }
}