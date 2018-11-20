package com.smola;

public interface MarcinCollections<E> {
    int size();
    boolean isEmpty();
    boolean add(E e);
    boolean remove(E e);
    boolean contains(E e);
    void clear();
}