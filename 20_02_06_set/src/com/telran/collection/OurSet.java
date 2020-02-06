package com.telran.collection;

public interface OurSet<E> {

    /**
     * adds a new element to the set
     * @param e to add
     * @return true if the set was changed
     */
    boolean add(E e);

    /**
     * removes the element from the set
     * @param e to remove
     * @return true if the set was changed
     */
    boolean remove(E e);

    /**
     * determines whether the element is in the set
     * @param e to find
     * @return true if the set contains is element
     */
    boolean contains (E e);

    int size();

    /**
     * adds all elements from the other to this set
     * @param other elements of whom to be added
     * @return true if the set was changed
     */
    boolean addAll(OurSet<E> other);

    /**
     * removes all elements appearing in the other from this set
     * @param other elements of whom to be removed
     * @return true if the set was changed
     */
    boolean removeAll(OurSet<E> other);

    /**
     * retains all the elements appearing in the both this and the other sets
     * @param other elements of whom appearing also in this set, to be retaind
     * @return true if the set was changed
     */
    boolean retainAll(OurSet<E>other);


}
