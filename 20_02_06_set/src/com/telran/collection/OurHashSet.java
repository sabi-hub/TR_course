package com.telran.collection;

import java.util.HashMap;
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
        OurHashSet<E> narrowedOther = (OurHashSet<E>) other;

        boolean res = false;
        for (E e : narrowedOther.source.keySet()) {
            res |= this.add(e);
//            res = this.add(e)|res;
        }
        return res;
    }

    @Override
    public boolean removeAll(OurSet<E> other) {
        OurHashSet<E> narrowedOther = (OurHashSet<E>) other;

        boolean res = false;
        for (E e : narrowedOther.source.keySet()) {
            res |= this.remove(e);
        }

        return res;
    }

    @Override
    public boolean retainAll(OurSet<E> other) {
        OurHashSet<E> narrowedOther = (OurHashSet<E>) other;
        OurHashSet<E> temp = new OurHashSet<>();

        boolean res = false;

        for (E e : narrowedOther.source.keySet()) {
            if (this.contains(e)) {
                temp.add(e);
            }
        }
        this.source.clear();

        for(E q:temp.source.keySet()){
            this.add(q);
        }
        if (this.size() > 0)
            res = true;

        return res;
    }
}
