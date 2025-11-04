import org.junit.jupiter.api.Test;
import java.util.function.*;
import static org.junit.jupiter.api.Assertions.*;

class Tests {
  @Test
  void supplierAndBiFunctionWork() {
    Task task = new Task();
    assertEquals("Hello Lambda!", task.message.get());
    assertEquals(7, task.sum.apply(3,4));
  }
}