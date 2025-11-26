package org.example.lifo;

public interface LIFOQueue<T> {

    T poll();

    T peek();

    void put(T t);
}
