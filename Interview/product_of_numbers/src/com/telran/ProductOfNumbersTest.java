package com.telran;

import org.junit.Test;


import static org.junit.Assert.*;

public class ProductOfNumbersTest {
    ProductOfNumbers<Integer> productOfNum = new ProductOfNumbers<>();

    @Test
    public void testNumbersFounder_numbersInList_True(){
        int[] source = {1,2,3,6,8,10,15};
        int n = 30;

        productOfNum.numbersFounder(source, n);
        assertTrue(true);
    }

    @Test
    public void testNumbersFounder_numbersIsNotInList_False(){
        int[] source = {1,2,3,6,8,10,15};
        int n = 130;

        productOfNum.numbersFounder(source, n);
        assertFalse(false);
    }

}