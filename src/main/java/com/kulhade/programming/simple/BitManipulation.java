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

    /**
     * Find Non repeating Single number, where other numbers are present exactly twice in the array
     */
    public int getNonRepeating(int[] nums){
        if(nums==null || nums.length==0) return -1;
        int a = nums[0];
        for(int i=1;i<nums.length;i++){
            a = a ^ nums[i];
        }

        return a;
    }


}
