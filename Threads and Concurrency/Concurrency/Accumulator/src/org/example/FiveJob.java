package org.example;

import org.example.model.Accumulator;
import org.example.model.Job;

public final class FiveJob implements Job {
    /* don't change */
    private final Accumulator accumulator;
    private final int n;

    public FiveJob(Accumulator accumulator, int n) {
        this.accumulator = accumulator;
        this.n = n;
    }

    @Override
    public void run() {
        for (var i = 0; i < n; ++i) {
            accumulator.increment();
        }
    }
}
