package com.telran.collection;

import java.util.Arrays;

public class ArrayQueue<E> implements Queue<E> {

    private int size;
    private int first;
    private int capacity;
    private Object[] source;

    ArrayQueue(int capacity) {
        this.capacity = capacity;
        source = new Object[capacity];
    }

    @Override
    public void add(E e) {
        if (size == capacity)
            throw new QueueOverflowException();

        int index = (first + size) % capacity;
        source[index] = e;
        size++;

    }

    @Override
    public E release() {

        if (size == 0)
            throw new EmptyQueueException();


        int index = (first + size) % capacity;
        source[index] = first;
        first = (int) source[index];

        size--;


        return (E)source;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacity() {
        return capacity;
    }
}
