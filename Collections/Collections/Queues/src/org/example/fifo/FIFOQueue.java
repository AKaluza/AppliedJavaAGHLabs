package org.example.fifo;

public interface FIFOQueue<T> {

    T poll();

    T peek();

    void put(T t);
}
