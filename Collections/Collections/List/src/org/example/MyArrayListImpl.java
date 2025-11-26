package org.example;

import java.util.AbstractList;

public class MyArrayListImpl<T> extends AbstractList<T> implements MyArrayList<T> {

    private final Object[] lst;
    private int curr_size=0;

    public MyArrayListImpl(int size) {
        lst = new Object[size];
    }

    @Override
    public boolean add(T t) {
        if (curr_size == lst.length) {
            throw new IndexOutOfBoundsException("Maximum size=" + lst.length + " reached.");
        }
        lst[curr_size++] = t;
        return true;
    }

    @Override
    public T get(int index) {
        if (curr_size <= index) {
            throw new IndexOutOfBoundsException("Size is " + curr_size + " but " + index + "-th element requested");
        }
        return (T) lst[index];
    }

    @Override
    public int size() {
        return curr_size;
    }
}
