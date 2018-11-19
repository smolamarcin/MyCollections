package com.smola;

import java.util.Iterator;

public class MyListImpl<E> implements MyList<E> {
    public static final int INIT_ARRAY_LENGTH = 16;
    private Object[] array = new Object[INIT_ARRAY_LENGTH];
    private int actualArraySize = 0;
    @Override
    public int size() {
        return actualArraySize;
    }

    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }

    @Override
    public boolean add(E e) {
        if (actualArraySize < array.length){
            array[actualArraySize] = e;
        }else {
            Object[] tempArray = new Object[actualArraySize * 2];
            for (int i = 0; i < array.length; i++) {
                tempArray[i] = array[i];
            }
            this.array = tempArray;
        }
        actualArraySize++;
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        actualArraySize = 0;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        throw new RuntimeException("Not implemented yet");
    }
}
