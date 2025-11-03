import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GenericUtilsTest {

  @Test
  void shouldReturnSmallerInteger() {
    int result = GenericUtils.min(5, 10);
    assertEquals(5, result);
  }

  @Test
  void shouldReturnSmallerString() {
    String result = GenericUtils.min("apple", "banana");
    assertEquals("apple", result);
  }

  @Test
  void shouldReturnSmallerDouble() {
    double result = GenericUtils.min(3.14, 2.71);
    assertEquals(2.71, result, 0.0001);
  }
}