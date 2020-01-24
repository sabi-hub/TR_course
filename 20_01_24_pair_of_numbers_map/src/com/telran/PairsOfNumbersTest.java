package com.telran;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PairsOfNumbersTest {
    PairsOfNumbers pn = new PairsOfNumbers();

    @Test
    public void testWithoutPair_doubleNumbers() {
        List<Integer> list = Arrays.asList(1, 2, -4, 3, 1, 2, 3);

        assertEquals(-4, pn.getNumberWithoutPair(list));
    }

    @Test
    public void testWithoutPair_threeOrMoreSameNumbers() {
        List<Integer> list = Arrays.asList(2, 2, -4, 3, -4, 3, 3, 3, 3);

        assertEquals(3, pn.getNumberWithoutPair(list));
    }


}