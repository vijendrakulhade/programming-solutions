package com.kulhade.programming.simple;

import java.util.PriorityQueue;

/**
 * PriorityQueue is the java implementation of heap
 * Default priority queue with default constructor creates min heap
 * To create max heap we should provide a comparator to reverse the order
 */
public class PriorityQueuePrograms {


    public int[] heapSort(int[] nums){
        if(nums==null || nums.length==0) return null;
        int n = nums.length;
        PriorityQueue<Integer> heap = new PriorityQueue<>(n);
        for(Integer i:nums){
            heap.offer(i);
        }
        int index = 0;
        while(!heap.isEmpty()){
            nums[index++]=heap.poll();
        }
        return nums;
    }
}
