package com.kulhade.programming.simple;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;
import java.util.Scanner;

/**
 * Created by vn05f93 on 10/7/17.
 */
@RunWith(JUnit4.class)
public class DynamicProgrammingTest {

    private static DynamicProgramming dynamicProgramming = null;

    @BeforeClass
    public static void setUp() {
        dynamicProgramming = new DynamicProgramming();
    }


    @Test
    public void testFibonacciSeries() {
        int[] expected = {0, 1, 1, 2, 3};
        int[] series = dynamicProgramming.fibonacciSeries(5);
        Assert.assertArrayEquals(expected, series);

    }

    @Test
    public void testFindWaysToMakeChange(){
        int[] coins = {25,10,5,1};
        int money = 27;
        int ways = dynamicProgramming.findWaysToMakeChange(coins,money);
        Assert.assertEquals(ways,13);
    }

    @Test
    public void testFindWaysToMakeChange_1(){
        int[] coins = {5,2,1};
        int money = 12;
        int ways = dynamicProgramming.findWaysToMakeChange(coins,money);
        Assert.assertEquals(13,ways);
    }

    @Test
    public void testFindWaysToMakeChange_2(){
        int[] coins = {3,2,1};
        int money = 4;
        int ways = dynamicProgramming.findWaysToMakeChange(coins,money);
        Assert.assertEquals(4,ways);
    }


    @Test
    public void testFindWaysToMakeChangeNoRecursion(){
        int[] coins = {25,10,5,1};
        int money = 27;
        int ways = dynamicProgramming.findWaysToMakeChange(coins,money);
        Assert.assertEquals(ways,13);
    }

    @Test
    public void testFindWaysToMakeChangeNoRecursion_1(){
        int[] coins = {5,2,1};
        int money = 12;
        int ways = dynamicProgramming.findWaysToMakeChange(coins,money);
        Assert.assertEquals(13,ways);
    }

    @Test
    public void testFindWaysToMakeChangeNoRecursion_2(){
        int[] coins = {3,2,1};
        int money = 4;
        int ways = dynamicProgramming.findWaysToMakeChange(coins,money);
        Assert.assertEquals(4,ways);
    }

    @Test
    public void testLongestCommonSubsequence(){
        String str1="AGGTXB"; String str2="GTXAYB";
        int num = dynamicProgramming.longestCommonSubsequence(str1,str2);
        Assert.assertEquals(4,num);
    }

    @Test
    public void testSubStringsKDist(){
        String str = "abcd"; int k=3;
        List<String> out = dynamicProgramming.subStringsKDist(str,k);
    }

    @Test
    public void testSubStringsKDist2(){
        String str = "awaglknagawunagwkwagl"; int k=4;
        List<String> out = dynamicProgramming.subStringsKDist(str,k);
    }

    @Test
    public void testCountDist(){
        String str = "abcd"; int k=3;
        int out = dynamicProgramming.countkDist(str,k);
        Assert.assertEquals(out,2);
    }

    @Test
    public void testMinEditDistance(){
        int out  = dynamicProgramming.minEditDistance("sunday","saturday");
        Assert.assertEquals(out,3);
    }

    @Test
    public void testMinEditDistanceABC(){
        int out  = dynamicProgramming.minEditDistance("ABC","BCA");
        Assert.assertEquals(out,2);
    }

    @Test
    public void testJava(){
        String str1="";
        Assert.assertEquals(0,str1.length());
    }

    @Test
    public void testSuper_reduced_string(){
        Assert.assertSame("abcd",dynamicProgramming.super_reduced_string("aaabccddd").intern());
    }

    @Test
    public void  testIsPatternMatch(){
        Assert.assertTrue(dynamicProgramming.isPatternMatch("aaa","a*"));
    }

    @Test
    public void  testIsPatternMatch_Neg(){
        Assert.assertFalse(dynamicProgramming.isPatternMatch("aaa","."));
    }

}
