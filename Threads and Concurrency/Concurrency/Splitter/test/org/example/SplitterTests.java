package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.function.ToLongFunction;

public class SplitterTests {
    static final Random rng = new Random();

    @Test
    public void testSplitIn4() {
        final var n = 4;
        final var longs = rng.longs(900000, -100, 100).toArray();
        final var callables = Splitter.split(longs, n, v -> 0);
        Assertions.assertEquals(n, callables.size(), "Split function returns wrong size of collection");
    }

    @Test
    public void testSplitIn9() {
        final var n = 9;
        final var longs = rng.longs(900000, -100, 100).toArray();
        final var callables = Splitter.split(longs, n, v -> 0);
        Assertions.assertEquals(n, callables.size(), "Split function returns wrong size of collection");
    }

    @Test
    public void testWithSumFunction() {
        final var longs = rng.longs(700000, -100, 100).toArray();
        final var expected = Arrays.stream(longs).sum();

        final var slices0 = 7;
        final var callables0 = Splitter.split(longs, slices0, value -> Arrays.stream(value).sum());
        Assertions.assertEquals(slices0, callables0.size(), "Split function returns wrong size of collection");

        final var actual =
                callables0
                        .stream()
                        .map(callable -> {
                            try {
                                return callable.call();
                            } catch (Exception e) {
                                return 0L;
                            }
                        })
                        .reduce(Long::sum)
                        .get();

        // put your test here
        Assertions.assertEquals(expected, actual, "Sum function does not return a correct value");
    }

    @Test
    public void testWithLengthFunction() {
        final var longs = rng.longs(1300000, -100, 100).toArray();
        final var expected = longs.length;

        final var slices0 = 13;
        final var callables0 = Splitter.split(longs, slices0, value -> value.length);
        Assertions.assertEquals(slices0, callables0.size(), "Split function returns wrong size of collection");

        final var actual =
                callables0
                        .stream()
                        .map(callable -> {
                            try {
                                return callable.call();
                            } catch (Exception e) {
                                return 0L;
                            }
                        })
                        .reduce(Long::sum)
                        .get();

        // put your test here
        Assertions.assertEquals(expected, actual, "Length value does not return a correct value");
    }
}