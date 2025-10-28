import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.opentest4j.TestAbortedException;


import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalcTests {
  CalculatorTest test = new CalculatorTest();
  @BeforeEach
  void setUp() throws Exception {
    test.setUp();
  }

  @Test
  public void testSolution1(){
    Assertions.assertDoesNotThrow(
            ()-> Assertions.assertTrue(CalculatorTest.class.getDeclaredMethod("testDivideWithZero1")
                    .isAnnotationPresent(Disabled.class), "Use @Disabled  ")
    );
  }

  @Test
  public void testSolution2() {
    Throwable exception = assertThrows(TestAbortedException.class, () -> test.testDivideWithZero2(),"Use Assumptions  ");
  }
}