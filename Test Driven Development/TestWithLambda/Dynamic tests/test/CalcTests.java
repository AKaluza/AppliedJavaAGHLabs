

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CalcTests {
  CalculatorDynamicTest test = new CalculatorDynamicTest();
  @RepeatedTest(5)
  public void testSolution() {
      final var dynamicTestStream = test.testDifferentMultiplyOperations();
      dynamicTestStream.forEach(dynamicTest -> {
          try {
              dynamicTest.getExecutable().execute();
          } catch (Throwable e) {
              throw new RuntimeException(e);
          }
      });
    }
}
