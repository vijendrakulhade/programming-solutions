package com.kulhade.programming.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PriorityQueueProgramsTest {

    private static PriorityQueuePrograms programs = null;

    @BeforeAll
    public static void setUp() {
        programs = new PriorityQueuePrograms();
    }
    @Test
    public void testHeapSort(){
        int[] nums = {1,4,2,5,3,6,0};
        int[] actual = programs.heapSort(nums);
        int[] expected = {0,1,2,3,4,5,6};
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void testMergedKSortedArray(){
        int[][] arrays={{1,3,5},{2,6,9},{1,2,45,67,78}};
        int[] expected = {1,1,2,2,3,5,6,9,45,67,78};
        Assertions.assertArrayEquals(expected,programs.mergeKSortedArray(arrays));
    }

    @Test
    public void testLastStoneWeight(){
        int[] stones = {2,7,4,1,8,1};
        Assertions.assertEquals(1,programs.lastStoneWeight(stones));
    }

    @Test
    public void testTopKElement(){
        int[] nums = {1,1,1,2,2,3};
        int[] res = {1,2};
        Assertions.assertArrayEquals(res,programs.topKFrequent(nums,2));
    }

    @Test
    public void testFindKthLargest(){
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        Assertions.assertEquals(5,programs.findKthLargest(nums,2));
    }
    @Test
    public void testFindKthLargest_2(){
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        Assertions.assertEquals(4,programs.findKthLargest(nums,k));
    }

    @Test
    public void testTotalCost(){
        int[] costs = {17,12,10,2,7,2,11,20,8};
        int k=3;
        int candidates = 4;
        Assertions.assertEquals(11,programs.totalCost(costs,k,candidates));
    }
}
