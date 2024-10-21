package com.kulhade.programming.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {

    Solution sol = new Solution();
    @Test
    public void testCanCross(){
        int[] stones = {0,1,3,5,6,8,12,17};
        Assertions.assertTrue(sol.canCross(stones));
    }

    @Test
    public void testMinEatingSpeed(){
        int[] piles = {3,6,7,11};
        Assertions.assertEquals(2,sol.minEatingSpeed(piles,18));

    }
}
