package org.example.model;

import java.util.Collection;

/* TODO */
public interface Consumer<T> {
    Collection<T> consume();
}
