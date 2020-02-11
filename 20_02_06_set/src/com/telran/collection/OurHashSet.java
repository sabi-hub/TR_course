package com.telran.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class OurHashSet<E> implements OurSet<E> {

    private final static Object INSTANCE = new Object();
    private Map<E, Object> source;

    public OurHashSet() {
        this.source = new HashMap<>();
    }

    @Override
    public boolean add(E e) {
        return source.put(e, INSTANCE) == null;
    }

    @Override
    public boolean remove(E e) {
        return source.remove(e) != null;
    }

    @Override
    public boolean contains(E e) {
        return source.containsKey(e);
    }

    @Override
    public int size() {
        return source.size();
    }

    @Override
    public boolean addAll(OurSet<E> other) {
//        OurHashSet<E> narrowedOther = (OurHashSet<E>) other;

        boolean res = false;
        for (E e : other) {
            res |= this.add(e);
//            res = this.add(e)|res;
        }
        return res;
    }

    @Override
    public boolean removeAll(OurSet<E> other) {

        boolean res = false;
        for (E e : other) {
            res |= this.remove(e);
        }

        return res;
    }

    @Override
    public boolean retainAll(OurSet<E> other) {
//        Iterator<E> iterator = this.iterator();
//
//        boolean res = false;
//        while(iterator.hasNext()){
//            E e = iterator.next();
//
//            if(!other.contains(e)){
//                iterator.remove();
//                res = true;
//            }
//        }



        OurSet<E> temp = new OurHashSet<>();

        for(E e:this){
            if(!other.contains(e))
                temp.add(e);
        }

        return this.removeAll((temp));

//        boolean res = false;

//        for (E e : this) {
//            if (this.contains(e)) {
//                temp.add(e);
//            }
//        }
//        this.source.clear();
//
//        for(E q:temp.source.keySet()){
//            this.add(q);
//        }
//        if (this.size() > 0)
//            res = true;

//        return res;
    }

    @Override
    public Iterator<E> iterator() {
        return source.keySet().iterator();

//        return new Iterator<E>() {
//            @Override
//            public boolean hasNext() {
//                return false;
//            }
//
//            @Override
//            public E next() {
//                return null;
//            }
//        };
    }
}

