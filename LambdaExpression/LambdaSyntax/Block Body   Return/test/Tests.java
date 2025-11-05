import org.junit.jupiter.api.Test;
import java.util.function.Function;
import static org.junit.jupiter.api.Assertions.*;

class Tests {
  @Test
  void greeterTrimsAndGreets() {
    Function<String,String> greeter = name -> {
      String trimmed = name.trim();
      return "Hello, " + trimmed + "!";
    };
    assertEquals("Hello, Alice!", greeter.apply("  Alice  "));
  }
}