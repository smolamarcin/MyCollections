package com.smola;

public interface MyCollections<E> {
    int size();
    boolean isEmpty();
    boolean add(E e);
    boolean remove(E e);
    boolean contains(E e);
    void clear();
}
