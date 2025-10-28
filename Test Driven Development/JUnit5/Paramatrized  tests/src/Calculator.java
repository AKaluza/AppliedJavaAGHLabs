import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

// class to be tested
public class Calculator {
    public int multiply(int i, int j) {
        return i * j;
    }
}

class CalculatorParametrizedTest {
    Calculator calculator = new Calculator();
    static Random rand = new Random(1);


    public static int[][] get_data() {
        int n = rand.nextInt(4,10);
        int[][] data = new int[n][3];
        for(int i=0;i<n;i++){
            int a = rand.nextInt(1,1000);
            int b = rand.nextInt(1,1000);
            data[i][0] = a;
            data[i][1] = b;
            data[i][2] = a * b;
        }
        return data;
    }

    //use get_data as source
    @ParameterizedTest
    @MethodSource(value =  "get_data")
    public void testWithParameterTable(int[] data) {
        int m1 = data[0];
        int m2 = data[1];
        int expected = data[2];
        assertEquals(expected, calculator.multiply(m1, m2));
    }

    //use {"569, 371, 211099",
    //                "160, 765, 122400",
    //                "2, 3, 6"} as source
    @ParameterizedTest
    @CsvSource({"569, 371, 211099",
                "160, 765, 122400",
                "2, 3, 6"})
    public void testWithCsvTable(int a, int b, int expected) {
        assertEquals(expected, calculator.multiply(a, b));
    }


}