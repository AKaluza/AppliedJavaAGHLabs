package org.example;

import org.example.model.Accumulator;

public class VolatileAccumulator implements Accumulator {
    private volatile int s = 0;
    @Override
    public void increment() {
        s++;
    }

    @Override
    public int get() {
        return s;
    }
}
