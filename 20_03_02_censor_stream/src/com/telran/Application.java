package com.telran;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        // write your code here

        List<String> dictionary = Arrays.asList("pam", "vam");
        List<String> text = Arrays.asList("I go to pam school");
        List<String> text2 = Arrays.asList("I was at vam school pam vam the breakfast was pam pam");

        List<String> stream = getBadWords(text, dictionary);
        List<String> stream2 = getBadWords(text2, dictionary);
        System.out.println(stream);
        System.out.println(stream2);
    }

    public static List<String> getBadWords(List<String> text, List<String> dict) {
        return text.stream()
                .map(word -> word.split(" "))
                .flatMap(Arrays::stream)
                .sorted()
                .distinct()
                        .filter(badword -> dict.stream()
                        .anyMatch(word -> word.equals(badword)))
                .collect(Collectors.toList());
    }
}