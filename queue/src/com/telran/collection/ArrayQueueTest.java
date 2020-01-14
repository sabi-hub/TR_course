package com.telran.collection;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayQueueTest {

    @Test
    public void testSize_EmptyList_0elements() {
        int[] source = {};
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);
        for (int i = 0; i < source.length; i++) {
            queue.add(i);
        }
        assertEquals(0, queue.size());
    }

    @Test
    public void testSize_nonEmptyList_3elements() {
        int[] source = {2, 4, 1};
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);
        for (int i = 0; i < source.length; i++) {
            queue.add(i);
        }
        assertEquals(3, queue.size());
    }

    @Test
    public void testSize_nonEmptyList_fullCapacity() {
        int[] source = {2, 4, 1, 10, 8};
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);
        for (int i = 0; i < source.length; i++) {
            queue.add(i);
        }
        assertEquals(5, queue.size());
    }

    @Test
    public void testCapacity_EmptyList_0elements() {
        int[] source = {};
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);
        for (int i = 0; i < source.length; i++) {
            queue.add(i);
        }
        assertEquals(5, queue.capacity());
    }

    @Test
    public void testCapacity_nonEmptyList_3elements() {
        int[] source = {2, 4, 1};
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);
        for (int i = 0; i < source.length; i++) {
            queue.add(i);
        }
        assertEquals(5, queue.capacity());
    }

    @Test
    public void testAdd_EmptyList_firstElement() {
        int[] source = {};
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);
        for (int i = 0; i < source.length; i++) {
            queue.add(i);
        }
        queue.add(5);
        assertEquals(1, queue.size());
    }

    @Test
    public void testAdd_nonEmptyList_middleElement() {
        int[] source = {2, 4};
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);
        for (int i = 0; i < source.length; i++) {
            queue.add(i);
        }
        queue.add(5);
        assertEquals(3, queue.size());
    }

    @Test
    public void testAdd_nonEmptyList_lastElement() {
        int[] source = {2, 4, 6, 8};
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);
        for (int i = 0; i < source.length; i++) {
            queue.add(i);
        }
        queue.add(5);
        assertEquals(5, queue.size());
    }

    @Test(expected = QueueOverflowException.class)
    public void testAdd_fullList_overFlowException() {
        int[] source = {2, 4, 6, 8, 10};
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);
        for (int i = 0; i < source.length; i++) {
            queue.add(i);
        }
        queue.add(5);
    }

    @Test
    public void testRelease_nonEmptyList_3Elements() {
        int[] source = {2, 4,5};
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);
        for (int i = 0; i < source.length; i++) {
            queue.add(i);
        }
        queue.release();
        assertEquals(2, queue.size());

    }

    @Test
    public void testRelease_nonEmptyList_fullCapacity() {
        int[] source = {2, 4,5,8,9};
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);
        for (int i = 0; i < source.length; i++) {
            queue.add(i);
        }
        queue.release();
        assertEquals(4, queue.size());

    }

    @Test
    public void testRelease_nonEmptyList_onlyFirstElement() {
        int[] source = {2};
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);
        for (int i = 0; i < source.length; i++) {
            queue.add(i);
        }
        queue.release();
        assertEquals(0, queue.size());

    }

    @Test(expected = EmptyQueueException.class)
    public void testRelease_emptyList_emptyQueueException() {
        int[] source = {};
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);
        for (int i = 0; i < source.length; i++) {
            queue.add(i);
        }
        queue.release();
    }

    @Test
    public void testAddAndRelease_nonEmptyList_fullCapacity() {
        int[] source = {2, 4,5,8,9};
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);
        for (int i = 0; i < source.length; i++) {
            queue.add(i);
        }
        queue.release();
        queue.add(3);
        assertEquals(5, queue.size());

    }

    @Test
    public void testAddAndRelease_nonEmptyList_3Elements() {
        int[] source = {2, 4,5};
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);
        for (int i = 0; i < source.length; i++) {
            queue.add(i);
        }
        queue.release();
        queue.add(3);
        assertEquals(3, queue.size());

    }

    @Test
    public void testAddAndRelease_nonEmptyList_1Element() {
        int[] source = {2};
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);
        for (int i = 0; i < source.length; i++) {
            queue.add(i);
        }
        queue.release();
        queue.add(3);
        assertEquals(1, queue.size());

    }


}