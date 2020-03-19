package com.telran;

import org.junit.Test;

import static org.junit.Assert.*;

public class CroppedTextTest {
    CroppedText ct = new CroppedText();

    @Test
    public void testGetCroppedText_oneWordFromText_withSpace(){
        String text = "hello world hi to all";
        int k = 10;
        String result = ct.getCroppedText(text,k);
        String expected = "hello";

        assertEquals(expected,result);
    }

    @Test
    public void testGetCroppedText_allWords_equalsK(){
        String text = "hello world";
        int k = 11;
        String result = ct.getCroppedText(text,k);
        String expected = "hello world";

        assertEquals(expected,result);
    }

    @Test
    public void testGetCroppedText_allWords_kMoreText(){
        String text = "hello world";
        int k = 21;
        String result = ct.getCroppedText(text,k);
        String expected = "hello world";

        assertEquals(expected,result);
    }

    @Test
    public void testGetCroppedText_fourWordsFromText_noSpace(){
        String text = "hello world hi to all";
        int k = 14;
        String result = ct.getCroppedText(text,k);
        String expected = "hello world hi";

        assertEquals(expected,result);
    }

    @Test
    public void testGetCroppedText_noWordsFromText(){
        String text = "hello world hi to all";
        int k = 3;
        String result = ct.getCroppedText(text,k);
        String expected = "";

        assertEquals(expected,result);
    }

}