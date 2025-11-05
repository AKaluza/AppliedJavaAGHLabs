import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTests {
  Calculator calculator = new Calculator();

  @Test
  public void shouldReturnZeroForEmptyString() {
    int sum = calculator.sum("");

    assertEquals(0, sum);
  }

  @Test
  public void shouldReturnTheSameNumberIfThereIsOnlyOne() {
    int sum = calculator.sum("5");

    assertEquals(5, sum);
  }

  @Test
  public void shouldReturnSumOfTwoNumbers() {
    int sum = calculator.sum("2,4");

    assertEquals(6, sum);
  }

  @Test
  public void shouldCountSumOfMoreThanTwoNumbers() {
    int sum = calculator.sum("1,2,3,4");

    assertEquals(10, sum);
  }

  @Test
  public void shouldIgnoreNegativeNumbers() {
    int sum = calculator.sum("1,2,-3");

    assertEquals(3, sum);
  }

  @Test
  public void shouldThrowExceptionWhenSumIsBiggerThanOneHundred() {
    assertThrows(IllegalArgumentException.class, () -> calculator.sum("50,51"));
  }

}