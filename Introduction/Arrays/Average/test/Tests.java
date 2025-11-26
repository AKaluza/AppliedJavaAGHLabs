import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    @Test
    public void testAverage() {
        double[] nums = {10.1, 11.2, 12.3, 13.4, 14.5};
        assertEquals(Average.average(nums), Arrays.stream(nums).average().getAsDouble() );
    }
}
