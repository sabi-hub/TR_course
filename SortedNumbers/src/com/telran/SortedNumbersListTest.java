package com.telran;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortedNumbersListTest {

    @Test
    public  void testSize_nonEmptyObject_3elements(){
        SortedNumbersList ourArray = new SortedNumbersList(new int[]{2,-9,-10});
        assertEquals(3,ourArray.size());
    }

    @Test
    public  void testSize_EmptyObject_0elements(){
        SortedNumbersList ourArray = new SortedNumbersList();
        assertEquals(0,ourArray.size());
    }

//    @Test
//    public  void testGet_EmptyObject_0elements(){
//        SortedNumbersList ourArray = new SortedNumbersList();
//        assertEquals(0,ourArray.get(0));
//    }

    @Test
    public  void testGet_nonEmptyObject_3elements() {
        SortedNumbersList ourArray = new SortedNumbersList(new int[]{2, -9, -10});
        assertEquals(-10, ourArray.get(0));
        assertEquals(-9, ourArray.get(1));
        assertEquals(2, ourArray.get(2));
    }

    @Test
    public  void testAdd_EmptyObject_0elements(){
        SortedNumbersList ourArray = new SortedNumbersList();
        ourArray.add(2);
        assertEquals(2,ourArray.get(0));
    }

    @Test
    public  void testAdd_nonEmptyObject_toTheEnd() {
        SortedNumbersList ourArray = new SortedNumbersList(new int[]{2, -9, -10});
        ourArray.add(3);
        assertEquals(3, ourArray.get(3));
    }

    @Test
    public  void testAdd_nonEmptyObject_atTheBeginning() {
        SortedNumbersList ourArray = new SortedNumbersList(new int[]{2, -9, -10});
        ourArray.add(-13);
        assertEquals(-13, ourArray.get(0));
    }

    @Test
    public  void testAdd_nonEmptyObject_atTheMiddle() {
        SortedNumbersList ourArray = new SortedNumbersList(new int[]{2, -9, -10});
        ourArray.add(1);
        assertEquals(1, ourArray.get(2));
    }

    @Test
    public  void testRemoveById_nonEmptyObject_atTheBeginning() {
        SortedNumbersList ourArray = new SortedNumbersList(new int[]{2, -9, -10});
        ourArray.removeById(0);
        int[] expected = {-9,2};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public  void testRemoveById_nonEmptyObject_atTheMiddle() {
        SortedNumbersList ourArray = new SortedNumbersList(new int[]{2, -9, -10});
        ourArray.removeById(1);
        int[] expected = {-10,2};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public  void testRemoveById_nonEmptyObject_atTheEnd() {
        SortedNumbersList ourArray = new SortedNumbersList(new int[]{2, -9, -10});
        ourArray.removeById(2);
        int[] expected = {-10,-9};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public  void testRemove_nonEmptyObject_atTheBeginning() {
        SortedNumbersList ourArray = new SortedNumbersList(new int[]{2, -9, -10});
        ourArray.remove(-10);
        int[] expected = {-9,2};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public  void testRemove_nonEmptyObject_atTheMiddle() {
        SortedNumbersList ourArray = new SortedNumbersList(new int[]{2, -9, -10});
        ourArray.remove(-9);
        int[] expected = {-10,2};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public  void testRemove_nonEmptyObject_atTheEnd() {
        SortedNumbersList ourArray = new SortedNumbersList(new int[]{4, -9, -10});
        ourArray.remove(4);
        int[] expected = {-10,-9};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public  void testRemove_nonEmptyObject_booleanTrueFalse() {
        SortedNumbersList ourArray = new SortedNumbersList(new int[]{4, -9, -10});
        assertTrue(ourArray.remove(4));
        assertFalse(ourArray.remove(3));
    }

    @Test
    public  void testRemoveRepeated_nonEmptyObject_atTheBeginning() {
        SortedNumbersList ourArray = new SortedNumbersList(new int[]{2,-10, -9, -10});
        ourArray.removeRepeated(ourArray);
        int[] expected = {-10,-9,2};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public  void testRemoveRepeated_nonEmptyObject_atTheMiddle() {
        SortedNumbersList ourArray = new SortedNumbersList(new int[]{4,-10,4, -9, 6});
        ourArray.removeRepeated(ourArray);
        int[] expected = {-10,-9,4,6};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public  void testRemoveRepeated_nonEmptyObject_atTheEnd() {
        SortedNumbersList ourArray = new SortedNumbersList(new int[]{6,-10,4, -9, 6});
        ourArray.removeRepeated(ourArray);
        int[] expected = {-10,-9,4,6};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

//    @Test
//    public  void testIntersection_nonEmptyObject_twoArraysSameLength() {
//        SortedNumbersList ourArray = new SortedNumbersList(new int[]{3,1, -9, -10});
//        SortedNumbersList anotherArray = new SortedNumbersList(new int[]{-9, 3,2,-10});
//        int[]result=ourArray.intersection(anotherArray);
//        int[] expected = {-10,-9,3};
//        assertEquals(expected,result);
//    }

}