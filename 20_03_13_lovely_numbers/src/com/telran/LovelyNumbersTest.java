package com.telran;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LovelyNumbersTest {
    LovelyNumbers ln = new LovelyNumbers();

    @Test
    public void testIsLovely_differentNumbers_True(){
        int number = 1234;

        boolean result = ln.isLovely(number);

        assertTrue(result);
    }

    @Test
    public void testIsLovely_doubleRepeatedNumbers_True(){
        int number = 1212;

        boolean result = ln.isLovely(number);

        assertTrue(result);
    }

    @Test
    public void testIsLovely_doubleSymmetricNumbers_True(){
        int number = 1221;

        boolean result = ln.isLovely(number);

        assertTrue(result);
    }
    @Test
    public void testIsLovely_threeNumbersAndOneRepeated_True(){
        int number = 122;

        boolean result = ln.isLovely(number);

        assertTrue(result);
    }

    @Test
    public void testIsLovely_oneNumberThreeTimes_False(){
        int number = 1222;

        boolean result = ln.isLovely(number);

        assertFalse(result);
    }

    @Test
    public void testIsLovely_allNumbersTheSame_False(){
        int number = 2222;

        boolean result = ln.isLovely(number);

        assertFalse(result);
    }

    @Test
    public void testIsLovely_fiveNumbers_False(){
        int number = 22211;

        boolean result = ln.isLovely(number);

        assertFalse(result);
    }

    @Test
    public void testIsLovely_oneThousand_False(){
        int number = 1000;

        boolean result = ln.isLovely(number);

        assertFalse(result);
    }

    @Test
    public void testGetLovelyNumbers_threeNumbersArr_fiveNumbersFromSix(){
        int a = 110;
        int b = 115;

        List<Integer>result = ln.getLovelyNumbers(a,b);

        List<Integer> expected = Arrays.asList(110,112,113,114,115);

        assertEquals(expected, result);
    }

    @Test
    public void testGetLovelyNumbers_threeNumbersArr_allLovely(){
        int a = 100;
        int b = 110;

        List<Integer>result = ln.getLovelyNumbers(a,b);

        List<Integer> expected = Arrays.asList(100,101,102,103,104,105,106,107,108,109,110);

        assertEquals(expected, result);
    }

    @Test
    public void testGetLovelyNumbers_fourNumbersArr_oneNotLovely(){
        int a = 1000;
        int b = 1010;

        List<Integer>result = ln.getLovelyNumbers(a,b);

        List<Integer> expected = Arrays.asList(1001,1002,1003,1004,1005,1006,1007,1008,1009,1010);

        assertEquals(expected, result);
    }

    @Test
    public void testGetLovelyNumbers_fourNumbersArr_allLovely(){
        int a = 1230;
        int b = 1235;

        List<Integer>result = ln.getLovelyNumbers(a,b);

        List<Integer> expected = Arrays.asList(1230,1231,1232,1233,1234,1235);

        assertEquals(expected, result);
    }


}