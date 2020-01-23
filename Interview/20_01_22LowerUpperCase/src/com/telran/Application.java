package com.telran;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // write your code here
        String str = "Hel1lo!123";

        System.out.println(reverseCase(str));

    }

    public static String reverseCase(String str) {
        char[] charList = str.toCharArray();

        for (int i = 0; i <charList.length ; i++) {
            if(Character.isLowerCase(charList[i])){
                char temp = Character.toUpperCase(charList[i]);
                charList[i]=temp;
            }
            else if(Character.isUpperCase(charList[i])){
                char temp = Character.toLowerCase(charList[i]);
                charList[i]=temp;
            }
        }
        return new String(charList);
    }


}
