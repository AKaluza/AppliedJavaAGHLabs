import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;

public class Calculator{
        public int fib(int n){
                if (n<=1)  return 1;
                return fib(n-1)+fib(n-2);
        }
        public long timeFib(int n){
                Instant start = Instant.now();
                fib(32);
                Instant end = Instant.now();
                return Duration.between(start,end).toNanos();
        }
}

class CalculatorTest {
        Calculator calculator;
        long timeOfFib32;

        @BeforeEach
        void setUp() {
                calculator = new Calculator();
                timeOfFib32 = calculator.timeFib(32);
        }

        @Test
        @DisplayName("Without result if time not exceed - timeoutNotExceeded")
        void timeoutNotExceeded() {
                assertTimeout(ofSeconds(0, timeOfFib32),
                        () -> calculator.fib(30));
        }

        // checks value of fib(30)
        @Test
        @DisplayName("You have to check a return value if time not exceed")
        void timeoutNotExceededWithResult() {
                int actualResult = assertTimeout(ofSeconds(0, timeOfFib32),
                        () -> {
                                return calculator.fib(30);
                        });
                assertEquals(1346269, actualResult);
        }

        @Test
        @DisplayName("Without result if time not exceed -timeoutNotExceeded2")
        void timeoutNotExceeded2() {
                assertTimeout(ofSeconds(0, timeOfFib32),
                        () -> calculator.fib(33));
        }
        //checks value of fib(33)
        @Test
        @DisplayName("You have to check a return value if time not exceed but with bounded timeout")
        void timeoutNotExceededWithResult2() {
                int actualResult = assertTimeoutPreemptively(ofSeconds(0, timeOfFib32),
                        () -> {
                                return calculator.fib(33);
                        });
                assertEquals(1346269, actualResult);
        }
}
