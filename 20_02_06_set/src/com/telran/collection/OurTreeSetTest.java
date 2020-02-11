package com.telran.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class OurTreeSetTest {

    private OurTreeSet<Integer> treeSet = new OurTreeSet<>();
    private OurTreeSet<Integer> other = new OurTreeSet<>();

    @Test
    public void testAddSize_oneElement_True(){
        assertTrue(treeSet.add(3));
        assertEquals(1,treeSet.size());
    }

    @Test
    public void testAddSize_threeElements_False(){
        treeSet.add(10);
        treeSet.add(8);
        treeSet.add(5);
        assertFalse(treeSet.add(8));
        assertEquals(3,treeSet.size());
    }

    @Test
    public void testAddSize_tenElements_True(){
        treeSet.add(10);
        treeSet.add(8);
        treeSet.add(5);
        treeSet.add(16);
        treeSet.add(17);
        treeSet.add(14);
        treeSet.add(15);
        treeSet.add(11);
        treeSet.add(12);
        treeSet.add(13);
        assertEquals(10,treeSet.size());
    }

    @Test
    public void testRemove_oneElement_rootTrue(){
        treeSet.add(10);

        assertTrue(treeSet.remove(10));
        assertEquals(0,treeSet.size());
    }

    @Test
    public void testRemove_twoElementsLeft_leastTrue(){
        treeSet.add(10);
        treeSet.add(8);

        assertTrue(treeSet.remove(8));
        assertEquals(1,treeSet.size());
    }

    @Test
    public void testRemove_twoElementsLeft_rootTrue(){
        treeSet.add(10);
        treeSet.add(8);

        assertTrue(treeSet.remove(8));
        assertEquals(1,treeSet.size());
    }

    @Test
    public void testRemove_twoElementsRight_leastTrue(){
        treeSet.add(10);
        treeSet.add(12);

        assertTrue(treeSet.remove(12));
        assertEquals(1,treeSet.size());
    }

    @Test
    public void testRemove_twoElementsRight_rootTrue(){
        treeSet.add(10);
        treeSet.add(12);

        assertTrue(treeSet.remove(12));
        assertEquals(1,treeSet.size());
    }

    @Test
    public void testRemove_tenElements_rootTrue(){
        treeSet.add(10);
        treeSet.add(8);
        treeSet.add(5);
        treeSet.add(16);
        treeSet.add(17);
        treeSet.add(14);
        treeSet.add(15);
        treeSet.add(11);
        treeSet.add(12);
        treeSet.add(13);
        assertTrue(treeSet.remove(10));
        assertEquals(9,treeSet.size());
    }

    @Test
    public void testRemove_tenElements_leastTrue(){
        treeSet.add(10);
        treeSet.add(8);
        treeSet.add(5);
        treeSet.add(16);
        treeSet.add(17);
        treeSet.add(14);
        treeSet.add(15);
        treeSet.add(11);
        treeSet.add(12);
        treeSet.add(13);
        assertTrue(treeSet.remove(5));
        assertEquals(9,treeSet.size());
    }

    @Test
    public void testRemove_tenElements_junctionLeftTrue(){
        treeSet.add(10);
        treeSet.add(8);
        treeSet.add(5);
        treeSet.add(16);
        treeSet.add(17);
        treeSet.add(14);
        treeSet.add(15);
        treeSet.add(11);
        treeSet.add(12);
        treeSet.add(13);
        assertTrue(treeSet.remove(11));
        assertEquals(9,treeSet.size());
    }

    @Test
    public void testRemove_tenElements_junctionRightTrue(){
        treeSet.add(10);
        treeSet.add(8);
        treeSet.add(5);
        treeSet.add(16);
        treeSet.add(17);
        treeSet.add(14);
        treeSet.add(15);
        treeSet.add(11);
        treeSet.add(12);
        treeSet.add(13);
        assertTrue(treeSet.remove(16));
        assertEquals(9,treeSet.size());
    }

    @Test
    public void testRemove_tenElements_junctionTwoChildrenTrue(){
        treeSet.add(10);
        treeSet.add(8);
        treeSet.add(5);
        treeSet.add(16);
        treeSet.add(17);
        treeSet.add(14);
        treeSet.add(15);
        treeSet.add(11);
        treeSet.add(12);
        treeSet.add(13);
        assertTrue(treeSet.remove(14));
        assertEquals(9,treeSet.size());
    }

    @Test
    public void testRemove_tenElements_linealRightTrue(){
        treeSet.add(10);
        treeSet.add(8);
        treeSet.add(5);
        treeSet.add(16);
        treeSet.add(17);
        treeSet.add(14);
        treeSet.add(15);
        treeSet.add(11);
        treeSet.add(12);
        treeSet.add(13);
        assertTrue(treeSet.remove(12));
        assertEquals(9,treeSet.size());
    }

    @Test
    public void testRemove_tenElements_linealLeftTrue(){
        treeSet.add(10);
        treeSet.add(8);
        treeSet.add(5);
        treeSet.add(16);
        treeSet.add(17);
        treeSet.add(14);
        treeSet.add(15);
        treeSet.add(11);
        treeSet.add(12);
        treeSet.add(13);
        assertTrue(treeSet.remove(8));
        assertEquals(9,treeSet.size());
    }

    @Test
    public void testContains_oneElement_True(){
        treeSet.add(10);
        assertTrue(treeSet.contains(10));
    }

    @Test
    public void testContains_noElement_False(){
        assertFalse(treeSet.contains(10));
    }

    @Test
    public void testContains_fullTree_False(){
        treeSet.add(10);
        treeSet.add(8);
        treeSet.add(5);
        treeSet.add(16);
        treeSet.add(17);
        treeSet.add(14);
        treeSet.add(15);
        treeSet.add(11);
        treeSet.add(12);
        treeSet.add(13);
        assertFalse(treeSet.contains(6));
    }

    @Test
    public void testContains_fullTree_True(){
        treeSet.add(10);
        treeSet.add(8);
        treeSet.add(5);
        treeSet.add(16);
        treeSet.add(17);
        treeSet.add(14);
        treeSet.add(15);
        treeSet.add(11);
        treeSet.add(12);
        treeSet.add(13);
        assertTrue(treeSet.contains(14));
    }

    @Test
    public void testContains_fullTreeLeast_True(){
        treeSet.add(10);
        treeSet.add(8);
        treeSet.add(5);
        treeSet.add(16);
        treeSet.add(17);
        treeSet.add(14);
        treeSet.add(15);
        treeSet.add(11);
        treeSet.add(12);
        treeSet.add(13);
        assertTrue(treeSet.contains(5));
    }

    @Test
    public void testContains_fullTreeRoot_True(){
        treeSet.add(10);
        treeSet.add(8);
        treeSet.add(5);
        treeSet.add(16);
        treeSet.add(17);
        treeSet.add(14);
        treeSet.add(15);
        treeSet.add(11);
        treeSet.add(12);
        treeSet.add(13);
        assertTrue(treeSet.contains(10));
    }

    @Test
    public void testAddAll_oneRepeated_True(){
        treeSet.add(10);
        treeSet.add(8);
        treeSet.add(5);
        treeSet.add(16);
        treeSet.add(17);
        treeSet.add(14);

        other.add(7);
        other.add(5);
        other.add(9);

        assertTrue(treeSet.addAll(other));
        assertEquals(8,treeSet.size());
    }

    @Test
    public void testAddAll_twoRepeated_True(){
        treeSet.add(10);
        treeSet.add(8);
        treeSet.add(5);
        treeSet.add(16);
        treeSet.add(17);
        treeSet.add(14);

        other.add(7);
        other.add(5);
        other.add(8);

        assertTrue(treeSet.addAll(other));
        assertEquals(7,treeSet.size());
    }

    @Test
    public void testAddAll_allRepeated_False(){
        treeSet.add(10);
        treeSet.add(8);
        treeSet.add(5);
        treeSet.add(16);
        treeSet.add(17);
        treeSet.add(14);

        other.add(14);
        other.add(8);
        other.add(10);
        other.add(5);
        other.add(17);
        other.add(16);

        assertFalse(treeSet.addAll(other));
        assertEquals(6,treeSet.size());
    }

    @Test
    public void testRemoveAll_treeElementsOneRepeated_True(){

        treeSet.add(10);
        treeSet.add(8);
        treeSet.add(5);

        other.add(3);
        other.add(8);
        other.add(4);

        assertTrue(treeSet.removeAll(other));
        assertEquals(2,treeSet.size());

    }

    @Test
    public void testRemoveAll_treeElementsTwoRepeated_True(){

        treeSet.add(10);
        treeSet.add(8);
        treeSet.add(5);

        other.add(3);
        other.add(8);
        other.add(5);

        assertTrue(treeSet.removeAll(other));
        assertEquals(1,treeSet.size());

    }

    @Test
    public void testRemoveAll_treeElementsNoRepeated_False(){

        treeSet.add(10);
        treeSet.add(8);
        treeSet.add(5);

        other.add(3);
        other.add(7);
        other.add(4);

        assertFalse(treeSet.removeAll(other));
        assertEquals(3,treeSet.size());

    }

    @Test
    public void testRetainAll_oneRepeated_True(){
        treeSet.add(10);
        treeSet.add(8);
        treeSet.add(5);

        other.add(3);
        other.add(8);
        other.add(4);

        assertTrue(treeSet.retainAll(other));
        assertEquals(1,treeSet.size());
    }

    @Test
    public void testRetainAll_twoRepeated_True(){
        treeSet.add(10);
        treeSet.add(8);
        treeSet.add(5);

        other.add(5);
        other.add(8);
        other.add(4);

        assertTrue(treeSet.retainAll(other));
        assertEquals(2,treeSet.size());
    }

    @Test
    public void testRetainAll_innerSet_False(){
        treeSet.add(10);
        treeSet.add(8);
        treeSet.add(5);

        other.add(5);
        other.add(8);
        other.add(10);
        other.add(6);

        assertFalse(treeSet.retainAll(other));
        assertEquals(3,treeSet.size());
    }

    @Test
    public void testRetainAll_fullTreeThreeRepeated_True(){
        treeSet.add(10);
        treeSet.add(8);
        treeSet.add(5);
        treeSet.add(16);
        treeSet.add(17);
        treeSet.add(14);
        treeSet.add(15);
        treeSet.add(11);
        treeSet.add(12);
        treeSet.add(13);

        other.add(5);
        other.add(7);
        other.add(10);
        other.add(16);

        assertTrue(treeSet.retainAll(other));
        assertEquals(3,treeSet.size());
    }

    @Test
    public void testIterator(){
        treeSet.add(10);
        treeSet.add(8);
        treeSet.add(5);
        treeSet.add(16);
        treeSet.add(17);
        treeSet.add(14);
        treeSet.add(15);
        treeSet.add(11);
        treeSet.add(12);
        treeSet.add(13);

        int[] treeNodes = {5, 8, 10, 11, 12, 13, 14, 15, 16,17};
        List<Integer> expected =new ArrayList<>();
        for(Integer i:treeNodes)
            expected.add(i);

        List<Integer> res =new ArrayList<>();
        for(Integer child:treeSet)
            res.add(child);

//        Iterator<Integer> it = treeSet.iterator();
//        while (it.hasNext()){
//            res.add(it.next());
//        }

        assertEquals(10,treeSet.size());
        assertEquals(expected,res);
    }

}