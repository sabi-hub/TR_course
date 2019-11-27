package com.telran;

import java.util.Arrays;

public class ArrayUtils {

    public static int[] copyArray(int[] array) {
        int[] resArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            resArray[i] = array[i];
        }
        System.out.println("New Array " + Arrays.toString(resArray));
        return resArray;
    }

    public static int[] append(int[] array, int value) {
        int[] resArray = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            resArray[i]=array[i];
            resArray[resArray.length-1]=value;

        }
        System.out.println("New Array with addition value " + Arrays.toString(resArray));
        return resArray;
    }

    public static int[] insert (int[] array, int index, int value){
        int[] resArray = new int[array.length + 1];
        int[] boof = new int[resArray.length];
        for (int i =0 ; i <array.length ; i++) {
            resArray[i]=array[i];
        }
        for (int i = 0; i <resArray.length ; i++) {
            boof[i]=resArray[i];
        }
        resArray[index]=value;
        for (int i = index+1; i <resArray.length ; i++) {
            resArray[i]=boof[i-1];
        }
        System.out.println("New Array with addition value in the center" + Arrays.toString(resArray));
        return resArray;
    }
}
