package org.example.lifo;

import java.util.LinkedList;

public class LIFOQueueImpl<T> implements LIFOQueue<T> {

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
        lst.addFirst(t);
    }
}
