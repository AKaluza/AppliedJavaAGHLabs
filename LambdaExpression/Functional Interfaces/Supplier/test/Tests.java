
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class Tests {
  @Test
  void supplierReturns0to9() {
    Task t = new Task();
    Supplier<Integer> random0to9 = new Task().random0to9;
    for (int i = 0; i < 100; i++) {
      int v = random0to9.get();
      assertTrue(0 <= v && v <= 9, "Value should be in [0,9]");
    }
  }
}