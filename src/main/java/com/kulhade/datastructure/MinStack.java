package com.kulhade.datastructure;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

    /** initialize your data structure here. */
    Deque<Integer> main;
    Deque<Integer> min;
    public MinStack() {
        main = new ArrayDeque();
        min = new ArrayDeque();
    }

    public void push(int x) {
        if(main.isEmpty()) {
            min.push(x);
            main.push(x);
            return;
        }
        main.push(x);
        if(min.peek().intValue()>=main.peek().intValue()){
            min.push(x);
        }
    }

    public void pop() {
        if(min.peek().intValue()==main.peek().intValue()){
            min.pop();
        }
        main.pop();
    }

    public int top() {
        return main.peek();
    }

    public int getMin() {
        return min.peek();
    }
}