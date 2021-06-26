package com.kulhade.programming.patterns;

import java.nio.channels.Channel;
import java.util.HashMap;
import java.util.Map;

public class SlidingWindow {

    /**
     * Smallest Sub array size for a given Sum
     */
    public int smallestSubArrSizeSum(int[] arr,int sum){
        if(arr==null || arr.length==0){
            return 0;
        }
        int start=0,end=0,minSize=Integer.MAX_VALUE,wSum=0;
        for(;end<arr.length;end++){
            wSum +=arr[end];
            while(wSum>=sum){
                wSum -= arr[start];
                minSize = Math.min(minSize,(end-start+1));
                start++;
            }
        }
        return minSize;
    }
    /**
     * Sliding Window Average
     */
    public float[] slidingWindowAvg(int[] input, int k){
        if(input==null || input.length==0){
            return null;
        }
        float[] result = new float[input.length-k+1];
        if(k==1){
            for(int i=0;i<input.length;i++){
                result[i]=input[i];
            }
            return result;
        }
        float sum=0;
        int i=0;
        for(;i<k;i++){
            sum+=input[i];
        }
        result[i-k]=sum/k;
        for(;i<input.length;i++){
            sum += input[i]-input[i-k];
            result[i-k+1]=sum/k;
        }
        return result;

    }

    /**
     * Longest Substring with K Distinct Characters (medium)
     */

    public int longestSubKDistChar(String s, int k){
        if(s==null || s.length()==0) return 0;
        int start=0,maxLength=Integer.MIN_VALUE;
        Map<Character, Integer> m = new HashMap<>();
        for(int end=0;end<s.length();end++){
            Character c = s.charAt(end);
            int count = m.getOrDefault(c,0);
            m.put(c,count+1);
            while(m.size()>k){
                Character cs = s.charAt(start);
                int cCount = m.get(cs);
                if(cCount==1){
                    m.remove(cs);
                }else {
                    m.put(cs, cCount - 1);
                }
                start++;
            }
            maxLength = Math.max(maxLength, end-start+1);
        }
        return maxLength;
    }

    /**
     * Fruits in the basket
     * https://leetcode.com/problems/fruit-into-baskets/
     */
    public int fruitsInBasket(int[] tree){
        if(tree==null || tree.length==0){
            return 0;
        }
        Map<Integer,Integer> m = new HashMap<>();
        int start=0,maxLength=Integer.MIN_VALUE;
        for(int end=0;end<tree.length;end++){
            int fCount = m.getOrDefault(tree[end],0);
            m.put(tree[end],fCount+1);
            while(m.size()>2){
                int count = m.get(tree[start]);
                if(count==1){
                    m.remove(tree[start]);
                }else{
                    m.put(tree[start],count-1);
                }
                start++;
            }
            maxLength = Math.max(maxLength,end-start+1);
        }
    return maxLength;
    }
    /**
     * Longest Substring with at most 2 distinct characters
     */
    public int longestSubAtMost2DistChar(String s){
        if(s==null || s.length()==0) return 0;
        int start=0,maxLength=Integer.MIN_VALUE;
        Map<Character,Integer> m = new HashMap();
        for(int end=0;end<s.length();end++){
            Character c = s.charAt(end);
            int cCount = m.getOrDefault(c,0);
            m.put(c,cCount+1);
            while(m.size()>2){
                int count = m.get(s.charAt(start));
                if(count==1){
                    m.remove(s.charAt(start));
                }else{
                    m.put(s.charAt(start),count-1);
                }
                start++;
            }
            maxLength = Math.max(maxLength,end-start+1);
        }
        return maxLength;
    }
    /**
     * Longest Substring Without Repeating Characters
     */
    public int longestSubNoRepeat(String s){
        if(s==null || s.length()==0) return 0;
        int start=0,maxLength=Integer.MIN_VALUE;
        Map<Character,Integer> m = new HashMap();
        for(int end=0;end<s.length();end++){
            Character c= s.charAt(end);
            int cCount = m.getOrDefault(c,0);
            m.put(c,cCount+1);
            while(m.get(c)>1){
                int count = m.get(s.charAt(start));
                m.put(s.charAt(start),count-1);
                start++;
            }
            maxLength = Math.max(maxLength,end-start+1);
        }
        return maxLength;
    }

    /**
     * Longest Repeating Substring after k Character Replacement
     * https://leetcode.com/problems/longest-repeating-character-replacement/
     */
    public int longestRepeatingCharSubStrOneReplace(String s,int k){
        if(s==null || s.length()==0) return 0;
        int maxLength=Integer.MIN_VALUE;
        return maxLength;
    }

    /**
     * Max Consecutive Ones with at most k flips
     * @param nums
     * @param k
     * @return
     */
    public int longestOnes(int[] nums, int k) {
        if(nums==null || nums.length==0) return 0;
        int start=0,maxLength=Integer.MIN_VALUE, maxRepeat = 0;

        for(int end=0;end<nums.length;end++){
            if(nums[end]==1)
                maxRepeat++;
            int curWin = end-start+1;
            if(curWin-maxRepeat>k){
                if(nums[start]==1)
                    maxRepeat--;
                start++;
            }
            maxLength = Math.max(maxLength,end-start+1);

        }
        return maxLength;
    }
    /**
     * Permutation available in String
     * s1 = dc
     * s2 = "odicf"
     */
    public boolean checkIfPermutationAvailable(String s1,String s2){
        if(s1==null || s1.length()==0) return false;
        if(s2==null || s2.length()==0) return false;
        Map<Character,Integer> m = new HashMap();
        int start=0;
        for(int i=0;i<s1.length();i++)
            m.put(s1.charAt(i),m.getOrDefault(s1.charAt(i),0)+1);
        int count=m.size();
        for(int end = 0;end<s2.length();end++){
            Character c = s2.charAt(end);
            if(m.get(c)!=null){
                m.put(c,m.get(c)-1);
                if(m.get(c)==0)
                    count--;
            }
            if(count==0) return true;

            if(end-start+1>=s1.length()){
                Character c1 = s2.charAt(start);
                if(m.get(c1)!=null){
                    if(m.get(c1)==0)
                        count++;
                    m.put(c1,m.get(c1)+1);
                }
                start++;
            }
        }
        return false;
    }
}
