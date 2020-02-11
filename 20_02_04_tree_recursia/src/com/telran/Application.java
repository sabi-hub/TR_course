package com.telran;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
	// write your code here
        BinaryTree bt = new BinaryTree();
//        Tree tree = new Tree();
//
//        Node A = new Node();
//        Node B = new Node();
//        Node C = new Node();
//        Node D = new Node();
//        Node E = new Node();
//        Node F = new Node();
//        Node G = new Node();
//        Node H = new Node();
//
//
//        A.children = Arrays.asList(B,C);
//        B.children = Arrays.asList(D,H);
//        D.children = Arrays.asList(E);
//        E.children = Arrays.asList(F,G);
//
//
//
////        tree.size();
//        tree.root=A;
//        System.out.println(tree.height());

        // root level 0
        BinaryNode A = BinaryNode.createNode(70);
        // Level 1
        BinaryNode B = BinaryNode.createNode(50);
        BinaryNode C = BinaryNode.createNode(90);
        // Level 2
        BinaryNode D = BinaryNode.createNode(25);
        BinaryNode E = BinaryNode.createNode(75);
        BinaryNode F = BinaryNode.createNode(35);
        BinaryNode G = BinaryNode.createNode(55);
        // Level 3
        BinaryNode H = BinaryNode.createNode(10);
        BinaryNode I = BinaryNode.createNode(30);

        BinaryNode J = BinaryNode.createNode(30);

        // connect Level 0 and 1
        A.left  = B;
        A.right = C;
        // connect level 1 and level 2
        B.left  = D;
        B.right = E;
        C.left  = F;
        C.right = G;
        // connect level 2 and level 3
        F.left  = H;
        F.right = I;

        H.left  = J;


        bt.root=A;

        int weight = bt.weight();
        System.out.println(weight);

//        int height = bt.height();
//        System.out.println("Height of a Binary Tree is: " + height);
//
//        int nodes = bt.size();
//        System.out.println("Number of Nodes in a Binary Tree: " + nodes);

    }
}
