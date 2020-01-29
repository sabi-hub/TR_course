package com.telran;

import java.util.ArrayDeque;

public class PalindromeQueue<E> {

    public boolean isPalindrome (String str){

        char[] charString = str.toLowerCase().toCharArray();
        ArrayDeque <Character> charQueue = new ArrayDeque();

        for(Character chars:charString){
            charQueue.add(chars);
        }

        while(charQueue.size()>1) {
            if (charQueue.getFirst().equals(charQueue.getLast())) {
                charQueue.removeFirst();
                charQueue.removeLast();
            }else{
                return false;
            }
        }

        return true;
    }
}
