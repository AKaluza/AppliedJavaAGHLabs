import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Method;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcTests {
  CalculatorParametrizedTest test = new CalculatorParametrizedTest();
  Calculator calculator = test.calculator;
  static Random rand = new Random(2);


  public static int[][] get_data() {
    int n = rand.nextInt(4,10);
    int[][] data = new int[n][3];
    for(int i=0;i<data.length;i++){
      int a = rand.nextInt(1,1000);
      int b = rand.nextInt(1,1000);
      data[i][0] = a;
      data[i][1] = b;
      data[i][2] = a * b;
    }
    return data;
  }

  @ParameterizedTest
  @MethodSource(value =  "get_data")
  public void testWithParameterTable(int[] data) {
    int m1 = data[0];
    int m2 = data[1];
    int expected = data[2];
    assertEquals(expected, calculator.multiply(m1, m2),"Fix Calculator!!!");
  }

  @ParameterizedTest
  @CsvSource({"569, 371, 211099",
          "160, 765, 122400",
          "2, 3, 6"})
  public void testWithCsvTable(int a, int b, int expected) {
    assertEquals(expected, calculator.multiply(a, b),"Fix Calculator!!!");
  }

  @Test
  public void testParamerizedAnnotation1() throws NoSuchMethodException {
    Method m = CalculatorParametrizedTest.class.getMethod("testWithParameterTable",int[].class );
    Assertions.assertTrue(m.isAnnotationPresent(ParameterizedTest.class));
    Assertions.assertTrue(m.isAnnotationPresent(MethodSource.class));
    Assertions.assertArrayEquals(new String[]{"get_data"},m.getAnnotation(MethodSource.class).value());
  }

  @Test
  public void testParamerizedAnnotation2() throws NoSuchMethodException {
    Method m = CalculatorParametrizedTest.class.getMethod("testWithCsvTable",int.class, int.class,int.class );
    Assertions.assertTrue(m.isAnnotationPresent(ParameterizedTest.class));
    Assertions.assertTrue(m.isAnnotationPresent(CsvSource.class));
    Assertions.assertArrayEquals(new String[]{"569, 371, 211099",
                    "160, 765, 122400",
                    "2, 3, 6"},
            m.getAnnotation(CsvSource.class).value());
  }
}