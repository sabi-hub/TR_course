package com.telran;

public class Main {

    public static void main(String[] args) {
	int[] javaArray = new int[]{1,3,-8};
	Array ourArray = new Array(new int[]{1,3,-8});

	int a1 = javaArray[0];//1
//    int a2 = ourArray.get(0);//1

        System.out.println(ArrayUtils.copyArray(javaArray));
        System.out.println(ArrayUtils.append(javaArray,5));
        System.out.println(ArrayUtils.insert(javaArray, 2,5));

    }

}
