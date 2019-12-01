package com.telran;

import java.util.Arrays;

public class SortedNumbersList {

    int[] source;
    int[] another;

    public SortedNumbersList(){
        this.source=new int[0];
    }

    public SortedNumbersList(int[]source){
        this.source = SortedNumbersListUtils.copyArray(source);
        SortedNumbersListUtils.selectionSort(this.source);
    }




    public void add(int value){
        this.source=SortedNumbersListUtils.append(this.source, value);
        SortedNumbersListUtils.selectionSort(this.source);
    }

    public int get (int index){
        return this.source[index];
    }

    public int size() {
        return this.source.length;
    }

    public void removeById(int index){
        this.source=SortedNumbersListUtils.removeById(this.source, index);
    }

    public boolean remove(int element){
        for (int i = 0; i < this.source.length; i++) {
            if (this.source[i] == element) {
                this.removeById(i);
                return true;
            }
        }
        SortedNumbersListUtils.selectionSort(this.source);
        return false;
    }

    public void removeRepeated(SortedNumbersList source){
        this.source=SortedNumbersListUtils.removeRepeated(this.source);

    }

//    public SortedNumbersList intersection (SortedNumbersList another){
//       // this.source=SortedNumbersListUtils.intersection(this.source, another);
//
//        SortedNumbersList result = SortedNumbersListUtils.intersection(this.source, this.another);
//        return result;
//    }
////
//    public SortedNumbersList union (SortedNumbersList another){
//
//    }

    public String toString() {
        return Arrays.toString(this.source);
    }
}
