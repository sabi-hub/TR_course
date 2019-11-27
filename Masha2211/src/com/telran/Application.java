package com.telran;

public class Application {

    public static void main(String[] args) {
	    countCredits(15);

    }

    public static int countCredits (int num){
        int sumOfCredits=0;
        for (int i = num; i >0 ; i--) {
            int number = i-1;
            int numOfCredit= num-number;

            if (numOfCredit%3==0  && numOfCredit%13!=0)
                System.out.println("Credit #"+numOfCredit+" issued by Masha");

            else if (numOfCredit%3==1  && numOfCredit%13!=0)
                System.out.println("Credit #"+numOfCredit+" issued by Petya");

            else if (numOfCredit%3==2  && numOfCredit%13!=0)
                System.out.println("Credit #"+numOfCredit+" issued by Vasya");

            if (numOfCredit%13!=0 )
                sumOfCredits++;

        }
        System.out.println("Total credits is "+sumOfCredits);
        return sumOfCredits;
    }
}
