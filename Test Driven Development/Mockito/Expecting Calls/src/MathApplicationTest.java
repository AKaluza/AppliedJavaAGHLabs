import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class MathApplicationTest {

    //@InjectMocks annotation is used to create and inject the mock object
    @InjectMocks
    MathApplication mathApplication = new MathApplication();

    //@Mock annotation is used to create the mock object to be injected
    @Mock
    CalculatorService calcService;

    @Test
    public void testAddSubtrack(){
        //add the behavior of calc service to add two numbers
        when(calcService.add(10.0,20.0)).thenReturn(30.00);

        //add the behavior of calc service to subtract two numbers
        doReturn(10.0).when(calcService).subtract(20.0,10.0);
        //when(calcService.subtract(20.0,10.0)).thenReturn(10.00);

        //test the add functionality
        assertEquals(mathApplication.add(10.0, 20.0),30.0,0);
        assertEquals(mathApplication.add(10.0, 20.0),30.0,0);
        assertEquals(mathApplication.add(10.0, 20.0),30.0,0);


        //test the subtract functionality
        assertEquals(mathApplication.subtract(20.0, 10.0),10.0,0.0);

        //default call count is 1
        verify(calcService).subtract(20.0, 10.0);

        //check if add function is called three times
        verify(calcService, atMost(3)).add(10.0, 20.0);

        //verify that method was never called on a mock
        verify(calcService, never()).multiply(10.0,20.0);
    }
}