package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyArrayListImplTest {
    /**
     * List must store all 10 integers [30,29,28,...,21]
     */
    @Test
    public void testIt() {
        MyArrayList<Integer> list = new MyArrayListImpl<>(10);

        assertDoesNotThrow(() -> {
            for (int i = 0; i < 10; i++) {
                var number = 30 - i;
                list.add(number);
            }
        });

        for (int i = 0; i < 10; i++) {
            assertEquals(Integer.valueOf(30 - i), list.get(i));
        }
        assertEquals(10, list.size());
    }

    /**
     * List must not grow above size given in constructor.
     * In such case it must throw IndexOutOfBoundsException.
     */
    @Test
    public void testDoesNotGrow() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            MyArrayList<Integer> list = new MyArrayListImpl<>(10);
            for (int i = 0; i < 11; i++) {
                list.add(i);
            }
        });
    }

    /**
     * List must throw IndexOutOfBoundsException when get() parameter exceeds the number of elements
     */
    @Test
    public void testGetOverflow() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            MyArrayList<Integer> list = new MyArrayListImpl<>(10);
            list.add(0);
            list.add(1);
            list.get(2);
        });
    }

}
