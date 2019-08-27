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

    /**
     * Merge k sorted arrays
     */
    class ArrayContainer implements Comparable{
        private int[] arr;
        private int index;
        public ArrayContainer(int[] a,int index){
            this.arr=a;
            this.index=index;
        }
        @Override
        public int compareTo(Object o) {
            ArrayContainer a = (ArrayContainer)o;
            return this.arr[this.index]-a.arr[a.index];
        }

        public int[] getArr() {
            return arr;
        }

        public void setArr(int[] arr) {
            this.arr = arr;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }
    public int[] mergeKSortedArray(int[][] arrays){
        if(arrays==null || arrays.length==0)
            return new int[0];

        PriorityQueue<ArrayContainer> q = new PriorityQueue<>();
        int total= 0;
        for(int[] a:arrays){
            total +=a.length;
            q.offer(new ArrayContainer(a,0));
        }
        int[] result = new int[total];
        int i=0;
        while(!q.isEmpty()){
            ArrayContainer c = q.poll();
            result[i++] = c.arr[c.index];
            if(c.index < c.arr.length-1)
                q.offer(new ArrayContainer(c.arr,c.index+1));
        }
        return result;
    }
}
