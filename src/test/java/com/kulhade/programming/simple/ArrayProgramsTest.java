package com.kulhade.programming.simple;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vn05f93 on 10/5/17.
 */
public class ArrayProgramsTest {

    private static ArrayPrograms arrayPrograms = null;

    @BeforeAll
    public static void setUp() {
        arrayPrograms = new ArrayPrograms();
    }

    @Test
    public void testThreeSum() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<Integer> pair = new ArrayList<>(3);
        pair.add(-1);
        pair.add(-1);
        pair.add(2);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(pair);
        pair = new ArrayList<>(3);
        pair.add(-1);
        pair.add(0);
        pair.add(1);
        expected.add(pair);
        List<List<Integer>> actual = arrayPrograms.threeSum(nums);
        Assertions.assertEquals(expected.size(), actual.size());
        Assertions.assertArrayEquals(expected.get(0).toArray(), actual.get(0).toArray());
        Assertions.assertArrayEquals(expected.get(1).toArray(), actual.get(1).toArray());
    }

    @Test
    public void testThreeSum_0() {
        int[] nums = {0, 0, 0};
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(0, 0, 0));
        List<List<Integer>> actual = arrayPrograms.threeSum(nums);
        Assertions.assertEquals(expected.size(), actual.size());
        Assertions.assertArrayEquals(expected.get(0).toArray(), actual.get(0).toArray());
    }

    @Test
    public void testTwoSum() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {1, 2};
        int[] actual = arrayPrograms.twoSum(nums, target);
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testTwoSum_2() {
        int[] nums = {2, 11, 7, 15};
        int target = 9;
        int[] expected = {1, 3};
        int[] actual = arrayPrograms.twoSum(nums, target);
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testRotate() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int[] expected = {5, 6, 7, 1, 2, 3, 4};
        int[] actual = arrayPrograms.rotate(nums, 3);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRotateInPlace() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int[] expected = {5, 6, 7, 1, 2, 3, 4};
        arrayPrograms.rotateInPlace(nums, 3);
        Assertions.assertArrayEquals(expected, nums);
    }

    @Test
    public void testReverse() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int[] expected = {7, 6, 5, 4, 3, 2, 1};
        arrayPrograms.reverse(nums, 0, nums.length - 1);
        Assertions.assertArrayEquals(expected, nums);
    }

    @Test
    public void testRotateIllegalArg() {
        int[] nums = null;
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            arrayPrograms.rotate(nums, 3);
        }
        ,"Expected Exception");
    }

    @Test
    public void testEvaluate() {
        char[] expression = {'2', '3', '+', '4', '*'};
        int expected = 20;
        int actual = arrayPrograms.evaluate(expression);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFindUniqueElement_With3RepeatedElement() {
        int[] testArr = {5, 5, 5, 4, 4, 8, 8, 4, 8, 9};
        int actual = arrayPrograms.findUniqueElement(testArr, 3);
        Assertions.assertEquals(9, actual);
    }

    @Test
    public void testFindUniqueElement_With2RepeatedElement() {
        int[] testArr = {5, 5, 4, 4, 9, 8, 8};
        int actual = arrayPrograms.findUniqueElement(testArr, 2);
        Assertions.assertEquals(9, actual);
    }

    @Test
    public void testFindUniqueElement() {
        int[] testArr = {3, 3, -4, 5, 5};
        int actual = arrayPrograms.findUniqueElement(testArr);
        Assertions.assertEquals(-4, actual);
    }

    @Test
    public void testJumpFalse() {
        int[] numbers = {2, 1, 0, 4, 3};
        boolean actual = arrayPrograms.jump(numbers, 0);
        Assertions.assertFalse(actual);
    }

    @Test
    public void testJumpFalse_1() {
        int[] numbers = {1, 2, 3};
        boolean actual = arrayPrograms.jump(numbers, 0);
        Assertions.assertFalse(actual);
    }

    @Test
    public void testJumpTrue() {
        int[] numbers = {3, 3, 0, 0, 0};
        boolean actual = arrayPrograms.jump(numbers, 0);
        Assertions.assertTrue(actual);
    }

    @Test
    public void testJump_memorization() {
        int[] numbers = {3, 3, 0, 0, 0};
        boolean actual = arrayPrograms.jump_memorization(numbers);
        Assertions.assertTrue(actual);
    }

    @Test
    public void testRotateLeftToRight() {
        int[] input = {1, 5, 4, 3, 2};
        int[] expected = {4, 3, 2, 1, 5};
        int[] actual = arrayPrograms.rotateLeftToRight(input, 2);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRotateLeftToRight_1() {
        int[] input = {4, 3, 2, 1, 5};
        int[] expected = {4, 3, 2, 1, 5};
        int[] actual = arrayPrograms.rotateLeftToRight(input, 5);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testPancakeSort() {
        int[] input = {1, 5, 4, 3, 2};
        int[] actual = arrayPrograms.pancakeSort(input);
        int[] expected = {1, 2, 3, 4, 5};
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void testSearchInsertPosition_0() {
        int[] input = {1, 3, 5, 6};
        int actual = arrayPrograms.searchInsertPosition(input, 5);
        Assertions.assertEquals(2, actual);
    }

    @Test
    public void testSearchInsertPosition_1() {
        int[] input = {1, 3, 5, 6};
        int actual = arrayPrograms.searchInsertPosition(input, 0);
        Assertions.assertEquals(0, actual);
    }

    @Test
    public void testSearchInsertPosition() {
        int[] input = {1, 3, 5, 6};
        int actual = arrayPrograms.searchInsertPosition(input, 7);
        Assertions.assertEquals(4, actual);
    }

    @Test
    public void testSearchInsertPosition_2() {
        int[] input = {1, 3};
        int actual = arrayPrograms.searchInsertPosition(input, 2);
        Assertions.assertEquals(1, actual);
    }

    @Test
    public void testAllSubSet() {
        int[] input = {3, 5, 6};
        List<List<Integer>> actual = arrayPrograms.allSubsets(input);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>());
        expected.add(Arrays.asList(3));
        expected.add(Arrays.asList(5));
        expected.add(Arrays.asList(3, 5));
        expected.add(Arrays.asList(6));
        expected.add(Arrays.asList(3, 6));
        expected.add(Arrays.asList(5, 6));
        expected.add(Arrays.asList(3, 5, 6));
        Assertions.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testFindMinInRotatedSortedArray() {
        int[] input = {4, 5, 6, 7, -2, -1, 1, 2};
        int actual = arrayPrograms.findMinInRotatedSortedArray(input);
        Assertions.assertEquals(-2, actual);
    }

    @Test
    public void testFindMinInRotatedSortedArray_2() {
        int[] input = {3, 1, 2};
        int actual = arrayPrograms.findMinInRotatedSortedArray(input);
        Assertions.assertEquals(1, actual);
    }

    @Test
    public void testRemoveDuplicates() {
        int[] input = {1, 1, 2};
        int actual = arrayPrograms.removeDuplicates(input);
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMoveZeroRight() {
        int[] input = {0, 1, 0, 3, 12};
        int[] expected = {1, 3, 12, 0, 0};
        arrayPrograms.moveZeroesRight(input);
        Assertions.assertArrayEquals(expected, input);
    }

    @Test
    public void testMoveZeroLeft() {
        int[] input = {0, 1, 0, 3, 12};
        int[] expected = {0, 0, 1, 3, 12};
        arrayPrograms.moveZerosLeft(input);
        Assertions.assertArrayEquals(expected, input);
    }

    @Test
    public void testMergeKSortedList() {
        List<List<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(0, 1, 3, 12)));
        input.add(new ArrayList<>(Arrays.asList(2, 3, 4)));
        input.add(new ArrayList<>(Arrays.asList(5, 8, 13)));
        List<Integer> expected = Arrays.asList(0, 1, 2, 3, 3, 4, 5, 8, 12, 13);
        List<Integer> actual = arrayPrograms.mergeKSortedList(input);
        Assertions.assertArrayEquals(expected.toArray(), actual.toArray());

    }

    @Test
    public void testCellCompete() {
        int[] cells = {0, 1, 0, 1, 0, 1, 0, 1};
        int[] actual = arrayPrograms.cellCompete(cells, 3);
        int[] expected = {1, 0, 1, 0, 0, 0, 0, 0};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testStockBuySell(){
        int[] prices = {23,13,33,45,56,14,30,34,50};
        List<ArrayPrograms.Pair> expected = new ArrayList<>();
        expected.add(new ArrayPrograms.Pair<>(13,56));
        expected.add(new ArrayPrograms.Pair<>(14,50));
        Assertions.assertEquals(expected.size(),arrayPrograms.stockBuySell(prices).size());
    }

    @Test
    public void testMaxSubarraySum(){
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        Assertions.assertEquals(6,arrayPrograms.maxSubarraySum(arr));
    }

    @Test
    public void testMaxSubarraySum_1(){
        int[] arr = {-2,-1,-3,-4};
        Assertions.assertEquals(-1,arrayPrograms.maxSubarraySum(arr));
    }

    @Test
    public void testMergeSort(){
        int[] merge_sort = {5,1,1,2,0,0};
        int[] expected = {0,0,1,1,2,5};
        Assertions.assertArrayEquals( expected,arrayPrograms.merge_sort(merge_sort));
    }

    @Test
    public void testSearchInRotatedSOrted(){
        int[]  a = {3,5,1};
        Assertions.assertEquals(0,arrayPrograms.searchInRotatedSorted(a,3));
    }

    @Test
    public void testSearchInRotatedSOrted_1(){
        int[]  a = {5,1,3};
        Assertions.assertEquals(0,arrayPrograms.searchInRotatedSorted(a,5));
    }

    @Test
    public void testSlidingWindowMax(){
        int[] input = {8,2,4,7};
        int[] expected = {8,4,7};
        Assertions.assertArrayEquals(expected,arrayPrograms.slidingWindowMax(input,2));
    }

    @Test
    public void testSlidingWindowMax_1(){
        int[] input = {1,3,-1,-3,5,3,6,7};
        int[] expected = {3,3,5,5,6,7};
        Assertions.assertArrayEquals(expected,arrayPrograms.slidingWindowMax(input,3));
    }

    @Test
    public void testConvertFive(){
        Assertions.assertEquals(4,arrayPrograms.convertFive(4));
    }

    @Test
    public void testMajority(){
        int[] arr = {3,2,3};
        Assertions.assertEquals(3,arrayPrograms.majority(arr));
    }
    @Test
    public void testMajority_1(){
        int[] arr = {2,2,1,3,1,1,4,1,1,5,1,1,6};
        Assertions.assertEquals(1,arrayPrograms.majority(arr));
    }

    @Test
    public void testMajority2(){
        int[] arr = {3,2,3};
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        List<Integer> actual = arrayPrograms.majority2(arr);
        Assertions.assertArrayEquals(expected.toArray(),actual.toArray());
    }
    @Test
    public void testMajority2_1(){
        int[] arr = {1,1,1,3,3,2,2,2};
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        List<Integer> actual = arrayPrograms.majority2(arr);
        Assertions.assertArrayEquals(expected.toArray(),actual.toArray());
    }

    @Test
    public void testMajority2_2(){
        int[] arr = {1,2};
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        List<Integer> actual = arrayPrograms.majority2(arr);
        Assertions.assertArrayEquals(expected.toArray(),actual.toArray());
    }

    @Test
    public void testSlidingWindowAvg(){
        int[] arr={1, 3, 2, 6, -1, 4, 1, 8, 2};
        int k=5;
        float[] result = arrayPrograms.slidingWindowAvg(arr,k);
        float[] expected = {2.2F, 2.8F, 2.4F, 3.6F, 2.8F};
        Assertions.assertArrayEquals(expected,result);
    }

    @Test
    public void testSmallestSubArrSizeSum(){
        int[] arr= {2,1,5,2,3,2};
        int sum=7;
        Assertions.assertEquals(2,arrayPrograms.smallestSubArrSizeSum(arr,sum));
    }
    @Test
    public void testSmallestSubArrSizeSum_1(){
        int[] arr= {2,1,5,2,8};
        int sum=1;
        Assertions.assertEquals(1 ,arrayPrograms.smallestSubArrSizeSum(arr,sum));
    }

    @Test
    public void testSmallestSubArrSizeSum_2(){
        int[] arr= {3, 4, 1, 1, 6};
        int sum=8;
        Assertions.assertEquals(3 ,arrayPrograms.smallestSubArrSizeSum(arr,sum));
    }

    @Test
    public void testCarFleet(){
        int[] pos = {6,8};
        int target = 10;
        int[] speed = {3,2};
        Assertions.assertEquals(2,arrayPrograms.carFleet(target,pos,speed));
    }
}
