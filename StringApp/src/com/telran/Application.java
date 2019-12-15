package com.telran;

public class Application {

    public static void main(String[] args) {

        String str = "Hello World";
        System.out.println(reverse(str));

        String text = "Hello, hello, hello";
        String pattern = "o";

        System.out.println(countIndexOf(pattern,text));

    }

    public static String reverse(String str) {
        char[] chars = str.toCharArray();
        int length = chars.length;

        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[length - 1 - i];
            chars[length - 1 - i] = temp;
        }

        return new String(chars);
    }

    public static int countIndexOf(String pattern, String text) {
        int count =0;

        for (int i = 0; i < text.length(); i++) {

            if (text.toLowerCase().substring(i).indexOf(pattern.toLowerCase())==0) {
                count++;
                text.substring(i+1);
            }
        }

        return count;
    }


}


