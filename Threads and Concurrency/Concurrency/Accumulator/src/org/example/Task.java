package org.example;

import org.example.model.Accumulator;
import org.junit.jupiter.api.Assertions;
import org.opentest4j.AssertionFailedError;

public class Task {
    public static void main(String[] args) throws InterruptedException {
        final Accumulator simpleAccumulator = new SimpleAccumulator();
        final Accumulator atomicAccumulator = new AtomicAccumulator();
        final Accumulator brokenAccumulator = new BrokenAccumulator();
        final Accumulator volatileAccumulator = new VolatileAccumulator();

        long startTime, endTime;
        int n = 1000000;

        startTime = System.currentTimeMillis();
        Task.doJob(simpleAccumulator,n);
        endTime = System.currentTimeMillis();
        System.out.println("simpleAccumulator "+(endTime-startTime)+" miliseconds");
        Assertions.assertEquals(n,simpleAccumulator.get());

        startTime = System.currentTimeMillis();
        Task.doJob(atomicAccumulator,n);
        endTime = System.currentTimeMillis();
        System.out.println("atomicAccumulator "+(endTime-startTime)+" miliseconds");
        Assertions.assertEquals(n,atomicAccumulator.get());

        startTime = System.currentTimeMillis();
        Task.doJob(brokenAccumulator,n);
        endTime = System.currentTimeMillis();
        System.out.println("brokenAccumulator "+(endTime-startTime)+" miliseconds");
        try {
            Assertions.assertEquals(n, brokenAccumulator.get());
        }catch( AssertionFailedError e) {
            System.out.println(e.getMessage());
        }
        startTime = System.currentTimeMillis();
        Task.doJob(volatileAccumulator,n);
        endTime = System.currentTimeMillis();
        System.out.println("volatileAccumulator "+(endTime-startTime)+" miliseconds");
        try{
            Assertions.assertEquals(n,volatileAccumulator.get());
        }catch( AssertionFailedError e) {
            System.out.println(e.getMessage());
        }
    }

    public static void doJob(Accumulator accumulator, int n) throws InterruptedException {

        final var job = new FiveJob(accumulator, n / 5);
        final var thread1 = new Thread(job);
        final var thread2 = new Thread(job);
        final var thread3 = new Thread(job);
        final var thread4 = new Thread(job);
        final var thread5 = new Thread(job);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
    }
}