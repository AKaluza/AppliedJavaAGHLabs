import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;


public class Calculator {

    public int divide(int a, int b) {
        return a / b;
    }
}

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @RepeatedTest(5)
    @DisplayName("Ensure correct handling of zero")
    @Disabled
    void testDivideWithZero1() {
        assertEquals(calculator.divide(0,5), 0, "Divide zero by positive number");
        assertEquals(calculator.divide(5,0), 0, "Divide by zero");
        throw new NullPointerException();
    }
    @RepeatedTest(5)
    @DisplayName("Ensure correct handling of zero")
    void testDivideWithZero2() {
        Assumptions.assumeFalse(System.getProperty("os.name").contains("Mac"));
        assertEquals(calculator.divide(0,5), 0, "Divide zero by positive number");
        assertEquals(calculator.divide(5,0), 0, "Divide by zero");
    }
}