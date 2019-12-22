package com.telran;

import java.util.ArrayDeque;


public class ProductOfNumbers<E> {

    public boolean numbersFounder(int[] numbers, int n) {
        ArrayDeque<Integer> deque = new ArrayDeque<>(numbers.length);
        for (int i = 0; i <numbers.length ; i++) {
            deque.add(i);
        }
        while(deque.size()>1){
            if(deque.getFirst()*deque.getLast()<n)
                deque.removeFirst();
            else if (deque.getFirst()*deque.getLast()>n)
                deque.removeLast();
            else return true;
        }
        return false;
    }
}
