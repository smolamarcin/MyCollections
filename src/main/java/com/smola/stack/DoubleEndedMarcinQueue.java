package com.smola.stack;

import com.smola.MarcinCollections;

import java.util.Collections;

public interface DoubleEndedMarcinQueue<E> extends MarcinCollections<E> {
    E poll();
    void push(E e);
    boolean remove(E e);
}
