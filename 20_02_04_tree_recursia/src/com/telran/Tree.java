package com.telran;

import javax.swing.plaf.IconUIResource;
import java.util.Comparator;

public class Tree {
    Node root;

    public int size() {
        return rSize(root);
    }

    public int height() {
        return rHeight(root);
    }

    private int rHeight(Node currentRoot) {

        int height =0;
        if(currentRoot==null){
            return height;
        }
        if (currentRoot.children == null)
            return 1;

        for(Node child:currentRoot.children){
            height=Math.max(height,rHeight(child));

        }

        return height+1;
    }

    private int rSize(Node currentRoot) {
//        if (currentRoot.children.size() == 0)
//            return 1;
        int res = 1;
        for (Node child : currentRoot.children) {
            res += rSize(child);
        }
        return res;
    }
}
