package org.example.model;

/* TODO */
/**
 * @param <T> type of objects to be stored in a buffer
 */
public interface Buffer<T> {
    /**
     * @param t object of type T to be added to a buffer
     * @param timeout maximum time for operation to complete in milliseconds
     * @return true if object was added successfully or false if was not added i.e. because of timeout
     */
    boolean put(T t, long timeout);

    /**
     * @param timeout maximum time for operation to complete in milliseconds
     * @return reference to a first available object or null if there is no object in a buffer within specified timeout
     */
    T get(long timeout);
}
