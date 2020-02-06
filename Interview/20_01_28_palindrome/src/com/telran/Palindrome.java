package com.telran;

import java.util.ArrayDeque;

public class Palindrome<E> {

    public boolean palindromeFounder(String str) {
        String withoutCaseStr = str.toLowerCase();
        StringBuilder plainString = new StringBuilder(withoutCaseStr);
        StringBuilder reverseString = plainString.reverse();

        if((reverseString.toString()).equals(withoutCaseStr)){
            return true;
        }
        return false;
    }
}
