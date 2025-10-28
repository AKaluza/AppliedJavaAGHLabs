import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

// class to be tested
public class Calculator {
    public int multiply(int i, int j) {
        return i * j;
    }
}

class CalculatorDynamicTest {


    @TestFactory
    Stream<DynamicTest> testDifferentMultiplyOperations() {
        Random rand = new Random();
        Calculator calculator = new Calculator();
        int n = rand.nextInt(4,10);
        int[][] data = new int[n][3];
        for(int i=0;i<n;i++){
            int a = rand.nextInt(1,1000);
            int b = rand.nextInt(1,1000);
            data[i][0] = a;
            data[i][1] = b;
            data[i][2] = a * b;
        }
        return Arrays.stream(data)
                .map(entry -> {
                        int m1 = entry[0];
                        int m2 = entry[1];
                        int expected = entry[2];
                        return dynamicTest(m1 + " * " + m2 + " = " + expected,
                                () -> assertEquals(expected, calculator.multiply(m1, m2)));
                       }
                  );
    }

}