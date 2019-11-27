package com.telran;

public class Application {

    public static void main(String[] args) {

        int[][] array = new int[][]{{1, 2, 3}, {-2, -3, -1}, {2, -3, 1}, {1, -5}, {1,3,-1,2}};
        System.out.println(countArraysPositivElements(array));
        System.out.println(countArraysOnlyPositivElements(array));

        int[][] array10 = new int[10][10];
        System.out.println(fillArray0To99(array10));
        System.out.println(fillArray99To0(array10));

        int[][] chess = new int[8][8];
        System.out.println(chessArray(chess));
    }

    //Функция, которая считает количество подмассивов, в которых хотя бы 1 положительное число.
    public static int countArraysPositivElements(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] >= 0) {
                    sum++;
                    break;
                }
            }
        }
        return sum;
    }

    //Функция, которая считает подмассивы, в которых все эелементы - положительные числа
    public static boolean allPositiv(int[] array){
        int count=0;
        for (int i = 0; i < array.length; i++) {
            if(array[i]>0)
                count++;
        }
        if (count==array.length)
            return true;
        return false;
    }

    public static int countArraysOnlyPositivElements(int[][] array) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            if(allPositiv(array[i])){
                sum++;
            }
        }
        return sum;
    }


    //Заполнить 2мерный массив 0-99
    public static int[][] fillArray0To99(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = j;
                if (i > 0 && i < array.length) {
                    array[i][j] += 10 * i;
                }
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        return array;
    }

    //заполнить 2мерный массив 99-0
    public static int[][] fillArray99To0(int[][] array) {
        for (int i = array.length-1; i >=0; i--) {
            for (int j = array.length-1; j >=0; j--) {
                array[i][j] = j;
                if (i > 0 && i < array.length) {
                    array[i][j] += 10 * i;
                }
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        return array;
    }

    //заполнить 2мерный массив в шахматном порядке
    public static int[][] chessArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if ((i + j) % 2 == 0)
                    array[i][j] = 0;
                else
                    array[i][j] = 1;
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        return array;
    }
}
