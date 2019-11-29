package com.telran;

public class ArrayUtils {

    public static int[] copyArray(int[] array) {
        int[] resArray = new int[array.length];
        for (int i = 0; i < resArray.length; i++) {
            resArray[i] = array[i];
        }
        // System.out.println("New Array " + Arrays.toString(resArray));
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

        //System.out.println("New Array with addition value " + Arrays.toString(result));
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
//        //  System.out.println("New Array with addition value in the center" + Arrays.toString(resArray));
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
        //  System.out.println("New Array with addition value in the center" + Arrays.toString(result));
        return result;
    }

//    public static int[] removeById(int[] array, int index) {
//        int[] result = new int[array.length - 1];
//        for (int i = 0; i <= index; i++) {
//            result[i] = array[i];
//            result[index] = array[index + 1];
//        }
//
//        for (int i = index + 1; i < result.length; i++) {
//            result[i] = array[i + 1];
//        }
//        //System.out.println("New Array with addition value " + Arrays.toString(result));
//        return result;
//    }

//    public static boolean remove(int[] array, int number) {
////        int[] result = new int[array.length];
////        int[] result2 = new int[array.length - 1];
//        int index;
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] == number) {
//                index = i;
//
//                    removeById(array, index);
//
//            }
//            return true;
//        }
//        return false;
//    }


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
