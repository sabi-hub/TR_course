package com.telran.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class OurTreeSetIteratorTest {
    private OurTreeSet<Integer> treeSet = new OurTreeSet<>();

    @Test
    public void testHasNext_severalElements_True() {
        treeSet.add(10);
        treeSet.add(8);
        treeSet.add(5);
        treeSet.add(15);

        assertEquals(4,treeSet.size());
        assertTrue(treeSet.iterator().hasNext());

    }

    @Test
    public void testHasNext_oneElement_True() {
        treeSet.add(10);

        assertEquals(1,treeSet.size());
        assertTrue(treeSet.iterator().hasNext());

    }

    @Test
    public void testHasNext_noElements_False() {

        assertEquals(0,treeSet.size());
        assertFalse(treeSet.iterator().hasNext());

    }

    @Test
    public void testNext_forElements() {
        treeSet.add(10);
        treeSet.add(8);
        treeSet.add(5);
        treeSet.add(15);

        int[] treeNodes = {5, 8, 10, 15};

        List<Integer> expected =new ArrayList<>();
        for(Integer i:treeNodes)
            expected.add(i);

        List<Object> res = new ArrayList<>();

        for(Integer i:treeSet)
            res.add(i);

        assertEquals(4,treeSet.size());
        assertEquals(expected,res);

    }

    @Test
    public void testNext_oneElement() {
        treeSet.add(10);

        int[] treeNodes = {10};

        List<Integer> expected =new ArrayList<>();
        for(Integer i:treeNodes)
            expected.add(i);

        List<Object> res = new ArrayList<>();

        for(Integer i:treeSet)
            res.add(i);

        assertEquals(1,treeSet.size());
        assertEquals(expected,res);

    }
}