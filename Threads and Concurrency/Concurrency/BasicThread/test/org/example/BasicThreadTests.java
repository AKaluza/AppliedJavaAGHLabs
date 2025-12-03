package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasicThreadTests {

    private Runnable generateAction(long ms) {
        return () -> {
            try {
                Thread.sleep(ms);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }

    @Test
    public void testStartedOfThreads() throws InterruptedException {
        final var thread0 = new Thread(generateAction(500));
        final var thread1 = new Thread(generateAction(750));
        final var thread2 = new Thread(generateAction(1000));



        final var flag = BasicThread.started(thread0, thread1, thread2);
        Assertions.assertNotEquals(Thread.State.NEW, thread0.getState(), "thread0 is not runing");
        Assertions.assertNotEquals(Thread.State.NEW, thread1.getState(), "thread1 is not runing");
        Assertions.assertNotEquals(Thread.State.NEW, thread2.getState(), "thread2 is not runing");
        Assertions.assertTrue(flag, "completed should return true");

    }

    @Test
    public void testCompletionOfThreads() throws InterruptedException {
        final var thread0 = new Thread(generateAction(500));
        final var thread1 = new Thread(generateAction(750));
        final var thread2 = new Thread(generateAction(1000));

        thread0.start();
        thread1.start();
        thread2.start();

        final var flag = BasicThread.completed(thread0, thread1, thread2);
        Assertions.assertEquals(Thread.State.TERMINATED, thread0.getState(), "thread0 is still alive");
        Assertions.assertEquals(Thread.State.TERMINATED, thread1.getState(), "thread1 is still alive");
        Assertions.assertEquals(Thread.State.TERMINATED, thread2.getState(), "thread2 is still alive");
        Assertions.assertTrue(flag, "completed should return true");
    }
}