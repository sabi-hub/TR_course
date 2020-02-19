package com.telran;

import org.junit.Test;

import static org.junit.Assert.*;

public class SubsequenceTest {

    @Test
    public void testSubsequence_True(){
        Subsequence subsequence = new Subsequence();

        String text = "abcdeaab";
        String pattern = "acdaa";

        assertTrue(subsequence.subsequence(text,pattern));
    }

    @Test
    public void testSubsequence_False(){
        Subsequence subsequence = new Subsequence();

        String text = "abcdeaab";
        String pattern = "acdca";

        assertFalse(subsequence.subsequence(text,pattern));
    }

}