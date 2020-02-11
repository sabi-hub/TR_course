package com.telran;

public class BinaryTree {
    BinaryNode root;


    public int size() { //number of vertex
        return rSize(root);
    }

    public  int height(){
        return rHeight(root);
    }

    public  int weight(){
        return rWeight(root);
    }

    private int rWeight(BinaryNode currentRoot) {
        if (currentRoot==null)
            return 0;

        return  currentRoot.data+ rWeight(currentRoot.left)+rWeight(currentRoot.right);
    }


    private int rSize(BinaryNode currentRoot) {
        if (currentRoot == null)
            return 0;
        return 1 + rSize(currentRoot.left) + rSize(currentRoot.right);
    }

    private int rHeight(BinaryNode currentRoot) { //height
        if (currentRoot == null) {
            return 0;
        }
        int heightLeft = rHeight(currentRoot.left);
        int heightRight = rHeight(currentRoot.right);
        int res = Math.max(heightLeft, heightRight) + 1;

        return res;
    }

    //    private int rSizeNative(BinaryNode currentRoot){
//        if (currentRoot.left==null && currentRoot.right==null)
//            return 1;
//        if (currentRoot.left==null)
//            return 1+rSizeNative(currentRoot.right);
//        if (currentRoot.right==null)
//            return 1+rSizeNative(currentRoot.left);
//        return 1+rSizeNative(currentRoot.left) + rSizeNative(currentRoot.right);
//    }

    //    public int rHeight(BinaryNode currentRoot) { //height
//        if (currentRoot == null) {
//            return 0;
//        }
//        int res = Math.max(rHeight(currentRoot.left), rHeight(currentRoot.right)) + 1;
//        System.out.println(res);
//
//        return res;
//    }

}


