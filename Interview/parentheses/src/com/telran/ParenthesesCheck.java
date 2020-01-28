package com.telran;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class ParenthesesCheck<E> {


    public boolean reviseOfParentheses(String text) {

        Deque<Character> stack = new ArrayDeque<>();
        stack.addLast('*');

        for (int i = 0; i < text.length(); i++) {
            char bracket = text.charAt(i);
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                stack.addLast(bracket);
            }

            if (bracket == ')' && stack.getLast() == '(') {
                stack.removeLast();

            } else if (bracket == ']' && stack.getLast() == '[') {
                stack.removeLast();

            } else if (bracket == '}' && stack.getLast() == '{') {
                stack.removeLast();

            }

            else if ((bracket == ')' || bracket == '}' || bracket == ']') && stack.size() ==1) {
                stack.addLast(bracket);

            }
        }


        if (stack.size() > 1) {
            return false;
        } else
            return true;
    }
}