package com.telran;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairsOfNumbers {

    public int getNumberWithoutPair(List<Integer> numbers) {

        Map<Integer, Integer> pairsOfNumbers = new HashMap<>();
        int counter = 1;
        for (int num : numbers) {
            if (pairsOfNumbers.containsKey(num)) {
                int val = pairsOfNumbers.get(num);
                val++;
                pairsOfNumbers.put(num, val);
            } else {
                pairsOfNumbers.put(num, counter);
            }

        }
        int res = 0;
        for (int num : pairsOfNumbers.keySet()) {
            if ((pairsOfNumbers.get(num) % 2)>0)
                res=num;
        }

        return res;
    }
}
