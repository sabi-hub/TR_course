package com.telran;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TreeTest {

    @Test
    public void  testSize(){
        Node A = new Node();
        Node B = new Node();
        Node C = new Node();
        Node D = new Node();

        A.children = Arrays.asList(B,C,D);

        Tree tree = new Tree();

        tree.root = A;

        assertEquals(4,tree.size());

    }

    @Test
    public void  testHeight_4levels(){
        Node A = new Node();
        Node B = new Node();
        Node C = new Node();
        Node D = new Node();
        Node E = new Node();

        A.children = Arrays.asList(B,C);
        B.children= Arrays.asList(D);
        D.children =Arrays.asList(E);

        Tree tree = new Tree();

        tree.root = A;

        assertEquals(4,tree.height());

    }

    @Test
    public void  testHeight_1level(){
        Node A = new Node();

        Tree tree = new Tree();

        tree.root = A;

        assertEquals(1,tree.height());

    }


}