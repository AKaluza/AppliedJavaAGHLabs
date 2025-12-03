package org.example;

import org.example.model.Buffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ModernOneElementBuffer<T> implements Buffer<T> {
    private T element=null;

    @Override
    public boolean put(T t, long timeout)  {
        long curr_time, start_time = System.currentTimeMillis();
        long delay = timeout;
        synchronized (this){
            while(!Objects.isNull(element)&& delay>0){
                curr_time = System.currentTimeMillis();
                delay = start_time+timeout - curr_time;
                if(delay>0)
                    try {
                        wait(delay);
                    }catch(InterruptedException e){
                        return false;
                    }
            }
            if(!Objects.isNull(element))
                return false;
            element = t;
            notify();
            return true;
        }
    }

    @Override
    public T get(long timeout) {
        long curr_time, start_time = System.currentTimeMillis();
        long delay = timeout;
        synchronized(this){
            while(Objects.isNull(element) && delay>0){
                curr_time = System.currentTimeMillis();
                delay = start_time+timeout - curr_time;
                if(delay>0)
                    try {
                        wait(delay);
                    }catch(InterruptedException e){
                        return null;
                    }
            }
            if(Objects.isNull(element))
                return null;
            T t = element;
            element = null;
            notify();
            return t;
        }
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final var buffer = new ModernOneElementBuffer<Integer>();
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
