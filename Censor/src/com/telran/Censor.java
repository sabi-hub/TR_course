package com.telran;

import java.util.Arrays;

public class Censor {
    private String[] vocab;

    public Censor(String[] vocab) {
//        this.vocab = vocab;
        this.vocab = Arrays.copyOf(vocab, vocab.length); //
    }

    public boolean isLegal(String text) {
        text= text.toLowerCase();

        for (String words: vocab) {
            if(text.contains(words.toLowerCase()))
                return false;

        }

//        for (int i = 0; i < text.length(); i++) {
//            for (int j = 0; j < vocab.length; j++) {
////                if (text.toLowerCase().substring(i).indexOf(vocab[j].toLowerCase()) == 0) {
////                    return false;
////                }
//                if (text.toLowerCase().contains(vocab[j].toLowerCase())) {
//                    return true;
//                }
//            }
//        }
        return true;
    }
}
