package com.telran.collection;

import java.util.Comparator;
import java.util.Iterator;

public class OurTreeSet<E> implements OurSet<E> {

//    private final static Object INSTANCE = new Object();
//    private Map<E, Object> source;

    TreeNode<E> root;
    private Comparator<E> comparator;
    private int size;

    public OurTreeSet(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public OurTreeSet() {
        this.comparator = new Comparator<E>() {
            //inner method for comparator (вложенный класс)
            @Override
            public int compare(E e, E t1) {
                Comparable<E> eComparable = (Comparable<E>) e;
                int res = eComparable.compareTo(t1);
                return res;
            }
        };
    }

    @Override
    public boolean add(E e) {

        if (root == null) {
            root = new TreeNode();
            root.key = e;
            size++;
            return true;
        }

        TreeNode<E> parent = root;
        TreeNode<E> current = root;

        //цикл останавливается если current==null
        while (current != null && comparator.compare(current.key, e) != 0) {
            parent = current;
            current = comparator.compare(current.key, e) > 0 ? current.left : current.right;
        }

        // проверка на то, что нашелся узел в котором значение равно входящему элементу, мы не добавляем элементы и выдаем false
        if (current != null)
            return false;

        current = new TreeNode<>();
        current.key = e;
        current.parent = parent;

        if (comparator.compare(e, parent.key) < 0)
            parent.left = current;
        else
            parent.right = current;

        size++;
        return true;
    }

    @Override
    public boolean remove(E e) {

        TreeNode<E> nodeToRemove = getNode(e);

        if (nodeToRemove == null)
            return false;

        if (nodeToRemove.left==null||nodeToRemove.right==null)
            linialRemove (nodeToRemove);
        else
            junctionRemove(nodeToRemove);

        size --;
        return true;
    }

    private void junctionRemove(TreeNode<E> nodeToRemove) {
        TreeNode<E> needle = nodeToRemove.right; //чтобы спуститься по левой части, переходим на правый нод

        while (needle.left!=null)//спускаемся по левой части до самого конца
            needle = needle.left;

        nodeToRemove.key = needle.key;//значение найденного в левой части нода переписываем в удаляемый нод
        linialRemove(needle); // чистим левый новый нод линейным способом

    }

    private void linialRemove(TreeNode<E> nodeToRemove) {
        TreeNode<E> parent = nodeToRemove.parent;
        TreeNode<E> child = nodeToRemove.left == null? nodeToRemove.right:nodeToRemove.left;

        if (parent==null) {
            root = child;
        } else if(parent.right==nodeToRemove){
            parent.right=child; //создаем ссылку к новому ребенку
        } else{
            parent.left = child;
        }

        if(child!=null)
            child.parent = parent; // от ребенка делаем обратную ссылку к родителю

        clearNode(nodeToRemove);
    }

    private void clearNode(TreeNode<E> nodeToRemove){
        nodeToRemove.key=null;
        nodeToRemove.left=null;
        nodeToRemove.right=null;
        nodeToRemove.parent=null;
    }

    @Override
    public boolean contains(E e) {

        return (getNode(e)!=null);

        //without method getNode
//        TreeNode<E> current = root;
//
//        while (current != null && comparator.compare(current.key, e) != 0) {
//            current = comparator.compare(current.key, e) > 0 ? current.left : current.right;
//        }
//
//        if (current != null)
//            return true;
//
//        return false;
    }

    private TreeNode<E> getNode(E e){
        TreeNode<E> current = root;

        while (current != null && comparator.compare(current.key, e) != 0) {
            current = comparator.compare(current.key, e) > 0 ? current.left : current.right;
        }
        return current;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean addAll(OurSet other) {
        return false;
    }

    @Override
    public boolean removeAll(OurSet other) {
        return false;
    }

    @Override
    public boolean retainAll(OurSet other) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new OurTreeSetIterator<>(this);
    }


    static class TreeNode<E> {

        TreeNode<E> left;
        TreeNode<E> right;
        TreeNode<E> parent;

        E key;

    }

}


class OurTreeSetIterator <E> implements Iterator<E>{

    private OurTreeSet<E> treeSet;
    private OurTreeSet.TreeNode<E> current;

    OurTreeSetIterator(OurTreeSet<E> treeSet) {
        this.treeSet=treeSet;
        this.current = treeSet.root==null? null: getLeast(treeSet.root);//getLeast accept element which != null
    }

    private OurTreeSet.TreeNode<E> getLeast(OurTreeSet.TreeNode<E> current) {
        while (current.left!=null)//спускаемся по левой части до самого конца
            current = current.left;

        return current;
    }

    @Override
    public boolean hasNext() {
        return current!=null;
    }

    @Override
    public E next() {
        E res = current.key;

        if(current.right!=null){
            current = getLeast(current.right);
        }else{
            current = firstRightParent(current);
        }

        return res;
    }

    /**
     * the method finds the first parent which is to the right from current
     * @param current element
     * @return next element by order if exists or null, if current is the most right element in the TreeSet
     */
    private OurTreeSet.TreeNode<E> firstRightParent(OurTreeSet.TreeNode<E> current) {
        OurTreeSet.TreeNode<E> parent = current.parent;

        while (parent!=null && parent.left!=current) {
            current = parent;
            parent = current.parent;
        }

        return parent;
    }
}
