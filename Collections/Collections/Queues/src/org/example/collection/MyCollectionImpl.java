package org.example.collection;

import java.util.ArrayList;
import java.util.Collection;

public class MyCollectionImpl<T> implements MyCollection<T> {

    private ArrayList<T> lst = new ArrayList<>();

    @Override
    public void add(Iterable<T> integers) {
        lst.addAll((Collection<? extends T>) integers);
    }

    @Override
    public T first() {
        return lst.get(0);
    }

    @Override
    public T second() {
        return lst.get(1);
    }

    @Override
    public T third() {
        return lst.get(2);
    }

    @Override
    public T last() {
        return lst.get(lst.size()-1);
    }
}
