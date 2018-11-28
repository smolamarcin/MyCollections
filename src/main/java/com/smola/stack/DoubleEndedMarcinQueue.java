package com.smola.stack;

import com.smola.collections.MarcinCollections;

public interface DoubleEndedMarcinQueue<E> extends MarcinCollections<E> {
    E poll();
    void push(E e);
    boolean remove(E e);
}
