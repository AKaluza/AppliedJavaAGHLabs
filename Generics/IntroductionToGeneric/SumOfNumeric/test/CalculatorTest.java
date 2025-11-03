import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

  @Test
  void shouldAddIntegers() {
    double result = Calculator.add(3, 7);
    assertEquals(10.0, result, 0.0001);
  }

  @Test
  void shouldAddDoubles() {
    double result = Calculator.add(1.5, 2.25);
    assertEquals(3.75, result, 0.0001);
  }

  @Test
  void shouldAddFloats() {
    double result = Calculator.add(1.0f, 2.0f);
    assertEquals(3.0, result, 0.0001);
  }
}
