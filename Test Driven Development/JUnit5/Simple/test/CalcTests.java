import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

public class CalcTests {
  @Test
  public void testSolution() {
    CalculatorTest calcTest = new CalculatorTest();
    assertThrows(AssertionFailedError.class, calcTest::demoTestMethod);
  }
}