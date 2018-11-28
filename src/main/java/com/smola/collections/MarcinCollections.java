package com.smola.collections;

public interface MarcinCollections<E> extends Iterable<E> {
    int size();
    boolean isEmpty();
    boolean add(E e);
    boolean remove(E e);
    boolean contains(E e);
    void clear();
}
