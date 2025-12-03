package org.example;

import org.example.model.Accumulator;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicAccumulator implements Accumulator {
    private final AtomicInteger s = new AtomicInteger(0);
    @Override
    public void increment() {
        s.getAndIncrement();
    }

    @Override
    public int get() {
        return s.get();
    }
}
