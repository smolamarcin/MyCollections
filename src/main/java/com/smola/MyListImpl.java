package com.smola;

import java.util.Iterator;

public class MyListImpl<E> implements MyList<E> {
    public static final int INIT_ARRAY_LENGTH = 16;
    private Object[] array = new Object[INIT_ARRAY_LENGTH];
    private int actualListSize = 0;
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
            Object[] tempArray = new Object[actualListSize * 2];
            for (int i = 0; i < array.length; i++) {
                tempArray[i] = array[i];
            }
            this.array = tempArray;
        }
        actualListSize++;
        return true;
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
            if (array[i].equals(toRemove)){
                result = true;
                actualListSize--;
                for (int j = i; j < actualListSize; j++) {
                    array[j] = array[j+1];
                }
                break;
            }
        }
        return result;
    }

    @Override
    public boolean contains(E e) {
        for (int i = 0; i < actualListSize; i++) {
            if (array[i].equals(e)){
                return true;
            }
        }
        return false;
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
}
