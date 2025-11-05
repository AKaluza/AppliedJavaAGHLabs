import org.junit.jupiter.api.Test;
import java.util.function.BiFunction;
import static org.junit.jupiter.api.Assertions.*;

class Tests {
  @Test
  void multiplyWorks() {
    Task task = new Task();
    assertEquals(42, task.multiply.apply(6,7));
  }
}