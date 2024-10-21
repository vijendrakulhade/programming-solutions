package com.kulhade.programming.patterns;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RecursionTest {

    private static Recursion recursion = new Recursion();
    @Test
    public void testSubset(){
        int[] nums = {1,2,3};
        List<List<Integer>> actual = recursion.subsets(nums);
        System.out.println(Arrays.toString(actual.toArray()));
        Assertions.assertEquals(8,actual.size());
    }
    @Test
    public void testPrintPermutations(){
        String s = "abc";
        recursion.printPermutations(s," ");
    }

    @Test
    public void testArrayCopyExcept(){
        int[] nums = {1,2,3,4};
        int idx=0;
        int[] exceptRes = {2,3,4};
        Assertions.assertArrayEquals(exceptRes,recursion.arrayCopyExcept(nums,idx));
    }

    @Test
    public void testArrayCopyExcept_1(){
        int[] nums = {1,2,3,4};
        int idx=1;
        int[] exceptRes = {1,3,4};
        Assertions.assertArrayEquals(exceptRes,recursion.arrayCopyExcept(nums,idx));
    }

    @Test
    public void testArrayCopyExcept_2(){
        int[] nums = {1,2,3,4};
        int idx=3;
        int[] exceptRes = {1,2,3};
        Assertions.assertArrayEquals(exceptRes,recursion.arrayCopyExcept(nums,idx));
    }

    @Test
    public void testPermute(){
        int[] nums = {1,2,3};
        List<List<Integer>> expect = Arrays.asList(Arrays.asList(3,2,1),Arrays.asList(2,3,1),Arrays.asList(3,1,2),
                Arrays.asList(1,3,2),Arrays.asList(2,1,3),Arrays.asList(1,2,3));
        Object[] res = recursion.permute(nums).toArray();
        for(Object o:res){
            System.out.println(o);
        }
        Assertions.assertArrayEquals(expect.toArray(),res);
    }

    @Test
    public void testPermute_2(){
        int[] nums = {1,2,3};
        List<List<Integer>> expect = Arrays.asList(Arrays.asList(3,2,1),Arrays.asList(2,3,1),Arrays.asList(3,1,2),
                Arrays.asList(1,3,2),Arrays.asList(2,1,3),Arrays.asList(1,2,3));
        Object[] res = recursion.permute_2(nums).toArray();
        for(Object o:res){
            System.out.println(o);
        }
        Assertions.assertArrayEquals(expect.toArray(),res);
    }
}
