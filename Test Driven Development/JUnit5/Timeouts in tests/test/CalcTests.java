import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import static org.junit.jupiter.api.Assertions.*;

public class CalcTests {
  CalculatorTest test = new CalculatorTest();

  @BeforeEach
  void setUp() {
    test.setUp();
  }

  @Test
  public void testSolution1() {
    assertDoesNotThrow(() -> test.timeoutNotExceeded());
  }

  @Test
  public void testSolution2() {
    assertDoesNotThrow(() -> test.timeoutNotExceededWithResult());
  }

  @Test
  public void testSolution3() {
      assertThrows(AssertionFailedError.class,
              () -> test.timeoutNotExceeded2());
  }

  @Test
  public void testSolution4() {
      Throwable exception = assertThrows(AssertionFailedError.class,
        () -> test.timeoutNotExceededWithResult2());
      assertEquals("execution timed out after",
              exception.getMessage().substring(0,25));
  }
}