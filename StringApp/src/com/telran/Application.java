package com.telran;

public class Application {

    public static void main(String[] args) {

        String str = "Hello World";
        System.out.println(reverse(str));

        String text = "Hello, hello, hello";
        String pattern = "o";

        System.out.println(entrances(pattern, text));

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

    public static int entrances(String pattern, String text) {
        pattern=pattern.toLowerCase();
        text = text.toLowerCase();
        int currentIndex = 0;
        int res = 0;

        while ((currentIndex=text.indexOf(pattern,currentIndex))>=0){
            currentIndex++;
            res++;
        }
        return res;

//        while (true) {
//            currentIndex= text.indexOf(pattern,currentIndex);
//            if (currentIndex>=0){
//                currentIndex++;
//                res++;
//            }
//            else
//                return res;
//        }

//        for (int i = 0; i <text.length() ; i++) {
//            if(text.substring(i).startsWith(pattern))
//                res++;
//        }

//        int count =0;
//
//        for (int i = 0; i < text.length(); i++) {
//
//            if (text.toLowerCase().substring(i).indexOf(pattern.toLowerCase())==0) {
//                count++;
//                text.substring(i+1);
//            }
//        }


    }


}


