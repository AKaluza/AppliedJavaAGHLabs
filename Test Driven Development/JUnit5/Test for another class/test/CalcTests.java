import org.junit.jupiter.api.*;


public class CalcTests {
  CalculatorTest test;

  @BeforeEach
  void setUp(){
    test = new CalculatorTest();
    test.setUp();
  }


  @Test
  @DisplayName("Test for demoTestMethod()")
  public void testSolution1() {
    Assertions.assertDoesNotThrow(()->test.demoTestMethod());
  }

  @Test
  @DisplayName("Test for testMultiply()")
  public void testSolution2() {
    Assertions.assertDoesNotThrow(()->test.testMultiply());
  }

  @RepeatedTest(5)
  @DisplayName("Test for testMultiply()")
  public void testSolution3() {
    Assertions.assertDoesNotThrow(()->test.testMultiplyWithZero());
  }
}