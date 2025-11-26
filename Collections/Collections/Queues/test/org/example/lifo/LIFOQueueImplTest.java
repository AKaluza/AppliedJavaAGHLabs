package org.example.lifo;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO Please implement the LIFOQueueImpl using any java collection as a composite, for good time efficiency.
 */
public class LIFOQueueImplTest {

    /* if the performance test does not pass and you are sure you fixed the problem, please rerun */
    @Test
    @Timeout(value = 1000)
    public void runEfficiencyTest() {
        LIFOQueue<Integer> lifo = new LIFOQueueImpl<>();
        assertDoesNotThrow(() -> {
            for (int i = 0; i < 1000000; i++) {
                lifo.put(i);
            }
        });
        for (int i = 999999; i >= 0; i--) {
            assertEquals(Integer.valueOf(i), lifo.poll());
        }
        assertNull(lifo.peek());
    }

}
