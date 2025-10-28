import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Tests {
  @Test
  void boxShouldHoldGenericType() {
    Box<Integer> intBox = new Box<>();
    intBox.set(10);
    assertEquals(10, intBox.get());

    Box<String> strBox = new Box<>();
    strBox.set("Generics");
    assertEquals("Generics", strBox.get());
  }
}