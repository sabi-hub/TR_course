package com.telran;

public class Main {

    public static void main(String[] args) {
        // write your code here

        System.out.println(fib(6));

        int[] array ={1,2,3,4,5,6,7,8};
        System.out.println(sumNumbersBeforeN(array,7));

    }

    public static int fib(int n) {
        int number1 =0;
        int number2 = 1;
        for (int i = 2; i <= n; i++) {
            int nextnumber = number1 + number2;
            number1 = number2;
            number2 = nextnumber;
        }
        return number2;
    }

    public static int sumNumbersBeforeN (int[] array, int N){
        int sum=0;
        for (int i = 0; i <array.length ; i++) {
            int number = array[i];
            if (number%2!=0&&number<=N){
                sum+=number;
                number++;
            }
        }
        return sum;
    }

}
