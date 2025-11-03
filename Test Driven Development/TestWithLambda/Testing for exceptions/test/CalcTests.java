import org.opentest4j.AssertionFailedError;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalcTests {
  CalculatorTest test;
  @BeforeEach
  void setUp(){
    test = new CalculatorTest();
  }

  @Test
  public void testSolution() throws Throwable {
      test.setUp();
      test.dvideByZero();
  }
}