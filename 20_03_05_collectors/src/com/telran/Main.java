package com.telran;

import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) {

        //Написать коллектор, который считает сумму квадратов из стрима
        List<Integer> integers = Arrays.asList(2, 3);
        Integer res = integers.stream()
                .collect(Collectors.summingInt(num -> num * num));
        System.out.println(res);

        //Написать коллектор, который будет разделять Stream<String> на палиндромы и все остальное
        List<String> text = Arrays.asList("mama", "lol", "pop", "world");
        Map<Boolean, List<String>> res2 = text.stream()
                .collect(Collectors
                        .partitioningBy(word -> IntStream.range(0, word.length() / 2)
                                .noneMatch(i -> word.charAt(i) != word.charAt(word.length() - i - 1))));

        System.out.println(res2);

        //Посчитать сумму транзакций для каждого аккаунта
        Transaction tr1 = new Transaction("dfn34", 3500, 11);
        Transaction tr2 = new Transaction("ddfg34", 2500, 22);
        Transaction tr3 = new Transaction("dfwe34", 1000, 11);
        Transaction tr4 = new Transaction("dfaf4", 700, 11);
        Transaction tr5 = new Transaction("dqw34", 300, 22);

        Stream<Transaction> transactionStream = Stream.of(tr1, tr2, tr3, tr4, tr5);

        Map<Integer, Long> res3 = transactionStream.collect(Collectors
                .groupingBy(Transaction::getAccId, Collectors
                        .summingLong(Transaction::getSum)));

        System.out.println(res3);
    }

}
