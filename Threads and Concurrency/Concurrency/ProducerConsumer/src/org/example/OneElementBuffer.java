package org.example;

import org.example.model.Buffer;


import java.util.ArrayList;
import java.util.Arrays;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class OneElementBuffer<T> implements Buffer<T> {
    private T element;

    @Override
    public boolean put(T t, long timeout) {
        long deadlock = System.currentTimeMillis()+timeout;
        while(System.currentTimeMillis()<deadlock) {
            synchronized (this) {
                if (Objects.isNull(element)) {
                    element = t;
                    return true;
                }
            }
            Thread.yield();
        }
        return false;
    }

    @Override
    public T get(long timeout) {
        long deadlock = System.currentTimeMillis()+timeout;
        while(System.currentTimeMillis()<deadlock) {
            synchronized (this) {
                if (!Objects.isNull(element)) {
                   T toGet = element;
                   element = null;
                   return toGet;
                }
            }
            Thread.yield();
       }
        return null;
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final var buffer = new OneElementBuffer<Integer>();
        final var producer = new NumberProducer(10, buffer);
        final var consumer1 = new NumberConsumer(4, buffer);
        final var consumer2 = new NumberConsumer(8, buffer);

        final var future0 = CompletableFuture.supplyAsync(producer::produce);
        final var future1 = CompletableFuture.supplyAsync(consumer1::consume);
        final var future2 = CompletableFuture.supplyAsync(consumer2::consume);

        final var expected = future0.get();
        final var actual1 = future1.get();
        final var actual2 = future2.get();

        final var  actualAll = new ArrayList<Integer>();

        actualAll.addAll(actual1);
        actualAll.addAll(actual2);

        System.out.println("producer: " + Arrays.toString(expected.toArray()));
        System.out.println("consumer1: " + Arrays.toString(actual1.toArray()));
        System.out.println("consumer2: " + Arrays.toString(actual2.toArray()));
        System.out.println("all consumers: " + Arrays.toString(actualAll.stream().sorted().toArray()));
    }
}
