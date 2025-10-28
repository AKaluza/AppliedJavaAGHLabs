import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class MathApplicationTest {
    static private MathApplication mathApplication;
    static private CalculatorService calcService;

    @BeforeAll
    static public void setUp(){
        mathApplication = new MathApplication();
        calcService = mock(CalculatorService.class);
        mathApplication.setCalculatorService(calcService);
    }

    @Test
    public void testAddAndSubtract(){

        //add the behavior to add numbers
        when(calcService.add(20.0,10.0)).thenReturn(30.0);

        //subtract the behavior to subtract numbers
        when(calcService.subtract(20.0,10.0)).thenReturn(10.0);

        //test the subtract functionality
        assertEquals(mathApplication.subtract(20.0, 10.0),10.0);

        //test the add functionality
        assertEquals(mathApplication.add(20.0, 10.0),30.0,0);
        //test the subtract functionality
        assertEquals(mathApplication.subtract(20.0, 10.0),10.0);

        //verify call to calcService is made or not
        verify(calcService,times(1)).add(20.0,10.0);
        verify(calcService, atLeast(2)).subtract(20.0,10.0);
    }
}