package com.kulhade.programming.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BitManipulationTest {

    private static BitManipulation o;
    @BeforeAll
    public static void  setup(){
        o=new BitManipulation();
    }

    @Test
    public void test_xor(){
        Assertions.assertEquals(1,o.xor(2,3));
    }

    @Test
    public void test_sum(){
        Assertions.assertEquals(5,o.getSum(2,3));
    }

    @Test
    public void test_nonRepeating(){
        int[] nums = {1,1,2,2,5,3,3,4,4};
        Assertions.assertEquals(5,o.getNonRepeating(nums));
    }
}
