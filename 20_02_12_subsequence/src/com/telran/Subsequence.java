package com.telran;

public class Subsequence {

    public boolean subsequence(String text, String pattern) {

        int textSize = text.length();
        int patternSize = pattern.length();

        if (patternSize == 0)
            return true;

        while (textSize > 0) {
            if (text.charAt(textSize - 1) == pattern.charAt(patternSize - 1)) {
                textSize--;
                patternSize--;
                return subsequence(text.substring(0, textSize), pattern.substring(0, patternSize));
            } else {
                textSize--;
                return subsequence(text.substring(0, textSize), pattern);
            }
        }
        return false;
    }
}
