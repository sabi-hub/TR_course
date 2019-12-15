package com.telran;

public class Censor {
    String[] vocab;

    public Censor(String[] vocab) {
        this.vocab = vocab;
    }

    public boolean isLegal(String text) {

        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < vocab.length; j++) {
                if (text.toLowerCase().substring(i).indexOf(vocab[j].toLowerCase()) == 0) {
                    return false;
                }
            }

        }
        return true;
    }
}
