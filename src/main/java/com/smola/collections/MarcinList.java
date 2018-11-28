package com.smola.collections;

public interface MarcinList<E> extends MarcinCollections<E> {
    E remove(int index);
    E get(int index);

    int indexOf(E e);
}
