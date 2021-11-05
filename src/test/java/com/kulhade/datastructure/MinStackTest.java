package com.kulhade.datastructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MinStackTest {

    static MinStack minStack;
    @BeforeAll
    static void setup(){
        minStack = new MinStack();
    }

    @Test
    public void testMinStack(){
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        Assertions.assertEquals(-1024,minStack.getMin());
        minStack.pop();
        Assertions.assertEquals(-1024,minStack.getMin());
        minStack.pop();
        Assertions.assertEquals(512,minStack.getMin());
    }
}
