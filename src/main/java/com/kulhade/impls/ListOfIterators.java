package com.kulhade.impls;

import java.util.Iterator;

/**
 * Created by vn05f93 on 10/8/17.
 */
public class ListOfIterators<T> implements Iterator<T> {
    private  Iterator<Iterator<T>> listOfIterators;
    private Iterator<T> currentIterator;

    public ListOfIterators(Iterator<Iterator<T>> iteratorIterator){
        this.listOfIterators = iteratorIterator;
        this.currentIterator=listOfIterators.next();
    }

    public boolean hasNext() {
        if(!currentIterator.hasNext()){
            if(!listOfIterators.hasNext()){
                return false;
            }
            currentIterator = listOfIterators.next();
            hasNext();
        }
        return true;
    }

    public T next() {
        hasNext();
        return currentIterator.next();
    }

    public void remove() {
        hasNext();
        currentIterator.remove();
    }
}
