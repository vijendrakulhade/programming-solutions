package com.kulhade.programming.simple;


import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vn05f93 on 10/7/17.
 */
public class DynamicProgrammingTest {

    private static DynamicProgramming dynamicProgramming = null;

    @BeforeAll
    public static void setUp() {
        dynamicProgramming = new DynamicProgramming();
    }


    @Test
    public void testFibonacciSeries() {
        int[] expected = {0, 1, 1, 2, 3};
        int[] series = dynamicProgramming.fibonacciSeries(5);
        Assertions.assertArrayEquals(expected, series);

    }

    @Test
    public void testFindWaysToMakeChange(){
        int[] coins = {25,10,5,1};
        int money = 27;
        int ways = dynamicProgramming.findWaysToMakeChange(coins,money);
        Assertions.assertEquals(ways,13);
    }

    @Test
    public void testFindWaysToMakeChange_1(){
        int[] coins = {5,2,1};
        int money = 7;
        int ways = dynamicProgramming.findWaysToMakeChange(coins,money);
        Assertions.assertEquals(6,ways);
    }

    @Test
    public void testFindWaysToMakeChange_2(){
        int[] coins = {3,2,1};
        int money = 4;
        int ways = dynamicProgramming.findWaysToMakeChange(coins,money);
        Assertions.assertEquals(4,ways);
    }

    @Test
    public void testFindWaysToMakeChange_3(){
        int[] coins = {2,3,6};
        int money = 7;
        int ways = dynamicProgramming.findWaysToMakeChange(coins,money);
        Assertions.assertEquals(1,ways);
    }

    @Test
    public void testFindWaysToMakeChangeNoRecursion(){
        int[] coins = {25,10,5,1};
        int money = 27;
        int ways = dynamicProgramming.findWaysToMakeChange(coins,money);
        Assertions.assertEquals(ways,13);
    }

    @Test
    public void testFindWaysToMakeChangeNoRecursion_1(){
        int[] coins = {1,2,5};
        int money = 5;
        int ways = dynamicProgramming.findWaysToMakeChange(coins,money);
        Assertions.assertEquals(4,ways);
    }

    @Test
    public void testFindWaysToMakeChangeNoRecursion_2(){
        int[] coins = {3,2,1};
        int money = 4;
        int ways = dynamicProgramming.findWaysToMakeChange(coins,money);
        Assertions.assertEquals(4,ways);
    }

    @Test
    public void testShowMoneyChangeCombinations(){
        int[] coins = {5,2,1};
        int money = 7;
        List<List<Integer>> actual =  dynamicProgramming.showMoneyChangeCombinations(coins,money);
        Assertions.assertEquals(13,actual.size());
    }

    @Test
    public void testFindAllPossibleChangeForMoney(){
        int[] coins = {2,3,6};
        int money = 7;
        List<List<Integer>> actual =  dynamicProgramming.findAllPossibleChangeForMoney(coins,money);
        List<Integer> curr = Arrays.asList(2,2,3);
        Assertions.assertArrayEquals(curr.toArray(),actual.get(0).toArray());
    }
    @Test
    public void testFindAllPossibleChangeForMoney_1(){
        int[] coins = {1,2,5};
        int money = 7;
        List<List<Integer>> actual =  dynamicProgramming.findAllPossibleChangeForMoney(coins,money);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1,1,1,1,1,1,1));
        expected.add(Arrays.asList(1,1,1,1,1,2));
        expected.add(Arrays.asList(1,1,1,2,2));
        expected.add(Arrays.asList(1,1,5));
        expected.add(Arrays.asList(1,2,2,2));
        expected.add(Arrays.asList(2,5));
        Assertions.assertArrayEquals(expected.toArray(),actual.toArray());
    }

    @Test
    public void testLongestCommonSubsequence(){
        String str1="AGGTXB"; String str2="GTXAYB";
        int num = dynamicProgramming.longestCommonSubsequence(str1,str2);
        Assertions.assertEquals(4,num);
    }

    @Test
    public void testLongestCommonSubsequenceIter(){
        String str1="AGGTXB"; String str2="GTXAYB";
        int num = dynamicProgramming.longestCommonSubsequenceIterative(str1,str2);
        Assertions.assertEquals(4,num);
    }
    @Test
    public void testDistinctCommonSubsequence(){
        String str1="rabbbit"; String str2="rabbit";
        int num = dynamicProgramming.distinctCommonSubSequence(str1,str2);
        Assertions.assertEquals(3,num);
    }

    @Test
    public void testDistinctCommonSubsequence_1(){
        String str1="rabbbit"; String str2="rabbit";
        int num = dynamicProgramming.distinctCommonSubSequenceIterative(str1,str2);
        Assertions.assertEquals(3,num);
    }

    @Test
    public void testSubStringsKDist(){
        String str = "abcd"; int k=3;
        List<String> out = dynamicProgramming.subStringsKDist(str,k);
        System.out.print(out);
    }

    @Test
    public void testSubStringsKDist2(){
        String str = "awaglknagawunagwkwagl"; int k=4;
        List<String> out = dynamicProgramming.subStringsKDist(str,k);
        System.out.print(out);
    }

    @Test
    public void testCountDist(){
        String str = "abcd"; int k=3;
        int out = dynamicProgramming.countkDist(str,k);
        Assertions.assertEquals(out,2);
    }

    @Test
    public void testMinEditDistance(){
        int out  = dynamicProgramming.minEditDistance("saturday","sunday");
        Assertions.assertEquals(out,3);
    }

    @Test
    public void testMinEditDistanceIter(){
        int out  = dynamicProgramming.minEditDistanceIterative("saturday","sunday");
        Assertions.assertEquals(3,out);
    }

    @Test
    public void testMinEditDistance_2(){
        int out  = dynamicProgramming.minEditDistance("rabbbit","rabbit");
        Assertions.assertEquals(1,out);
    }

    @Test
    public void testMinEditDistanceABC(){
        int out  = dynamicProgramming.minEditDistance("ABC","BCA");
        Assertions.assertEquals(out,2);
    }

    @Test
    public void testJava(){
        String str1="";
        Assertions.assertEquals(0,str1.length());
    }

    @Test
    public void testSuper_reduced_string(){
        Assertions.assertSame("abcd",dynamicProgramming.super_reduced_string("aaabccddd").intern());
    }

    @Test
    public void  testIsPatternMatch(){
        Assertions.assertTrue(dynamicProgramming.isPatternMatch("aaa","a*"));
    }

    @Test
    public void  testIsPatternMatch_Neg(){
        Assertions.assertFalse(dynamicProgramming.isPatternMatch("aaa","."));
    }

    @Test
    public void testLongestIncreasingSubsequence(){
        int[] arr = {3,4,2,8,10,5,1};
        Assertions.assertEquals(4,dynamicProgramming.lis(arr));
    }
    @Test
    public void testMakeCut_0(){
        Assertions.assertEquals(5,dynamicProgramming.makeCut(5,2,1,5));
    }
    @Test
    public void testMakeCut_1(){
        Assertions.assertEquals(2,dynamicProgramming.makeCut(23,11,12,13));
    }

    @Test
    public void testMakeCutMemo_0(){
        Assertions.assertEquals(5,dynamicProgramming.makeCutMemo(5,2,1,5));
    }
    @Test
    public void testMakeCutMemo_1(){
        Assertions.assertEquals(2,dynamicProgramming.makeCutMemo(23,11,12,13));
    }

    @Test
    public void testMakeCutTabulation_0(){
        Assertions.assertEquals(5,dynamicProgramming.makeCutTabulation(5,2,1,5));
    }
    @Test
    public void testMakeCutTabulation_1(){
        Assertions.assertEquals(2,dynamicProgramming.makeCutTabulation(23,11,12,13));
    }



}
