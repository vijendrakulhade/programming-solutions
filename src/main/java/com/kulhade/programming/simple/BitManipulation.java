package com.kulhade.programming.simple;

public class BitManipulation {

    /**
     * Simple bitwise operator
     */
    public int xor(int a,int b){
        return a^b;
    }

    /**
     * Get Sum of 2 numbers without using + Operator
     */
    public int getSum(int a,int b){
        if(a==0 || a>Integer.MAX_VALUE || a<Integer.MIN_VALUE) return b;
        if(b==0 || b>Integer.MAX_VALUE || b<Integer.MIN_VALUE) return a;
        int c = a^b;
        int d = (a&b)<<1;
        return getSum(c,d);
    }
}
