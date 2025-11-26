package org.example.fifo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * TODO Please implement the FIFOQueueImpl using any java collection as a composite, for good time efficiency.
 */
public class FIFOQueueImplTest {
    @Test
    public void testIfPutIsImplemented() {
        Assertions.assertDoesNotThrow(() -> {
            final var fifo = new FIFOQueueImpl<Integer>();
            fifo.put(0);
        }, "put() not implemented?");
    }

    @Test
    public void testIfPeekIsImplemented() {
        Assertions.assertDoesNotThrow(() -> {
            final var fifo = new FIFOQueueImpl<Integer>();
            fifo.peek();
        }, "peek() not implemented?");
    }

    @Test
    public void testIfPollIsImplemented() {
        Assertions.assertDoesNotThrow(() -> {
            final var fifo = new FIFOQueueImpl<Integer>();
            fifo.poll();
        }, "peek() not implemented?");
    }

    /**
     * if the performance test does not pass and you are sure you fixed the problem, please rerun
     */
    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    public void runEfficiencyTest() {
        Assertions.assertDoesNotThrow(() -> {
            FIFOQueue<Integer> fifo = new FIFOQueueImpl<>();
            for (int i = 0; i < 1000000; i++) {
                fifo.put(i);
            }
            for (int i = 0; i < 1000000; i++) {
                assertEquals(Integer.valueOf(i), fifo.poll());
            }
            assertNull(fifo.peek());
        }, "efficiency test failed");
    }

}
