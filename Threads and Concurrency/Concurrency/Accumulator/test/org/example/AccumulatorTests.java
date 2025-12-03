package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccumulatorTests {
    //TODO zrobic testy wydajnosciowe
    @Test
    public void testSolutionSimpleAcumulator() {
        final var simpleAccumulator = new SimpleAccumulator();
        Assertions.assertDoesNotThrow(
                () -> Task.doJob(simpleAccumulator, 1000000),
                "Task.doJob must not thrown an exception"
        );
        Assertions.assertEquals(1000000, simpleAccumulator.get(), "Accumulator value is incorrect");
    }
    @Test
    public void testSolutionAtomicAcumulator() {
       final var atomicAccumulator = new AtomicAccumulator();
        Assertions.assertDoesNotThrow(
                () -> Task.doJob(atomicAccumulator, 1000000),
                "Task.doJob must not thrown an exception"
        );
        Assertions.assertEquals(1000000, atomicAccumulator.get(), "Accumulator value is incorrect");

    }

    @Test
    public void testSolutionBrokenAcumuletor() {
        final var accumulator = new BrokenAccumulator();
        Assertions.assertDoesNotThrow(
                () -> Task.doJob(accumulator, 1000000),
                "Task.doJob must not thrown an exception"
        );
        Assertions.assertEquals(1000000, accumulator.get(), "Accumulator value is incorrect");

    }


}