package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Tests {

    @Test
    void testEmptyBufferAcceptsElement() {
        final var buffer = new OneElementBuffer<Integer>();
        Assertions.assertTrue(buffer.put(1, 100), "Empty buffer did not accept element");
    }

    @Test
    void testBufferReturnsFalseOnSecondElement() {
        final var buffer = new OneElementBuffer<Integer>();
        Assertions.assertTrue(buffer.put(1, 100), "Empty buffer did not accept element");
        Assertions.assertFalse(buffer.put(1, 100), "Buffer with one element accepted element");
    }

    @Test
    void testEmptyBufferReturnsNull() {
        final var buffer = new OneElementBuffer<Integer>();
        Assertions.assertNull(buffer.get(100), "Empty buffer returned element");
    }

    @Test
    void testBufferReturnsElement() {
        final var buffer = new OneElementBuffer<Integer>();
        Assertions.assertTrue(buffer.put(1, 100), "Empty buffer did not accept element");
        Assertions.assertEquals(1, buffer.get(100), "Non-empty buffer did not return expected element");
    }

    @Test
    void testProducerProducesConsumerConsumes() throws InterruptedException, ExecutionException {
        final var buffer = new OneElementBuffer<Integer>();
        final var producer = new NumberProducer(10000, buffer);
        final var consumer = new NumberConsumer(10000, buffer);
        final var consumer1 = new NumberConsumer(10000, buffer);

        final var future0 = CompletableFuture.supplyAsync(producer::produce);
        final var future1 = CompletableFuture.supplyAsync(consumer::consume);
        final var future2 = CompletableFuture.supplyAsync(consumer1::consume);

        final var expected = future0.get();
        final var actual = future1.get();
        final var actual1 = future2.get();

        actual.addAll(actual1);

        Assertions.assertEquals(expected.size(), actual.size(), "element was consumed more than once");
        Assertions.assertEquals(expected, actual.stream().sorted().toList());
    }
}