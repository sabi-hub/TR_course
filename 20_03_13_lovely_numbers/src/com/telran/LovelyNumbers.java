package com.telran;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LovelyNumbers {

    public boolean isLovely(int number) {
        String[] arrNumbers = Integer.toString(number).split("");
        
        ArrayList<Integer> numbersOfNumber = new ArrayList<>();
        for (int i = 0; i < arrNumbers.length; i++) {
            numbersOfNumber.add(Integer.valueOf(arrNumbers[i]));
        }

        boolean result = true;
        Set<Integer> uniqueSet = new HashSet<>(numbersOfNumber);
        for (Integer temp : uniqueSet) {
            int countNumber = Collections.frequency(numbersOfNumber, temp);
            if (countNumber > 2) {
                result = false;
            }
        }
        return result;

    }

    public List<Integer> getLovelyNumbers(int a, int b){
        return IntStream.rangeClosed(a,b)
                .filter(this::isLovely)
                .boxed()
                .collect(Collectors.toList());

    }

}
