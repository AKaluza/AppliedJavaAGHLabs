package org.example.collection;

public interface MyCollection<T> {

    void add(Iterable<T> integers);

    T first();

    T second();

    T third();

    T last();
}
