import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Calculator {

    public int divide(int a, int b) {
        return a / b;
    }
}

class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Divide by zero")
    void dvideByZero() throws Throwable {
        Throwable exception = assertThrows(ArithmeticException.class, () -> calculator.divide(1,0));
        assertEquals("/ by zero", exception.getMessage());
    }
}