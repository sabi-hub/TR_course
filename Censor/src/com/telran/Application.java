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

//how works method clone()
        Human[]humans1 = {
                new Human("Vasya", 20),
                new Human("Petya", 30)
        };

        Human []humans2 = humans1.clone();
        humans1[0].name = "Vasiliy"; //changes name in originl and in clone array

        System.out.println(humans1[0]);
        System.out.println(humans2[0]);
        System.out.println();

        humans1[0] = new Human("Vasisualiy", 25); // changes only original array
        System.out.println(humans1[0]);
        System.out.println(humans2[0]);
    }
}

class Human{
    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String name;
    int age;

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}