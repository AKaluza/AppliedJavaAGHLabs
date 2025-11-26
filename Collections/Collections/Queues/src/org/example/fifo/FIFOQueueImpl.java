package org.example.fifo;

import java.util.LinkedList;

public class FIFOQueueImpl<T> implements FIFOQueue<T> {

    private LinkedList<T> lst = new LinkedList<>();

    @Override
    public T poll() {
        return lst.pollFirst();
    }

    @Override
    public T peek() {
        return lst.peekFirst();
    }

    @Override
    public void put(T t) {
        lst.addLast(t);
    }
}
