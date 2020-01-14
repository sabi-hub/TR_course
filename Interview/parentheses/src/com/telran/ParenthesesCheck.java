package com.telran;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class ParenthesesCheck<E> {


    public int reviseOfParentheses(String text) {

        Deque<Character> stack = new ArrayDeque<>();

        int code = 0;
        int fail = 0;
        for (int i = 0; i < text.length(); i++) {
            char bracket = text.charAt(i);
            if (bracket == ')' || bracket == '}' || bracket == ']'
                    && stack.size() == 0) {
                fail = 1;
                break;
            }

            if (bracket == '(' || bracket == '[' || bracket == '{') {
                stack.addLast(bracket);
                code++;
            } else if (bracket == ')' && stack.getLast() == '(') {
                stack.removeLast();
                code--;
            } else if (bracket == ']' && stack.getLast() == '[') {
                stack.removeLast();
                code--;
            } else if (bracket == '}' && stack.getLast() == '{') {
                stack.removeLast();
                code--;
            }
        }


        if (code > 0)
            fail = 1;
        return fail;
    }
}