package com.telran;

public class Main {

    public static void main(String[] args) {
        String text = "abcdeaab";
        String pattern = "acdaa";
//        System.out.println(pattern.substring(pattern.length()));

        Subsequence subsequence = new Subsequence();
        subsequence.subsequence(text,pattern);


//        System.out.println(subsequence);

    }

}
