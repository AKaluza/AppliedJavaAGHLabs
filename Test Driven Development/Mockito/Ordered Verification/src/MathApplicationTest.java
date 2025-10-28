import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class MathApplicationTest {

    private static MathApplication mathApplication;
    private static CalculatorService calcService;

    @BeforeAll
    public static void setUp() {
        mathApplication = new MathApplication();
        calcService = mock(CalculatorService.class);
        mathApplication.setCalculatorService(calcService);
    }

    @Test
    public void testAddAndSubtract() {

        //add the behavior to add numbers
        when(calcService.add(20.0, 10.0)).thenReturn(30.0);

        //subtract the behavior to subtract numbers
        when(calcService.subtract(20.0, 10.0)).thenReturn(10.0);


        //test the subtract functionality
        assertEquals(mathApplication.subtract(20.0, 10.0), 10.0, 0);

        //test the add functionality
        assertEquals(mathApplication.add(20.0, 10.0), 30.0, 0);

        //create an inOrder verifier for a single mock
        InOrder inOrder = inOrder(calcService);

        //following will make sure that add is first called then subtract is called.
        inOrder.verify(calcService).subtract(20.0, 10.0);
        inOrder.verify(calcService).add(20.0, 10.0);

    }
}