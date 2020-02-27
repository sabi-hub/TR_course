package com.telran;

import jdk.dynalink.Operation;

import java.util.*;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        //Task1 = List without doubles
        List<String> text = new ArrayList<>(Arrays.asList("hello", "world","hello" ));
        List<String> res = new ArrayList<>();

        Function <Collection, Collection> noRepeating = (Collection lines) ->{
            for (int i = 0; i <text.size(); i++) {
                if(!(res.contains(text.get(i))))
                    res.add(text.get(i));
            }
            return res;

        };
        System.out.println(noRepeating.apply(text));

        //Task2 Quadratic
        int a = 3;
        int b = 2;
        int c = 3;
        Function <Integer, Integer> quadratic = (x)->a*(x*x)+b*x+c;

        System.out.println(quadratic.apply(3));

    }
}
