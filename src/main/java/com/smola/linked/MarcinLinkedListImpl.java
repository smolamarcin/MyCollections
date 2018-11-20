package com.smola.linked;

import com.smola.MarcinList;

import java.util.Iterator;

public class MarcinLinkedListImpl<E> implements MarcinList<E> {
    private int size;
    private Node head;
    private Node tail;

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int indexOf(E e) {
        int index = 0;
        Node node = head;
        while (node != null) {
            if (node.value.equals(e)) {
                return index;
            }
            index++;
            node = node.next;
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
        if (head == null) {
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
        if(checkHead(currentNode,e)){
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

    private boolean checkHead(Node head,E e) {
        boolean result = false;
        if (size > 0 &&head.value.equals(e)){
            this.head = this.head.next;
            size--;
            result = true;
        }
        if (size == 1){
            this.head = null;
            size--;
            result = true;
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

    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }


    public E getHead() {
        if (head != null) {
            return head.value;
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
