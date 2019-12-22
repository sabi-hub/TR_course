package com.telran;

import org.junit.Test;

import static org.junit.Assert.*;

public class ApplicationTest {

    @Test
    public void testReverse_reverseString(){
        Application string = new Application();
        String str = "HelloWorld";

        String expected = "dlroWolleH";
        assertEquals(expected, string.reverse(str));

    }

    @Test
    public void testCountOfSubstrings_lowAllCases(){
        Application string = new Application();
        String text = "hello, hello, hello";
        String pattern = "he";
        String pattern1 = "e";
        String pattern2 = ", ";
        String pattern3 = "l";

        assertEquals(3, string.entrances(pattern,text));
        assertEquals(3, string.entrances(pattern1,text));
        assertEquals(2, string.entrances(pattern2,text));
        assertEquals(6, string.entrances(pattern3,text));

    }
    @Test
    public void testCountOfSubstrings_upperAllCases(){
        Application string = new Application();
        String text = "HELlo, helLo, hello";
        String pattern = "He";
        String pattern1 = "E";
        String pattern3 = "L";
        String pattern2 = ", ";

        assertEquals(3, string.entrances(pattern,text));
        assertEquals(3, string.entrances(pattern1,text));
        assertEquals(2, string.entrances(pattern2,text));
        assertEquals(6, string.entrances(pattern3,text));

    }

    @Test
    public void testCountOfSubstrings_upperTextCases(){
        Application string = new Application();
        String text = "HELlo, helLo, hello";
        String pattern = "he";
        String pattern1 = "e";
        String pattern3 = "l";
        String pattern2 = ", ";

        assertEquals(3, string.entrances(pattern,text));
        assertEquals(3, string.entrances(pattern1,text));
        assertEquals(2, string.entrances(pattern2,text));
        assertEquals(6, string.entrances(pattern3,text));

    }

    @Test
    public void testCountOfSubstrings_upperPatternCases(){
        Application string = new Application();
        String text = "hello, hello, hello";
        String pattern = "He";
        String pattern1 = "E";
        String pattern3 = "L";
        String pattern2 = ", ";

        assertEquals(3, string.entrances(pattern,text));
        assertEquals(3, string.entrances(pattern1,text));
        assertEquals(2, string.entrances(pattern2,text));
        assertEquals(6, string.entrances(pattern3,text));

    }



}