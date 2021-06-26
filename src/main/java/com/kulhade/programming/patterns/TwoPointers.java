package com.kulhade.programming.patterns;

import java.util.*;

/**
 * Class has some problems for two pointer approach
 */
public class TwoPointers {

    /**
     * Two Sum
     * Fnd the pair with the given sum in the given array
     */
    public List<Pair> twoSum(int[] nums,int sum){
        if(nums==null || nums.length==0) return null;
        Map<Integer,Integer> m = new HashMap<Integer,Integer>();
        List<Pair> result = new ArrayList();
        for(int i=0;i<nums.length;i++){
            if(m.get(sum-nums[i])!=null){
                Pair p = new Pair(i,m.get(sum-nums[i]));
                result.add(p);
            }else{
                m.put(nums[i],i);
            }
        }
        return result;
    }

    /**
     * ThreeSum
     * Find the triplet with Sum 0 in the given array
     * Trick here is we can not pass the same array, once we pick an element from array that should not be in Pair
     * So in @twoSum we need to pass the index as well which can exclude that index from the array
     */
    public List<Triplet> threeSum(int[] nums){
        List<Triplet> result = new ArrayList();
        if(nums==null || nums.length==0) return result;
        for(int i=0;i<nums.length;i++){
            List<Pair> pairs = twoSumExcludingIdx(nums,0-nums[i],i);
            if(pairs!=null && pairs.size()>0){
                for(Pair p:pairs) {
                    Triplet triplet = new Triplet(p, i);
                    result.add(triplet);
                }
            }
        }
        return result;
    }

    private List<Pair> twoSumExcludingIdx(int[] nums,int sum, int index){
        if(nums==null || nums.length==0) return null;
        Map<Integer,Integer> m = new HashMap();
        List<Pair> result = new ArrayList();
        for(int i=0;i<nums.length;i++){
            if(i==index)continue; //excluding the index
            if(m.get(sum-nums[i])!=null){
                Pair p = new Pair(i,m.get(sum-nums[i]));
                result.add(p);
            }else{
                m.put(nums[i],i);
            }
        }
        return result;
    }

    /**
     * Remove duplicates from the list provided inline object in the list should have equals and hashcode
     * {1,1,2,2,3,3,3} --> {1,2,3}
     *
     */
    public <S> List<S> removeDuplicates(List<S> input){
        if(input==null || input.size()==0) return input;
        int j=0;
        for(int i=0;i<input.size();i++){
            if(!input.get(i).equals(input.get(j))){
                j++;
                input.set(j,input.get(i));
            }
        }
        List<S> result = new ArrayList();
        for(int i=0;i<=j;i++){
            result.add(input.get(i));
        }
        return result;
    }

    /**
     * Remove given from the list
     */
    public <S> List<S> removeElement(List<S> input,S e){
        if(input==null || input.size()==0) return input;
        int j=0;
        for(int i=0;i<input.size();i++){
            if(!input.get(i).equals(e)){
                input.set(j,input.get(i));
                j++;
            }
        }
        List<S> result = new ArrayList();
        for(int i=0;i<j;i++){
            result.add(input.get(i));
        }
        return result;
    }

    /**
     * Pair Class
     * @param <R>
     * @param <S>
     */
    public static class Pair<R,S>{
        private R r;
        private S s;
        public Pair(R r,S s){
            this.r=r;
            this.s=s;
        }
        public int hashCode(){
            return r.hashCode()+s.hashCode();
        }
        public boolean equals(Object o){
            Pair p = (Pair) o;
            if(p.r instanceof Integer && p.s instanceof Integer) {
                int[] arr = new int[2];
                arr[0] = (Integer) p.r;
                arr[1] = (Integer) p.s;
                Arrays.sort(arr);
                int[] arr2 = new int[2];
                arr2[0] = (Integer) this.r;
                arr2[1] = (Integer) this.s;
                Arrays.sort(arr2);
                return arr.equals(arr2);
            }
            return (p.r.equals(this.r) && p.s.equals(this.s));
        }

    }

    /**
     * Class to hold the Triplet
     * @param <T>
     * @param <T>
     * @param <T>
     */
    public static class Triplet<R,S,T>{
        private R r;
        private S s;
        private T t;
        public Triplet(R r,S s,T t){
            this.r=r;
            this.s=s;
            this.t=t;
        }
        public Triplet(Pair<R,S> p,T t){
            this.r=p.r;
            this.s=p.s;
            this.t=t;
        }
        public int hashCode(){
            return r.hashCode()+s.hashCode()+t.hashCode();
        }
        public boolean equals(Object o){
            Triplet t = (Triplet) o;
            if(t.r instanceof Integer && t.s instanceof Integer && t.t instanceof Integer) {
                int[] arr = new int[3];
                arr[0] = (Integer) t.r;
                arr[1] = (Integer) t.s;
                arr[2] = (Integer) t.t;
                Arrays.sort(arr);
                int[] arr2 = new int[3];
                arr2[0] = (Integer) this.r;
                arr2[1] = (Integer) this.s;
                arr2[2] = (Integer) this.t;
                Arrays.sort(arr2);
                return arr.equals(arr2);
            }
            return (t.r.equals(this.r) && t.s.equals(this.s) && t.t.equals(this.t));
        }
    }
}
