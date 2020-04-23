package com.kulhade.programming.simple;


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
        int ways = dynamicProgramming.findWaysToMakeChangeNoRecursion(coins,money);
        Assertions.assertEquals(13,ways);
    }

    @Test
    public void testFindWaysToMakeChangeNoRecursion_1(){
        int[] coins = {1,2,3};
        int money = 3;
        int ways = dynamicProgramming.findWaysToMakeChangeNoRecursion(coins,money);
        Assertions.assertEquals(3,ways);
    }

    @Test
    public void testFindWaysToMakeChangeNoRecursion_2(){
        int[] coins = {3,2,1};
        int money = 4;
        int ways = dynamicProgramming.findWaysToMakeChangeNoRecursion(coins,money);
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
    public void testDistinctCommonSubsequence_0(){
        String str1="rabbbit"; String str2="rabbit";
        int num = dynamicProgramming.distinctCommonSubSequence(str1,str2,str1.length(),str2.length());
        Assertions.assertEquals(3,num);
    }

    @Test
    public void testDistinctCommonSubsequence_1(){
        String str1="rabbbit"; String str2="rabbit";
        int num = dynamicProgramming.distinctCommonSubSequenceIterative(str1,str2);
        Assertions.assertEquals(3,num);
    }

    @Test
    public void testDistinctCommonSubsequence_2(){
        String str1="banana"; String str2="ban";
        int num = dynamicProgramming.distinctCommonSubSequenceIterative(str1,str2);
        Assertions.assertEquals(3,num);
    }

    @Test
    public void testDistinctCommonSubsequence_3(){
        String str1="geeksforgeeks"; String str2="ge";
        int num = dynamicProgramming.distinctCommonSubSequenceIterative(str1,str2);
        Assertions.assertEquals(6,num);
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
    public void testLis(){
        int[] arr = {-2,-1};
        Assertions.assertEquals(2,dynamicProgramming.lis(arr));
    }

    @Test
    public void testLis_0(){
        int[] arr = {-2,-1};
        Assertions.assertEquals(2,dynamicProgramming.lisOn(arr));
    }

    @Test
    public void testLis_1(){
        int[] arr = {-1,-2,-3,-4,-5,-6};
        Assertions.assertEquals(1,dynamicProgramming.lisOn(arr));
    }

    @Test
    public void testLis_2(){
        int[] arr = {10,9,2,5,3,7,101,18};
        Assertions.assertEquals(4,dynamicProgramming.lisOn(arr));
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

    @Test
    public void testMinCoinSimpleRec(){
        int[] coins = {25,10,5};
        Assertions.assertEquals(2,dynamicProgramming.minCoins(coins,30));
    }

    @Test
    public void testMinCoinMemo(){
        int[] coins = {25,10,5};
        Assertions.assertEquals(2,dynamicProgramming.minCoinsMemo(coins,30));
    }
    @Test
    public void testMinCoinsTabulation(){
        int[] coins = {25,10,5};
        Assertions.assertEquals(2,dynamicProgramming.minCoinsTabulation(coins,30));
    }

    @Test
    public void testMinJumpRec_0(){
        int[] arr = {3,4,2,1,2,1};
        Assertions.assertEquals(2,dynamicProgramming.minJump(arr,0));
    }
    @Test
    public void testMinJumpRec_1(){
        int[] arr = {3,0,0,1,2,1};
        Assertions.assertEquals(3,dynamicProgramming.minJump(arr,0));
    }

    @Test
    public void testMinJumpTabulation_0(){
        int[] arr = {3,4,2,1,2,1};
        Assertions.assertEquals(2,dynamicProgramming.minJumpTabulation(arr));
    }
    @Test
    public void testMinJumpTabulation_1(){
        int[] arr = {3,0,0,1,2,1};
        Assertions.assertEquals(3,dynamicProgramming.minJumpTabulation(arr));
    }

    @Test
    public void testKnapsackRec(){
        int[] v = {1,2,10,12,4};
        int[] w = {1,1,12,4,8};
        Assertions.assertEquals(19,dynamicProgramming.knapsackRec(v,w,15,5));
    }

    @Test
    public void testKnapsackMemo(){
        int[] v = {1,2,10,12,4};
        int[] w = {1,1,12,4,8};
        Assertions.assertEquals(19,dynamicProgramming.knapsackMemo(v,w,15,5));
    }

    @Test
    public void testKnapsackTabulation(){
        int[] v = {1,2,10,12,4};
        int[] w = {1,1,12,4,8};
        Assertions.assertEquals(19,dynamicProgramming.knapsackTabulation(v,w,15,5));
    }

    @Test
    public void testPickPointRex(){
        int[] arr={25,5,4,6};
        Assertions.assertEquals(30,dynamicProgramming.pickPointRec(arr,0,3));
    }

    @Test
    public void testPickPointMemo(){
        int[] arr={25,5,4,6};
        Assertions.assertEquals(30,dynamicProgramming.pickPointMemo(arr));
    }

    @Test
    public void testPickPointTabulation(){
        int[] arr={25,5,4,6};
        Assertions.assertEquals(30,dynamicProgramming.pickPointTabulation(arr));
    }

    @Test
    public void testPickPointRex_1(){
        int[] arr={20,5,4,6,8,3};
        Assertions.assertEquals(32,dynamicProgramming.pickPointRec(arr,0,arr.length-1));
    }

    @Test
    public void testPickPointMemo_1(){
        int[] arr={20,5,4,6,8,3};
        Assertions.assertEquals(32,dynamicProgramming.pickPointMemo(arr));
    }

    @Test
    public void testPickPointTabulation_1(){
        int[] arr={20,5,4,6,8,3};
        Assertions.assertEquals(32,dynamicProgramming.pickPointTabulation(arr));
    }

    @Test
    public void testLongestBiTonicSubSeq_0(){
        int[] arr = {1,11,2,10,4,5,2,1};
        Assertions.assertEquals(6,dynamicProgramming.longestBiTonicSubSeq(arr));
    }

    @Test
    public void testEddDropRec(){
        Assertions.assertEquals(3,dynamicProgramming.eggDropRec(4,3));
    }

    @Test
    public void testEggDropTabulation(){
        Assertions.assertEquals(3,dynamicProgramming.eggDropTabulation(4,3));
    }

    @Test
    public void testMaxSumRec(){
        int[] arr = {1,10,5};
        Assertions.assertEquals(10,dynamicProgramming.maxSum(arr,arr.length));
    }

    @Test
    public void testMaxSumTabulation(){
        int[] arr = {1,10,5};
        Assertions.assertEquals(10,dynamicProgramming.maxSumTabulation(arr));
    }

    @Test
    public void testSubsetSum(){
        int[] arr = {1,2,3};
        Assertions.assertEquals(2,dynamicProgramming.subsetWithSum(arr,3,arr.length));
    }
    @Test
    public void testSubsetSum_1(){
        int[] arr = {10,20,15};
        Assertions.assertEquals(1,dynamicProgramming.subsetWithSum(arr,25,arr.length));
    }

    @Test
    public void testSubsetSumTab(){
        int[] arr = {1,2,3};
        Assertions.assertEquals(2,dynamicProgramming.subsetWithSumTab(arr,3));
    }

    @Test
    public void testSubsetSumTab_1(){
        int[] arr = {10,20,15};
        Assertions.assertEquals(1,dynamicProgramming.subsetWithSumTab(arr,25));
    }

    @Test
    public void testMatch(){
        String s = "baaabab";
        String p = "*ba*ab";
        Assertions.assertTrue(dynamicProgramming.match(s,p,s.length(),p.length()));
    }

    @Test
    public void testMatch_1(){
        String s = "baaabab";
        String p = "?*****ab";
        Assertions.assertTrue(dynamicProgramming.match(s,p,s.length(),p.length()));
    }

    @Test
    public void testMatch_2(){
        String s = "baaabab";
        String p = "?";
        Assertions.assertFalse(dynamicProgramming.match(s,p,s.length(),p.length()));
    }

    @Test
    public void testMatch_3(){
        String s = "baaabab";
        String p = "b?b";
        Assertions.assertFalse(dynamicProgramming.match(s,p,s.length(),p.length()));
    }

    @Test
    public void testMatchTab(){
        String s = "baaabab";
        String p = "*ba*ab";
        Assertions.assertTrue(dynamicProgramming.matchTabulation(s,p));
    }

    @Test
    public void testMatchTab_1(){
        String s = "baaabab";
        String p = "?*****ab";
        Assertions.assertTrue(dynamicProgramming.matchTabulation(s,p));
    }

    @Test
    public void testMatchTab_2(){
        String s = "baaabab";
        String p = "?";
        Assertions.assertFalse(dynamicProgramming.matchTabulation(s,p));
    }

    @Test
    public void testMatchTab_3(){
        String s = "baaabab";
        String p = "b?b";
        Assertions.assertFalse(dynamicProgramming.matchTabulation(s,p));
    }

    @Test
    public void testMaxIncSub(){
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        Assertions.assertEquals(7,dynamicProgramming.maxIncSub(arr));
    }

    @Test
    public void testCountUniqueBST(){
        Assertions.assertEquals(5,dynamicProgramming.countUniqueBST(3));
    }

    @Test
    public void testCountUniqueBST_2(){
        Assertions.assertEquals(42,dynamicProgramming.countUniqueBST(5));
    }

    @Test
    public void testMinPathSum(){
        int[][] grid = {{1,2,5},{3,2,1}};
        Assertions.assertEquals(6,dynamicProgramming.minPathSum(grid));
    }
}
