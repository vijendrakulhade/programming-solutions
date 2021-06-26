package com.kulhade.oops.programming.patterns;

import com.kulhade.programming.patterns.TwoPointers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointersTest {

    private static TwoPointers twoPointers = new TwoPointers();

    @Test
    public void testTwoSum(){
        int[] nums = {1, 2, 3, 4, 6};
        int sum=6;
        List<TwoPointers.Pair> expected = new ArrayList();
        expected.add(new TwoPointers.Pair(3,1));
        List<TwoPointers.Pair> actual = twoPointers.twoSum(nums,sum);
        Assertions.assertEquals(expected.size(), actual.size());
        for(int i=0;i<expected.size();i++)
            Assertions.assertTrue(expected.get(i).equals(actual.get(i)));
    }
    @Test
    public void testTwoSum_1(){
        int[] nums = {2, 5, 9, 11};
        int sum=11;
        List<TwoPointers.Pair> expected = new ArrayList();
        expected.add(new TwoPointers.Pair(2,0));
        List<TwoPointers.Pair> actual = twoPointers.twoSum(nums,sum);
        Assertions.assertEquals(expected.size(), actual.size());
        for(int i=0;i<expected.size();i++)
            Assertions.assertTrue(expected.get(i).equals(actual.get(i)));
    }
    @Test
    public void testTwoSum_2(){
        int[] nums = {2, 5, 9, 11};
        int sum=11;
        List<TwoPointers.Pair> expected = new ArrayList();
        expected.add(new TwoPointers.Pair(2,0));
        List<TwoPointers.Pair> actual = twoPointers.twoSum(nums,sum);
        Assertions.assertEquals(expected.size(), actual.size());
        for(int i=0;i<expected.size();i++)
            Assertions.assertTrue(expected.get(i).equals(actual.get(i)));
    }

    @Test
    public void testThreeSum(){
        int[] nums = {};
        List<TwoPointers.Triplet> expected = new ArrayList();
        List<TwoPointers.Triplet> actual = twoPointers.threeSum(nums);
        Assertions.assertEquals(expected.size(),actual.size());
    }
    @Test
    public void testThreeSum_1(){
        int[] nums = {-1,0,1,2,-1,-4};
        List<TwoPointers.Triplet> expected = new ArrayList();
        expected.add(new TwoPointers.Triplet(2,1,0));
        expected.add(new TwoPointers.Triplet(4,3,0));
        List<TwoPointers.Triplet> result = twoPointers.threeSum(nums);
        List<TwoPointers.Triplet> actual = twoPointers.removeDuplicates(result);
        Assertions.assertEquals(expected.size(),actual.size());
        for(int i=0;i<expected.size();i++)
            Assertions.assertTrue(expected.get(i).equals(actual.get(i)));
    }

    @Test
    public void testRemoveDuplicate(){
        List<Integer> lst = Arrays.asList(1,1,2,2,3,3,3);
        List<Integer> actual = twoPointers.removeDuplicates(lst);
        List<Integer> expected = Arrays.asList(1,2,3);
        Assertions.assertArrayEquals(expected.toArray(),actual.toArray());
    }
    @Test
    public void testRemoveDuplicate_1(){
        List<Integer> lst = Arrays.asList(1,2,2,3,3,3);
        List<Integer> actual = twoPointers.removeDuplicates(lst);
        List<Integer> expected = Arrays.asList(1,2,3);
        Assertions.assertArrayEquals(expected.toArray(),actual.toArray());
    }
    @Test
    public void testRemoveDuplicate_2(){
        List<Integer> lst = Arrays.asList(1,1,1,2,3);
        List<Integer> actual = twoPointers.removeDuplicates(lst);
        List<Integer> expected = Arrays.asList(1,2,3);
        Assertions.assertArrayEquals(expected.toArray(),actual.toArray());
    }

    @Test
    public void testRemoveElement(){
        List<Integer> lst = Arrays.asList(1,1,1,2,3);
        List<Integer> actual = twoPointers.removeElement(lst,1);
        List<Integer> expected = Arrays.asList(2,3);
        Assertions.assertArrayEquals(expected.toArray(),actual.toArray());
    }
    @Test
    public void testRemoveElement_1(){
        List<Integer> lst = Arrays.asList(1,2,3,1);
        List<Integer> actual = twoPointers.removeElement(lst,1);
        List<Integer> expected = Arrays.asList(2,3);
        Assertions.assertArrayEquals(expected.toArray(),actual.toArray());
    }
}
