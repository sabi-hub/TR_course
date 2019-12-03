package com.telran.collection;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortedNumbersListTest {

    @Test
    public void testSize_nonEmptyObject_3elements() {
        int[] source = {1, 2, 3};
        SortedNumbersList ourArray = new SortedNumbersList(source);
        assertEquals(source.length, ourArray.size());
    }

    @Test
    public void testSize_EmptyObject_0elements() {
        SortedNumbersList ourArray = new SortedNumbersList();
        assertEquals(0, ourArray.size());
    }

//    Тесты ниже не обязательны. Лучше тестировать size  в других методах
//    @Test
//    public  void testSize_EmptyObject_sizeIncreasedBy1(){
//        SortedNumbersList list = new SortedNumbersList();
//        list.add(5);
//        assertEquals(1,list.size());
//    }
//
//    @Test
//    public  void testSize_nonEmptyObject_sizeIncreasedBy1(){
//        int[]source = {1,2,3};
//        SortedNumbersList list = new SortedNumbersList(source);
//        list.add(5);
//        assertEquals(source.length+1,list.size());
//    }
//
//    @Test
//    public  void testSize_nonEmptyObjectRemovesElement_sizeDecreasedBy1(){
//        int[]source = {1,2,3};
//        SortedNumbersList list = new SortedNumbersList(source);
//        list.removeById(0);
//        assertEquals(source.length-1,list.size());
//    }


//    @Test
//    public  void testGet_EmptyObject_0elements(){
//        SortedNumbersList ourArray = new SortedNumbersList();
//        assertEquals(0,ourArray.get(0));
//    }

    @Test
    public void testGet_nonEmptyObjectFromSorted_getsAllElements() {
        int[] source = {1, 2, 5, 7};
        SortedNumbersList list = new SortedNumbersList(source);
        for (int i = 0; i < source.length; i++) {
            assertEquals(source[i], list.get(i));
        }
    }

    @Test
    public void testGet_nonEmptyObjectFromNonSorted_getsAllElements() {
        int[] source = {1, 2, -6, 0, 5, 3};
        SortedNumbersList list = new SortedNumbersList(source);
        int[] expected = {-6, 0, 1, 2, 3, 5};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }
    }

    @Test //проверка сразу на добавление элементов, изменение размера и на добавление дублей.
    public void testAdd_nonEmptyObject_atTheMiddle() {
        int[] source = {1, 2, 5, 7};
        SortedNumbersList list = new SortedNumbersList(source);
        list.add(4);
        list.add(2);
        int[] expected = {1, 2, 2, 4, 5, 7};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }
        assertEquals(6, list.size());
    }

    @Test
    public void testAdd_EmptyObject_AddsElementsToTheMiddle() {
        SortedNumbersList list = new SortedNumbersList();
        list.add(2);
        int[] expected = {2};

        assertEquals(2, list.get(0));
        assertEquals(1, list.size());
    }

    @Test
    public void testAdd_nonEmptyObject_atTheEnd() {
        int[] source = {1, 2, 5, 7};
        SortedNumbersList list = new SortedNumbersList(source);
        list.add(7);
        list.add(8);
        int[] expected = {1, 2, 5, 7, 7, 8};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }
        assertEquals(6, list.size());
    }

    @Test
    public void testAdd_nonEmptyObject_atTheBeginning() {
        int[] source = {1, 2, 5, 7};
        SortedNumbersList list = new SortedNumbersList(source);
        list.add(1);
        list.add(-6);
        int[] expected = {-6, 1, 1, 2, 5, 7};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }
        assertEquals(6, list.size());
    }

    @Test
    public void testRemoveById_nonEmptyObject_removesAtTheBeginning() {
        int[] source = {1, 2, 5, 7};
        SortedNumbersList list = new SortedNumbersList(source);
        assertEquals(1, list.removeById(0));
        int[] expected = {2, 5, 7};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }
        assertEquals(3, list.size());
    }

    @Test
    public void testRemoveById_nonEmptyObject_removesFromEnd() {
        int[] source = {1, 2, 5, 7};
        SortedNumbersList list = new SortedNumbersList(source);
        assertEquals(7, list.removeById(3));
        int[] expected = {1, 2, 5};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }
        assertEquals(3, list.size());
    }

    @Test
    public void testRemoveById_nonEmptyObject_removesFromMiddle() {
        int[] source = {1, 2, 5, 7};
        SortedNumbersList list = new SortedNumbersList(source);
        assertEquals(5, list.removeById(2));
        int[] expected = {1, 2, 7};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }
        assertEquals(3, list.size());
    }


    @Test
    public void testRemove_nonEmptyObject_atTheBeginning() {
        SortedNumbersList ourArray = new SortedNumbersList(new int[]{2, -9, -10});
        ourArray.remove(-10);
        int[] expected = {-9, 2};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public void testRemove_nonEmptyObject_atTheMiddle() {
        SortedNumbersList ourArray = new SortedNumbersList(new int[]{2, -9, -10});
        ourArray.remove(-9);
        int[] expected = {-10, 2};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public void testRemove_nonEmptyObject_atTheEnd() {
        SortedNumbersList ourArray = new SortedNumbersList(new int[]{4, -9, -10});
        ourArray.remove(4);
        int[] expected = {-10, -9};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public void testRemove_nonEmptyObject_booleanTrueFalse() {
        SortedNumbersList ourArray = new SortedNumbersList(new int[]{4, -9, -10});
        assertTrue(ourArray.remove(4));
        assertFalse(ourArray.remove(3));
    }

    @Test
    public void testRemoveRepeated_nonEmptyObject_RemovesDoublesFromBeginning() {
        int[] source = {1, 1, 2, 3, 4};
        SortedNumbersList list = new SortedNumbersList(source);
        list.removeRepeated();
        int[] expected = {1, 2, 3, 4};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }
        assertEquals(4, list.size());
        assertTrue(list.get(1) != 1);
    }

    @Test
    public void testRemoveRepeated_nonEmptyObject_RemovesDoublesFromMiddle() {
        int[] source = {1, 2, 2, 3, 4};
        SortedNumbersList list = new SortedNumbersList(source);
        list.removeRepeated();
        int[] expected = {1, 2, 3, 4};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }
        assertEquals(4, list.size());
        assertTrue(list.get(2) != 2);
    }

    @Test
    public void testRemoveRepeated_nonEmptyObject_RemovesDoublesFromEnd() {
        int[] source = {1, 2, 3, 4,4};
        SortedNumbersList list = new SortedNumbersList(source);
        list.removeRepeated();
        int[] expected = {1, 2, 3, 4};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }
        assertEquals(4, list.size());
    }

    @Test
    public void testRemoveRepeated_nonEmptyObject_RemovesTripletFromBeginning() {
        int[] source = {1, 1,1, 2, 3, 4};
        SortedNumbersList list = new SortedNumbersList(source);
        list.removeRepeated();
        int[] expected = {1, 2, 3, 4};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }
        assertEquals(4, list.size());
        assertTrue(list.get(1) != 1);
    }

    @Test
    public void testRemoveRepeated_nonEmptyObject_RemovesTripletFromMiddle() {
        int[] source = {1, 2, 2,2,3, 3, 4};
        SortedNumbersList list = new SortedNumbersList(source);
        list.removeRepeated();
        int[] expected = {1, 2, 3, 4};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }
        assertEquals(4, list.size());
        assertTrue(list.get(2) != 2);
    }

    @Test
    public void testRemoveRepeated_nonEmptyObject_RemovesTripletFromEnd() {
        int[] source = {1, 2, 3, 4,4,4};
        SortedNumbersList list = new SortedNumbersList(source);
        list.removeRepeated();
        int[] expected = {1, 2, 3, 4};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }
        assertEquals(4, list.size());
    }

//    @Test
//    public void testIntersection_nonEmptyObject_twoArraysSameLengthRemovesDoubles(){
//        SortedNumbersList sourceArray = new SortedNumbersList(new int[]{1,2,3,3,4});
//        SortedNumbersList anotherArray = new SortedNumbersList(new int[]{3,4,4,5,6});
//        SortedNumbersList expected=sourceArray.intersection(anotherArray);
//        assertEquals(2,expected.size());
//        assertEquals(3,expected.get(0));
//        assertEquals(4,expected.get(1));
//
//    }

//    @Test
//    public void testIntersection_nonEmptyObject_twoArraysDifferentLengthRemovesDoubles(){
//        SortedNumbersList sourceArray = new SortedNumbersList(new int[]{1,2,3,4});
//        SortedNumbersList anotherArray = new SortedNumbersList(new int[]{3,3,4,5,6,7});
//        SortedNumbersList expected=sourceArray.intersection(anotherArray);
//        assertEquals(2,expected.size());
//        assertEquals(3,expected.get(0));
//        assertEquals(4,expected.get(1));
//    }
//    @Test
//    public void testIntersection_nonEmptyObject_twoArrays0LengthRemovesDoubles(){
//        SortedNumbersList sourceArray = new SortedNumbersList(new int[]{1,2});
//        SortedNumbersList anotherArray = new SortedNumbersList(new int[]{3,3,4,5,6,7});
//        SortedNumbersList expected=sourceArray.intersection(anotherArray);
//        assertEquals(0,expected.size());
////        assertEquals(3,expected.get(0));
////        assertEquals(4,expected.get(1));
//    }

    @Test
    public void testContains_nonEmptyArray_containsFirstMiddleLastElements(){
        int[]source = {1,2,5,7};
        SortedNumbersList list = new SortedNumbersList(source);

        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertTrue(list.contains(5));
        assertTrue(list.contains(7));
    }

    @Test
    public void testContains_nonEmptyArray_notContainsFirstMiddleLastElements(){
        int[]source = {1,2,5,7};
        SortedNumbersList list = new SortedNumbersList(source);

        assertFalse(list.contains(-1));
        assertFalse(list.contains(6));
        assertFalse(list.contains(3));
        assertFalse(list.contains(8));
    }

    @Test
    public void testUnion_nonEmptyObject_twoArraysSameLength(){
        SortedNumbersList list = new SortedNumbersList(new int[]{1,2,3,4});
        SortedNumbersList anotherlist = new SortedNumbersList(new int[]{3,4,5,6});
        SortedNumbersList expected=list.union(anotherlist);
        assertEquals(6,expected.size());
        assertEquals(1,expected.get(0));
        assertEquals(3,expected.get(2));
        assertEquals(6,expected.get(5));

    }

    @Test
    public void testUnion_nonEmptyObject_noIntersections(){
        int[]list = {1,2,3,5,6,7};
        SortedNumbersList sourceArray = new SortedNumbersList(list);
        SortedNumbersList anotherArray = new SortedNumbersList(new int[]{5,6,7});
        SortedNumbersList union = sourceArray.union(anotherArray);
        int[]expected = {1,2,3,5,6,7};
        for (int i = 0; i <list.length ; i++) {
            assertEquals(expected[i],union.get(i));
        }
        assertEquals(6, union.size());
    }

//    @Test
//    public void testUnion_emptyListAndEmptyList_yieldsEmptyList(){
//        SortedNumbersList list = new SortedNumbersList();
//        SortedNumbersList anotherList = new SortedNumbersList();
//
//        assertEquals(0,list.union(anotherList).size());
//    }

    @Test
    public void testUnion_emptyListAndNonEmptyList_yieldsSecondEmptyList(){
        SortedNumbersList list = new SortedNumbersList();

        int[]source = new int []{1,3,4,7};
        SortedNumbersList anotherList = new SortedNumbersList(source);
        SortedNumbersList union = list.union(anotherList);

        for (int i = 0; i <source.length; i++) {
            assertEquals(source[i],union.get(i));
        }
        assertEquals(4,union.size());
    }

    @Test
    public void testUnion_nonEmptyListAndEmptyList_yieldsFirstEmptyList(){
        int[]source = new int []{1,3,4,7};
        SortedNumbersList list = new SortedNumbersList(source);
        SortedNumbersList anotherList = new SortedNumbersList();
        SortedNumbersList union = list.union(anotherList);

        for (int i = 0; i <source.length; i++) {
            assertEquals(source[i],union.get(i));
        }
        assertEquals(4,union.size());
    }

    @Test
    public void testIntersection_twoNonEmptyObject_Intersections(){
        int[]source = new int[]{1,2,3};
        SortedNumbersList list = new SortedNumbersList(source);

        int[]source2 = new int[]{2,5,1,8};
        SortedNumbersList anotherArray = new SortedNumbersList(source2);
        SortedNumbersList intersection = list.intersection(anotherArray);

        assertEquals(1, intersection.get(0));
        assertEquals(2, intersection.get(1));
        assertEquals(2, intersection.size());
    }

    @Test
    public void testIntersection_twoNonEmptyObjectWithRepetitions_Intersections(){
        int[]source = new int[]{1,2,2,3};
        SortedNumbersList list = new SortedNumbersList(source);

        int[]source2 = new int[]{2,5,1,1,8};
        SortedNumbersList anotherArray = new SortedNumbersList(source2);
        SortedNumbersList intersection = list.intersection(anotherArray);

        assertEquals(1, intersection.get(0));
        assertEquals(2, intersection.get(1));
        assertEquals(2, intersection.size());
    }

    @Test
    public void testIntersection_twoNonEmptyObjectWithRepetitions_noIntersections(){
        int[]source = new int[]{1,2,3};
        SortedNumbersList list = new SortedNumbersList(source);

        int[]source2 = new int[]{4,5,6};
        SortedNumbersList anotherArray = new SortedNumbersList(source2);
        SortedNumbersList intersection = list.intersection(anotherArray);

        assertEquals(0, intersection.size());
    }

    @Test
    public void testIntersection_firstEmptyObjectSecondNonEmpty_noIntersections(){
        int[]source = new int[]{};
        SortedNumbersList list = new SortedNumbersList(source);

        int[]source2 = new int[]{2,5,1,8};
        SortedNumbersList anotherArray = new SortedNumbersList(source2);
        SortedNumbersList intersection = list.intersection(anotherArray);

        assertEquals(0, intersection.size());
    }

    @Test
    public void testIntersection_firstNonEmptyObjectSecondEmpty_noIntersections(){
        int[]source = new int[]{1,2,3};
        SortedNumbersList list = new SortedNumbersList(source);

        int[]source2 = new int[]{};
        SortedNumbersList anotherArray = new SortedNumbersList(source2);
        SortedNumbersList intersection = list.intersection(anotherArray);

        assertEquals(0, intersection.size());
    }

    @Test
    public void testIntersection_allEmptyObjects_noIntersections(){
        int[]source = new int[]{};
        SortedNumbersList list = new SortedNumbersList(source);

        int[]source2 = new int[]{};
        SortedNumbersList anotherArray = new SortedNumbersList(source2);
        SortedNumbersList intersection = list.intersection(anotherArray);

        assertEquals(0, intersection.size());
    }

}