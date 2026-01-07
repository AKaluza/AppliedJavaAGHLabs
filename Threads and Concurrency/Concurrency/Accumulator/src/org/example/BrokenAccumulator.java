package org.example;

import org.example.model.Accumulator;

public class BrokenAccumulator implements Accumulator {
    private int s = 0;
    @Override
    public   void increment() {
        s++;
    }

    @Override
    public int get() {
        return s;
    }
}
