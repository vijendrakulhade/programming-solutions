package com.kulhade.programming.entity;

/**
 * Created by vn05f93 on 3/13/18.
 * Class for merge list program
 * @param <T>
 */
public class Interval<T extends Comparable<T>>{
    private T start;
    private T end;
    public Interval(T start,T end){
        this.start=start;
        this.end=end;
    }

    public T getStart() {
        return start;
    }

    public void setStart(T start) {
        this.start = start;
    }

    public T getEnd() {
        return end;
    }

    public void setEnd(T end) {
        this.end = end;
    }
}
