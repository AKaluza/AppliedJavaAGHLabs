package org.example;

import org.example.model.Accumulator;

public class SimpleAccumulator implements Accumulator {
    private Integer s = 0;

    @Override
    public void increment() {
        synchronized (this) {
                s++;
            }
        }

    @Override
    public int get() {
        return s;
    }
}
