package com.kulhade.programming.simple;

//A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.
//
//        Given a list of stones positions (in units) in sorted ascending order, determine if the frog can cross the river by landing on the last stone. Initially, the frog is on the first stone and assumes the first jump must be 1 unit.
//
//        If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only jump in the forward direction.
//
//        Example 1:
//
//        Input: stones = [0,1,3,5,6,8,12,17]
//        [1,2,3,4,5,6, 7, 8]
//
//        k = 0          0
//        k = K + 1 = 1  1
//        k = k + 1 = 2. 3
//        k = k     = 2. 5    k = k + 1 = 3. 6
//        k = K + 1 = 3  8    k = K + 1 = 4  //return
//        k = k + 1 = 4  12
//        k = k + 1 = 5  17
//
//
//        prev jump = 0
//
//        Output: true
//        Explanation: The frog can jump to the last stone by jumping 1 unit to the 2nd stone, then 2 units to the 3rd stone, then 2 units to the 4th stone, then 3 units to the 6th stone, 4 units to the 7th stone, and 5 units to the 8th stone.
//
//        Example 2:
//
//        Input: stones = [0,1,2,3,4,8,9,11]
//        Output: false
//        Explanation: There is no way to jump to the last stone as the gap between the 5th and 6th stone is too large.
//
//
//        Constraints:
//
//        2 <= stones.length <= 2000
//        0 <= stones[i] <= 231 - 1
//        stones[0] == 0
//        stones is sorted in a strictly increasing order.

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canCross(int[] stones) {
        if(stones.length==0) return false;
        // [0,1,3,5,6,8,12,17]
        Map<Integer,Integer> aMap = new HashMap<>();
        for(int i=0;i<stones.length;i++){
            aMap.put(stones[i],i);
        }
        return canCrossHelper(stones, 0,0,aMap);

    }

    public boolean canCrossHelper(int[] stones, int idx, int k, Map<Integer,Integer> aMap){
        if(idx==stones.length-1){
            return true;
        }
        boolean isPossible = false;
        int currPos=  stones[idx];
       for(int next_k=k-1;next_k<=k+1;next_k++){
           if(next_k>0) {
               int next_stone = currPos + next_k;
               if (aMap.containsKey(next_stone) ) {
                   if(!isPossible)
                       isPossible = canCrossHelper(stones, aMap.get(next_stone), next_k, aMap);
                   else
                       return true;
               }
           }
       }
        return isPossible;
    }

        public int minEatingSpeed(int[] piles, int h) {
            int min = 0;
            int max = Integer.MIN_VALUE;

            for(int i:piles){
                // min = Math.min(min,i);/
                max = Math.max(max,i);
            }
            if(h==piles.length){
                return max;
            }
            int speed = Integer.MAX_VALUE;
            while(min<=max){
                int mid = min+(max-min)/2;
                if(ttf(mid,piles)<=h){
                    speed = mid;
                    max = mid-1;
                }else{
                    min = mid+1;
                }
            }
            return speed;
        }

        public int ttf(int speed, int[] piles){
            int tt = 0;
            for(int i:piles){
                tt+= (int)Math.ceil(i*1.0/speed);
            }
            return tt;
        }
}