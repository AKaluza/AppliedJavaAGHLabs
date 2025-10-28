import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class Calculator {

    public int multiply(int a, int b) {
        return a * b;
    }
}

class CalculatorTest {

    Calculator calculator;
    Random rand;

    @Test
    void demoTestMethod() {
        assertTrue(true);
    }


    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        rand = new Random(1);
    }

    @Test
    @DisplayName("Simple multiplication should work")
    void testMultiply() {
        assertEquals(20, calculator.multiply(4, 5),
                "Regular multiplication should work");
    }

    @RepeatedTest(5)
    @DisplayName("Ensure correct handling of zero")
    void testMultiplyWithZero() {
        int x  = rand.nextInt(1,5);
        assertEquals(0, calculator.multiply(0, x), "Multiple with zero should be zero");
        assertEquals(0, calculator.multiply(x, 0), "Multiple with zero should be zero");
    }
}