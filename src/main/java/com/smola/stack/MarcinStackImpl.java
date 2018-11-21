package com.smola.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class MarcinStackImpl<E> implements DoubleEndedMarcinQueue<E> {
    private static final int INIT_SIZE = 16;
    E[] array;
    private int size;

    public MarcinStackImpl() {
        array = (E[]) new Object[INIT_SIZE];
    }

    @Override
    public E poll() {
        return array[--size];
    }

    @Override
    public void push(E e) {
        array[++size] = e;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(E e) {
        return false;
    }

    @Override
    public boolean contains(E e) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
