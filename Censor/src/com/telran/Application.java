package com.telran;

public class Application {

    public static void main(String[] args) {
	String[]words = {"xxx", "yyy", "abc"};
	Censor vasya = new Censor(words);
	String text = "Wikipedia may contain content that some readers consider objectionable or offensive - even exceedingly so. " +
            "Attempting to ensure that articles and images will be acceptable to all readers xxx, or will adhere to general social " +
            "or religious norms, is incompatible with the purposes of an encyclopedia abc.";

        String text2 = "Wikipedia may contain content that some readers consider objectionable or offensive - even exceedingly so. " +
                "Attempting to ensure that articles and images will be acceptable to all readers, or will adhere to general social " +
                "or religious norms, is incompatible with the purposes of an encyclopedia.";

        System.out.println(vasya.isLegal(text));
        System.out.println(vasya.isLegal(text2));
    }
}
