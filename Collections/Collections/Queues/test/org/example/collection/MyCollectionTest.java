package org.example.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MyCollectionTest {
    @Test
    public void testFirst() {
        final var collection = new MyCollectionImpl<>();
        collection.add(List.of(1, 2, 3, 4, 5, 6, 7));
        Assertions.assertEquals(1, collection.first(), "first element is not equal to 1");
    }

    @Test
    public void testSecond() {
        final var collection = new MyCollectionImpl<>();
        collection.add(List.of(1, 2, 3, 4, 5, 6, 7));
        Assertions.assertEquals(2, collection.second(), "second element is not equal to 2");
    }

    @Test
    public void testThird() {
        final var collection = new MyCollectionImpl<>();
        collection.add(List.of(1, 2, 3, 4, 5, 6, 7));
        Assertions.assertEquals(3, collection.third(), "third element is not equal to 3");
    }

    @Test
    public void testLast() {
        final var collection = new MyCollectionImpl<>();
        collection.add(List.of(1, 2, 3, 4, 5, 6, 7));
        Assertions.assertEquals(7, collection.last(), "last element is not equal to 7");
    }

    @Test
    public void testIfFirstFailsOnEmptyCollection() {
        final var collection = new MyCollectionImpl<>();
        Assertions.assertThrows(IndexOutOfBoundsException.class, collection::first);
    }

    @Test
    public void testIfLastFailsOnEmptyCollection() {
        final var collection = new MyCollectionImpl<>();
        Assertions.assertThrows(IndexOutOfBoundsException.class, collection::last);
    }

    @Test
    public void testIfSecondFailsOnCollectionWithTwoElements() {
        final var collection = new MyCollectionImpl<>();
        collection.add(List.of(1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, collection::second);
    }

    @Test
    public void testIfThirdFailsOnEmptyCollection() {
        final var collection = new MyCollectionImpl<>();
        collection.add(List.of(1, 2));
        Assertions.assertThrows(IndexOutOfBoundsException.class, collection::third);
    }
}
