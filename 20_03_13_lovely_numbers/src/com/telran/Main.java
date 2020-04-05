package com.telran;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        String arr[] = "1000".split("");
        System.out.println(arr.length);

        ArrayList<Integer> search = new ArrayList<Integer>();
        for(int i = 0; i < arr.length; i++){
            search.add(Integer.valueOf(arr[i]));
        }
        System.out.println(search);

        for(int number:search){
            Collections.frequency(search,number);
        }

        boolean result = true;
        Set<Integer> uniqueSet = new HashSet<>(search);
        for (Integer temp : uniqueSet) {
            int countNumber = Collections.frequency(search, temp);
            System.out.println(countNumber);
            if (countNumber > 2) {
                result = false;
            }
        }
        System.out.println(result);
        System.out.println(result);
        System.out.println(result);
    }
}
