package com.smola;

public interface MarcinList<E> extends MarcinCollections<E>,Iterable<E> {
    E remove(int index);
    E get(int index);

    int indexOf(E e);
}
