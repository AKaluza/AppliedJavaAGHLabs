import org.junit.jupiter.api.Test;
import java.util.function.Function;
import static org.junit.jupiter.api.Assertions.*;

class Tests {
  @Test
  void greeterTrimsAndGreets() {
    Task t = new Task();
    assertEquals("Hello, Alice!", t.greeter.apply("  Alice  "));
  }
}