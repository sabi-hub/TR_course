package com.telran.collection;

import org.junit.Test;

import static org.junit.Assert.*;

public class OurHashSetTest {

    OurHashSet<Integer> hashSet = new OurHashSet<>();

    OurHashSet<Integer> other = new OurHashSet<>();

    @Test
    public void testAddSize_oneElement(){

        hashSet.add(3);
        assertEquals(1,hashSet.size());

    }

    @Test
    public void testRemove_treeElements_removeFromEndTrue(){

        hashSet.add(3);
        hashSet.add(-3);
        hashSet.add(5);

        assertTrue(hashSet.remove(5));
        assertEquals(2,hashSet.size());

    }

    @Test
    public void testRemove_treeElements_removeFromMiddleTrue(){

        hashSet.add(3);
        hashSet.add(-3);
        hashSet.add(5);

        assertTrue(hashSet.remove(-3));
        assertEquals(2,hashSet.size());

    }

    @Test
    public void testRemove_treeElements_removeFromBeginningTrue(){

        hashSet.add(3);
        hashSet.add(-3);
        hashSet.add(5);

        assertTrue(hashSet.remove(3));
        assertEquals(2,hashSet.size());

    }

    @Test
    public void testRemove_treeElements_False(){

        hashSet.add(3);
        hashSet.add(-3);
        hashSet.add(5);

        assertFalse(hashSet.remove(2));
        assertEquals(3,hashSet.size());

    }

    @Test
    public void testContains_treeElements_removeFromBeginningTrue(){

        hashSet.add(3);
        hashSet.add(-3);
        hashSet.add(5);

        assertTrue(hashSet.contains(3));
        assertEquals(3,hashSet.size());

    }

    @Test
    public void testContains_treeElements_removeFromEndTrue(){

        hashSet.add(3);
        hashSet.add(-3);
        hashSet.add(5);

        assertTrue(hashSet.contains(5));
        assertEquals(3,hashSet.size());

    }

    @Test
    public void testContains_treeElements_removeFromMiddleTrue(){

        hashSet.add(3);
        hashSet.add(-3);
        hashSet.add(5);

        assertTrue(hashSet.contains(-3));
        assertEquals(3,hashSet.size());

    }

    @Test
    public void testContains_treeElements_False(){

        hashSet.add(3);
        hashSet.add(-3);
        hashSet.add(5);

        assertFalse(hashSet.contains(2));
        assertEquals(3,hashSet.size());

    }

    @Test
    public void testAddAll_treeElementsOneRepeated_True(){

        hashSet.add(3);
        hashSet.add(-3);
        hashSet.add(5);

        other.add(3);
        other.add(2);
        other.add(4);

        assertTrue(hashSet.addAll(other));
        assertEquals(5,hashSet.size());

    }

    @Test
    public void testAddAll_treeElementsTwoRepeated_True(){

        hashSet.add(3);
        hashSet.add(-3);
        hashSet.add(5);

        other.add(3);
        other.add(5);
        other.add(4);

        assertTrue(hashSet.addAll(other));
        assertEquals(4,hashSet.size());

    }

    @Test
    public void testAddAll_treeElementsAllRepeated_False(){

        hashSet.add(3);
        hashSet.add(-3);
        hashSet.add(5);

        other.add(3);
        other.add(-3);
        other.add(5);

        assertFalse(hashSet.addAll(other));
        assertEquals(3,hashSet.size());

    }

    @Test
    public void testRemoveAll_treeElementsOneRepeated_True(){

        hashSet.add(3);
        hashSet.add(-3);
        hashSet.add(5);

        other.add(3);
        other.add(2);
        other.add(4);

        assertTrue(hashSet.removeAll(other));
        assertEquals(2,hashSet.size());

    }

    @Test
    public void testRemoveAll_treeElementsTwoRepeated_True(){

        hashSet.add(3);
        hashSet.add(-3);
        hashSet.add(5);

        other.add(3);
        other.add(5);
        other.add(4);

        assertTrue(hashSet.removeAll(other));
        assertEquals(1,hashSet.size());

    }

    @Test
    public void testRemoveAll_treeElementsNoRepeated_False(){

        hashSet.add(3);
        hashSet.add(-3);
        hashSet.add(5);

        other.add(1);
        other.add(2);
        other.add(4);

        assertFalse(hashSet.removeAll(other));
        assertEquals(3,hashSet.size());

    }

    @Test
    public void testRetainAll_treeElementsOneRepeated_True(){

        hashSet.add(3);
        hashSet.add(-3);
        hashSet.add(5);

        other.add(3);
        other.add(2);
        other.add(4);

        assertTrue(hashSet.retainAll(other));
        assertEquals(1,hashSet.size());

    }

    @Test
    public void testRetainAll_treeElementsTwoRepeated_True(){

        hashSet.add(3);
        hashSet.add(-3);
        hashSet.add(5);

        other.add(3);
        other.add(5);
        other.add(4);

        assertTrue(hashSet.retainAll(other));
        assertEquals(2,hashSet.size());

    }

    @Test
    public void testRetainAll_treeElementsNoRepeated_False(){

        hashSet.add(2);
        hashSet.add(1);
        hashSet.add(4);

        other.add(2);
        other.add(1);
        other.add(4);
        other.add(5);

        assertFalse(hashSet.retainAll(other));

    }

}