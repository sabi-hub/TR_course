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

    @Test
    public void testIntersection_nonEmptyObject_twoArraysSameLengthRemovesDoubles(){
        SortedNumbersList sourceArray = new SortedNumbersList(new int[]{1,2,3,3,4});
        SortedNumbersList anotherArray = new SortedNumbersList(new int[]{3,4,4,5,6});
        SortedNumbersList expected=sourceArray.intersection(anotherArray);
        assertEquals(2,expected.size());
        assertEquals(3,expected.get(0));
        assertEquals(4,expected.get(1));

    }

    @Test
    public void testIntersection_nonEmptyObject_twoArraysDifferentLengthRemovesDoubles(){
        SortedNumbersList sourceArray = new SortedNumbersList(new int[]{1,2,3,4});
        SortedNumbersList anotherArray = new SortedNumbersList(new int[]{3,3,4,5,6,7});
        SortedNumbersList expected=sourceArray.intersection(anotherArray);
        assertEquals(2,expected.size());
        assertEquals(3,expected.get(0));
        assertEquals(4,expected.get(1));
    }

    @Test
    public void testUnion_nonEmptyObject_twoArraysSameLength(){
        SortedNumbersList sourceArray = new SortedNumbersList(new int[]{1,2,3,4});
        SortedNumbersList anotherArray = new SortedNumbersList(new int[]{3,4,5,6});
        SortedNumbersList expected=sourceArray.union(anotherArray);
        assertEquals(6,expected.size());
        assertEquals(1,expected.get(0));
        assertEquals(3,expected.get(2));
        assertEquals(6,expected.get(5));

    }

    @Test
    public void testUnion_nonEmptyObject_twoArraysDifferentLength(){
        SortedNumbersList sourceArray = new SortedNumbersList(new int[]{1,2,3,4});
        SortedNumbersList anotherArray = new SortedNumbersList(new int[]{3,4,5,});
        sourceArray.union(anotherArray);
        SortedNumbersList expected=sourceArray.union(anotherArray);
        assertEquals(5,expected.size());
        assertEquals(1,expected.get(0));
        assertEquals(3,expected.get(2));
        assertEquals(5,expected.get(4));
    }

//    @Test
//    public  void testIntersection_nonEmptyObject_twoArraysSameLength() {
//        SortedNumbersList ourArray = new SortedNumbersList(new int[]{3,1, -9, -10});
//        SortedNumbersList anotherArray = new SortedNumbersList(new int[]{-9, 3,2,-10});
//        SortedNumbersList result=ourArray.intersection(anotherArray);
//        int[] expected = {-10,-9,3};
//        assertEquals(expected,result);
//    }

}