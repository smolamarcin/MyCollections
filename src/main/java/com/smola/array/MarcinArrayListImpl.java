package com.smola.array;

import com.smola.collections.MarcinList;

import java.util.Iterator;

public class MarcinArrayListImpl<E> implements MarcinList<E> {
    private static final int INIT_CAPACITY = 16;
    private Object[] array;
    private int actualListSize = 0;

    public MarcinArrayListImpl() {
        this.array = new Object[INIT_CAPACITY];
    }

    @Override
    public int size() {
        return actualListSize;
    }

    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }

    @Override
    public boolean add(E e) {
        if (actualListSize < array.length){
            array[actualListSize] = e;
        }else {
            resizeArray(this.array);
            array[actualListSize] = e;
        }
        actualListSize++;
        return true;
    }

    private void resizeArray(Object[] array) {
        Object[] tempArray = new Object[actualListSize * 2];
        for (int i = 0; i < array.length; i++) {
            tempArray[i] = array[i];
        }
        this.array = tempArray;
    }

    @Override
    public void clear() {
        for (int i = 0; i < actualListSize; i++) {
            array[i] = null;
        }
        actualListSize = 0;
    }

    @Override
    public boolean remove(E toRemove) {
        boolean result = false;
        for (int i = 0; i < actualListSize; i++) {
            if (this.array[i].equals(toRemove)){
                result = true;
                for (int j = i; j <= actualListSize; j++) {
                    this.array[j] = this.array[j+1];
                }
                actualListSize--;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean contains(E e) {
        boolean result = false;
        for (int i = 0; i < actualListSize; i++) {
            if (array[i].equals(e)){
                result =  true;
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;
            private E e;
            @Override
            public boolean hasNext() {
                return index < actualListSize;
            }

            @Override
            public E next() {
                e = (E) array[index];
                index++;
                return e;
            }
        };
    }

    @Override
    public E remove(int index) {
        Object toRemove = this.array[index];
        for (int i = index; i < actualListSize; i++) {
            array[i] = array[i +1];
        }
        actualListSize--;
        return (E) toRemove;
    }

    @Override
    public E get(int index) {
        return (E) this.array[index];
    }

    @Override
    public int indexOf(E e) {
        for (int i = 0; i < actualListSize; i++) {
            if (e.equals(this.array[i])){
                return i;
            }
        }
        throw new RuntimeException("Index does not exist.");
    }
}
