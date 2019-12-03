package com.telran.collection;

import java.util.Arrays;

public class SortedNumbersList {

    private int[] source;

    public SortedNumbersList(){
        this.source=new int[0];
    }

    public SortedNumbersList(int[]source){
        this.source = ArrayUtils.copyArray(source);
        ArrayUtils.selectionSort(this.source);
    }


    public void add(int value){
        this.source= ArrayUtils.append(this.source, value);
        ArrayUtils.selectionSort(this.source);
    }

    public int get (int index){
        return this.source[index];
    }

    public int size() {
        return this.source.length;
    }

    public boolean contains(int number){
        int index = ArrayUtils.binarySearch(this.source,number);
        return index>=0;
    }

    /**
     * removes element by index
     * @param index of the element to remove
     * @return removed element
     */
    public int removeById(int index){
        int[] newSource = new int[this.source.length - 1];

        for (int i = 0; i < index; i++) {
            newSource[i] = this.source[i];
        }
        for (int i = index + 1; i < this.source.length; i++) {
            newSource[i - 1] = this.source[i];
        }
        int res = this.source[index];

        this.source = newSource;
        return res;
    }

    public boolean remove(int element){
        int index=ArrayUtils.binarySearch(this.source,element);
        if(index>=0){
            this.removeById(index);
            return true;
        }
        return false;
    }

    public void removeRepeated(){
        //для пустого метода, если ноль, то окончание программы - возврат 0
        if(this.source.length==0)
            return;

        int unique = 1;
        for (int i = 1; i < this.source.length; i++) {
            if (this.source[i] != this.source[i - 1]) {
                unique++;
            }
        }
        int[] result = new int[unique];

        result[0] = this.source[0];

        for (int i = 0; i < this.source.length; i++) {
            if (result.length > 0) {
                result[0] = this.source[0];
            }
        }
        int indexResult = 1;
        for (int i = 1; i < this.source.length; i++) {
            if (this.source[i] != this.source[i - 1]) {
                result[indexResult++] = this.source[i];
            }
        }
        this.source = result;
    }

//    public SortedNumbersList intersection (SortedNumbersList another){
//        int intersection = 0;
//
//        for (int i = 0; i < this.source.length; i++) {
//            for (int j = 0; j < another.source.length; j++) {
//                if (this.source[i] == another.source[j])
//                    intersection++;
//            }
//        }
//        int[] result = new int[intersection];
//
//        int index=0;
//        for (int i = 0; i < this.source.length; i++) {
//            for (int j = 0; j < another.source.length; j++) {
//                if (this.source[i] == another.source[j]) {
//                    result[index++]=this.source[i];
//                }
//            }
//        }
//        SortedNumbersList resultList = new SortedNumbersList(result);
//        resultList.removeRepeated();
//        return resultList;
//    }

    public SortedNumbersList intersection(SortedNumbersList another){
        int newSize = 0;
        for (int i = 0; i <source.length ; i++) {
            if(another.contains(source[i]))
                newSize++;
        }
        int[]newSource = new int[newSize];
        int index=0;
        for (int i = 0; i <source.length ; i++) {
            if(another.contains(source[i]))
                newSource[index++]=source[i];
        }
        SortedNumbersList intersection = new SortedNumbersList(newSource);
        intersection.removeRepeated();
        return intersection;
    }

    public SortedNumbersList union (SortedNumbersList another){
        int[]newSource = new int[this.source.length+another.source.length];

        for (int i = 0; i <this.source.length ; i++) {
            newSource[i]=this.source[i];
        }
        for (int i = 0; i < another.source.length; i++) {
            newSource[i+source.length] = another.source[i];
        }
        SortedNumbersList newList = new SortedNumbersList(newSource);
        newList.removeRepeated();
        return newList;
    }

    public String toString() {
        return Arrays.toString(this.source);
    }
}
