package com.telran;

class BinaryNode {
    int data;
    BinaryNode left;
    BinaryNode right;

    public BinaryNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }


    public static BinaryNode createNode(int number) {
        return new BinaryNode(number);
    }
}
