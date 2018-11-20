package com.smola.linked;

import com.smola.MarcinList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MarcinLinkedListImpl<E> implements MarcinList<E> {
    private int size;
    private Node head;
    private Node tail;

    @Override
    public E remove(int index) {
        E e = get(index);
        if (remove(e)) {
            return e;
        }
        return null;
    }

    @Override
    public E get(int index) {
        Iterator<E> iterator = this.iterator();
        int currentIndex = 0;
        E next = null;
        while (iterator.hasNext()) {
            next = iterator.next();
            if (currentIndex == index) {
                break;
            }
            currentIndex++;
        }
        return next;
    }

    @Override
    public int indexOf(E e) {
        int index = 0;
        Iterator<E> iterator = this.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(e)) {
                return index;
            }
            index++;
        }
        throw new RuntimeException("Index does not exist.");
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(E e) {
        Node node = new Node(e);
        if (isEmpty()) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            this.tail = node;
        }
        this.size++;
        return true;
    }

    @Override
    public boolean remove(E e) {
        boolean result = false;
        Node currentNode = head;
        if (checkHead(currentNode, e)) {
            result = true;
        }
        while (head != null && currentNode.next.hasNext()) {
            if (currentNode.next.value.equals(e)) {
                unlink(currentNode);
                result = true;
                break;
            }
            currentNode = currentNode.next;
        }

        return result;
    }

    private boolean checkHead(Node head, E e) {
        boolean result = false;
        if (size > 0 && head.value.equals(e)) {
            this.head = this.head.next;
            size--;
            result = true;
        }
        if (size == 1 && head.value.equals(e)) {
            clear();
        }
        return result;
    }

    private void unlink(Node node) {
        node.next = node.next.next;
        size--;
    }

    @Override
    public boolean contains(E e) {
        Node node = head;
        boolean result = false;
        while (node != null) {
            if (node.value.equals(e)) {
                result = true;
            }
            node = node.next;
        }
        return result;
    }

    @Override
    public void clear() {
        Node currentNode = this.head.next;
        while (currentNode != null) {
            size--;
            currentNode = currentNode.next;
        }
        this.head = null;
        this.tail = null;
        size--;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (current == null) {
                    throw new NoSuchElementException();
                }
                Node res = current;
                current = current.next;
                return res.value;
            }
        };
    }


    public E getHead() {
        if (head != null) {
            return head.value;
        }
        return null;
    }

    public E getTail() {
        if (tail != null) {
            return tail.value;
        }
        return null;
    }

    private class Node {
        E value;
        Node next;

        public Node(E e) {
            this.value = e;
        }

        public boolean hasNext() {
            return next != null;
        }
    }
}
