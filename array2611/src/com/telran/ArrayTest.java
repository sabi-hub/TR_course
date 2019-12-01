package com.telran;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayTest {

    @Test
    public  void testSize_nonEmptyObject_3elements(){
        Array ourArray = new Array(new int[]{2,-9,-10});
        assertEquals(3,ourArray.size());
    }

    @Test
    public  void testSize_EmptyObject_0elements(){
        Array ourArray = new Array();
        assertEquals(0,ourArray.size());
    }

    @Test
    public  void testGet_nonEmptyObject_GetElement(){
        Array ourArray = new Array(new int[]{2,-9,-10});
        assertEquals(2,ourArray.get(0));
        assertEquals(-9,ourArray.get(1));
        assertEquals(-10,ourArray.get(2));
    }

//    @Test
//    public  void testGet_EmptyObject_GetElement(){
//        Array ourArray = new Array();
//        assertEquals(0,ourArray.get(2));
//    }

    @Test
    public  void testSet_nonEmptyObject_SetElement(){
        Array ourArray = new Array(new int[]{2,-9,-10});
        ourArray.set(1,5);
        assertEquals(5,ourArray.get(1));
    }

    @Test
    public  void testSet_EmptyObject_SetElement(){
        Array ourArray = new Array();
        ourArray.set(0,5);
        assertEquals(5,ourArray.get(0));
    }

    @Test
    public void testAppend_NonEmptyArray_AllElementsMatch(){
        Array ourArray = new Array(new int[]{2,-9,-10});
        ourArray.append(5);//{2,-9,-10,5}
        int[] expected = {2,-9,-10,5};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public void testAppend_EmptyArray_1ElementMatch(){
        Array ourArray = new Array();
        ourArray.append(5);//{5}
        int[] expected = {5};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public void testInsert_EmptyArray_1ElementMatch(){
        Array ourArray = new Array();
        ourArray.insert(0,5);//{5}
        int[] expected = {5};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public void testInsert_NonEmptyArray_FirstElementsInsert(){
        Array ourArray = new Array(new int[]{2,-9,-10});
        ourArray.insert(0,5);//{5, 2,-9,-10}
        int[] expected = {5, 2,-9,-10};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public void testInsert_NonEmptyArray_MiddleElementsInsert(){
        Array ourArray = new Array(new int[]{2,-9,-10});
        ourArray.insert(2,5);//{2,-9,5,-10}
        int[] expected = {2,-9,5,-10};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public void testInsert_NonEmptyArray_LastElementsInsert(){
        Array ourArray = new Array(new int[]{2,-9,-10});
        ourArray.insert(3,5);//{2,-9,-10,5}
        int[] expected = {2,-9,-10,5};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public void testRemoveById_NonEmptyArray_FirstElementsRemove(){
        Array ourArray = new Array(new int[]{2,-9,-10});
        ourArray.removeById(0);//{5, 2,-9,-10}
        int[] expected = {-9,-10};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public void testRemoveById_NonEmptyArray_MiddleElementRemove(){
        Array ourArray = new Array(new int[]{2,-9,5,-10});
        ourArray.removeById(2);
        int[] expected = {2,-9,-10};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public void testRemoveById_NonEmptyArray_LastElementRemove(){
        Array ourArray = new Array(new int[]{2,-9,5,-10});
        ourArray.removeById(3);
        int[] expected = {2,-9,5};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public void testRemove_NonEmptyArray_FirstElementRemove(){
        Array ourArray = new Array(new int[]{2,-9,-10});
        ourArray.remove(2);
        int[] expected = {-9,-10};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public void testRemove_NonEmptyArray_MiddleElementRemove(){
        Array ourArray = new Array(new int[]{2,-9,5,-10});
        ourArray.remove(5);
        int[] expected = {2,-9,-10};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public void testRemove_NonEmptyArray_LastElementRemove(){
        Array ourArray = new Array(new int[]{2,-9,5,-10});
        ourArray.remove(-10);
        int[] expected = {2,-9,5};
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(expected[i], ourArray.get(i));
        }
    }

    @Test
    public void testRemove_NonEmptyArray_True(){
        Array ourArray = new Array(new int[]{2,-9,5,-10});
        boolean value=ourArray.remove(-10);
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(true, value);
        }
    }

    @Test
    public void testRemove_NonEmptyArray_False(){
        Array ourArray = new Array(new int[]{2,-9,5,-10});
        boolean value=ourArray.remove(3);
        for (int i = 0; i < ourArray.size(); i++) {
            assertEquals(false, value);
        }
    }



}