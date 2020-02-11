package com.telran.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class OurTreeSetTest {

    private OurTreeSet<Integer> treeSet = new OurTreeSet<>();


//    OurTreeSet<Integer> other = new OurTreeSet<>();


//    @Test
//    public void testAdd_SetWithTreeElements_TreeElement() {
//        Integer sample01 = 5;
//        Integer sample02 = 1;
//        Integer sample03 = 2;
//        ourTreeSet.add(sample01);
//        ourTreeSet.add(sample02);
//        ourTreeSet.add(sample03);
//        assertEquals(3, ourTreeSet.size());
//    }

//
    @Test
    public void testAddSize_oneElement(){

        treeSet.add(3);
//        assertTrue(treeSet.add(3));
        assertEquals(1,treeSet.size());

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

        OurTreeSetIterator<Integer> treeSetIterator = new OurTreeSetIterator<>(treeSet);


        int[] treeNodes = {5, 8, 10, 11, 12, 13, 14, 15, 16,17};
        List<Integer> expected =new ArrayList<>();
        for(Integer i:treeNodes)
            expected.add(i);

        List<Integer> res =new ArrayList<>();
////
//        for(Integer child:treeSet)
//            res.add(child);

        Iterator<Integer> it = treeSet.iterator();
        while (it.hasNext()){
            res.add(it.next());
        }



//        assertTrue(treeSet.add(3));
        assertEquals(10,treeSet.size());
        assertEquals(expected,res);

    }

}