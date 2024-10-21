package com.kulhade.programming.simple;

import java.util.*;

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

    public int lastStoneWeight(int[] stones) {
        if(stones==null || stones.length==0) return 0;
        PriorityQueue<Integer> heap = new PriorityQueue(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++){
            heap.add(stones[i]);
        }
        while(heap.size()>1){
            int x = heap.poll();
            int y = heap.poll();
            if(x==y) continue;
            if(x>y){
                x = x-y;
                heap.add(x);
            }
        }

        return heap.size()==1?heap.poll():0;
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        Comparator<Map.Entry<Integer,Integer>> comp = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue() < o2.getValue()){
                    return 1;
                }else{
                    return -1;
                }
            }
        };
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(comp);

        for(int n:nums){
            if(m.containsKey(n)){
                m.put(n,m.get(n)+1);
            }else{
                m.put(n,1);
            }
        }
        pq.addAll(m.entrySet());
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = pq.poll().getKey();
        }

        return res;
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
//        {3,2,1,5,6,4};
        for(int n:nums){
            if(pq.size()<k){
                pq.add(n);
            }
            if(!pq.isEmpty() && pq.size()==k && (int)pq.peek()<n){
                System.out.println(pq.poll()); //3
                pq.add(n);
            }
             //[3,2,1
        }
        System.out.println(pq);
        return pq.peek();

    }

    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> head = new PriorityQueue<>();
        PriorityQueue<Integer> tail = new PriorityQueue<>();
        int i=0;
        int j=costs.length-1;
        while(i<candidates){
            head.add(costs[i]);
            i+=1;
        }
        while(j>=costs.length-candidates){
            tail.add(costs[j]);
            j-=1;
        }
        int sum=0;
        while(k>0){
            if(tail.isEmpty() || !head.isEmpty() && head.peek()<= tail.peek()){
                sum+=head.remove();
                if(i<=j){
                    head.add(costs[i]);
                    i+=1;
                }
            }else{
                sum+=tail.remove();
                if(i<=j){
                    tail.add(costs[j]);
                    j-=1;
                }

            }
            k-=1;
        }
        return sum;
    }

}
