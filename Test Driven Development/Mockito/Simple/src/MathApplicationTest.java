import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;



public class MathApplicationTest {

    public static void test() {
        MathApplication mathApplication = mock(MathApplication.class);
        double a = 10.0;
        double b = 20.0;
        double c = 30.0;
        //add the behavior of mathApplication to add two numbers
        when(mathApplication.add(a, b)).thenReturn(c);

        //test the add functionality
        assertEquals(c, mathApplication.add(a, b));
        System.out.println("" + a + "*" + b +"=" + mathApplication.multiply(a, b));
    }
    public static void main(String[] args){
        test();
    }
}