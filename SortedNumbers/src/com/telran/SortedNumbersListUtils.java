package com.telran;

public class SortedNumbersListUtils {

    public static int[] copyArray(int[] array) {
        int[] resArray = new int[array.length];
        for (int i = 0; i < resArray.length; i++) {
            resArray[i] = array[i];
        }
        return resArray;
    }

    public static int[] append(int[] array, int value) {
//        int[] resArray = new int[array.length + 1];
//        for (int i = 0; i < array.length; i++) {
//            resArray[i]=array[i];
//        }
//        resArray[array.length]=value;// вместое resArray.length-1
//        System.out.println("New Array with addition value " + Arrays.toString(resArray));
//        return resArray;

        int[] result = insertLesson(array, array.length, value);

        return result;
    }

//    public static int[] insert(int[] array, int index, int value) {
//        int[] resArray = new int[array.length + 1];
//        int[] boof = new int[resArray.length];
//        for (int i = 0; i < array.length; i++) {
//            resArray[i] = array[i];
//        }
//        for (int i = 0; i < resArray.length; i++) {
//            boof[i] = resArray[i];
//        }
//        resArray[index] = value;
//        for (int i = index + 1; i < resArray.length; i++) {
//            resArray[i] = boof[i - 1];
//        }
//        return resArray;
//    }

    public static int[] insertLesson(int[] array, int index, int number) {
        int[] result = new int[array.length + 1];

        for (int i = 0; i < index; i++) {
            result[i] = array[i];
        }
        result[index] = number;

        for (int i = index + 1; i < result.length; i++) {
            result[i] = array[i - 1];

        }
        return result;
    }

    public static int[] removeById(int[] array, int index) {
        int[] result = new int[array.length - 1];
        for (int i = 0; i < index; i++) {
            result[i] = array[i];
        }
        for (int i = index + 1; i < array.length; i++) {
            result[i - 1] = array[i];
        }
        return result;
    }

    public static int[] removeRepeated(int[] array){
//        selectionSort(array);
        int unique=1;
        for (int i = 1; i <array.length; i++) {
            if(array[i]!=array[i-1]){
                unique++;
            }
        }
        int []result = new int[unique];

        for (int i = 0; i <array.length ; i++) {
            if(result.length>0) {
                result[0] = array[0];
            }
        }
        int indexResult=1;
        for (int i = 1; i <array.length ; i++) {
            if(array[i]!=array[i-1]) {
                result[indexResult] = array[i];
                indexResult++;
            }
        }
        return result;
    }

    private static void remove(int[] array, int element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                removeById(array,i);

            }
        }
    }

    public static int[] intersection(int[] array, int[] another){
        int intersection=0;

        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < another.length; j++) {
                if(array[i]== another[i])
                    intersection++;
            }
        }
        int[] result = new int[intersection];
        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < another.length; j++) {
                if(array[i]== another[j])
                    result[i]= array[i];
            }
        }
        return result;
    }

    public static int[] union(int[] array, int[] another){

        int[] result = new int[(array.length+another.length)];
        int index=0;
        for (int i = 0; i < array.length ; i++) {
            result[i]=array[i];
            index++;

        }
        for (int j = 0; j <another.length ; j++) {
            result[index++]=another[j];
        }

        removeRepeated(result);
        return result;
    }


    public static int binarySearch(int[] array, int number) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (array[middle] < number) {
                left = middle + 1;
            } else if (array[middle] > number) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return -(left + 1);
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) { //увеличивает отсортированный кусок на 1 элемент
            int minId = i;
            for (int j = i; j < array.length; j++) {//находит элемент из оставшегося куска на который надо увеличить в первом цикле
                if (array[minId] > array[j]) {
                    minId = j;
                }
            }
            int temp = array[i];
            array[i] = array[minId];
            array[minId] = temp;
        }
    }

}
