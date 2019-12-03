package com.telran;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
	int[] javaArray = new int[]{1,3,-8,6};

	Array ourArray = new Array(javaArray);

//        for (int i = 0; i <javaArray.length; i++) {
//            System.out.println(ourArray.get(i));
//        }

//        System.out.println(ourArray.get(0));//1
//        System.out.println(ourArray.get(1));//3
//        System.out.println(ourArray.get(2));//-8
//
//        System.out.println(ourArray.size());//3
//        System.out.println(ourArray.toString());
//
//        ourArray.insert(1,5);
//        System.out.println(ourArray.toString());
//
//        ourArray.set(1,9);
//        System.out.println(ourArray.toString());

//        ourArray.removeById(1);
//        System.out.println(ourArray.toString());

        ourArray.remove(-8);
        System.out.println(ourArray.toString());

//	int a1 = javaArray[0];//1
//    int a2 = ourArray.get(0);//1

//        System.out.println(ArrayUtils.copyArray(javaArray));
//        System.out.println(ArrayUtils.append(javaArray,5));
//       System.out.println(ArrayUtils.removeById(javaArray, 1));
//        System.out.println(ArrayUtils.insertLesson(javaArray, 2,5));
//
//        ArrayUtils.selectionSort(javaArray);
//        System.out.println(Arrays.toString(javaArray));

//        ArrayUtils.remove(javaArray, -8);
//        System.out.println("a "+Arrays.toString(javaArray));

    }

}
