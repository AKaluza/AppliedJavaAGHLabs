import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
  @Test
  void functionTransformsToUsername() {
    Task task = new Task();

    assertEquals("alice_smith", task.toUsername.apply("  Alice Smith  "));
    assertEquals("java", task.toUsername.apply("Java"));
  }
}