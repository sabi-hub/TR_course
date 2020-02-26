package com.telran;

import java.util.function.BiFunction;

public class Main {

    public static void main(String[] args) {
        // write your code here
        BiFunction<Integer, Integer, Integer> productOfTwoNumbers = (Integer a, Integer b) -> a * b;
        BiFunction<Integer, Integer, Integer> productOfAllNumbers = (Integer a, Integer b)->
        {int res=a;
            for (int i = 1; i <= (b - a); i++) {
                res = res * (a + i);
            } return res;};

        System.out.println("productOfTwoNumbers " +productOfTwoNumbers.apply( 2, 5));
        System.out.println("productOfAllNumbers " +productOfAllNumbers.apply(2, 5));

    }
}
