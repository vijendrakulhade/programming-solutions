package com.kulhade.programming.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.kulhade.programming.simple.BitManipulation.toBinary;
import static com.kulhade.programming.simple.BitManipulation.toDecimal;

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

    @Test
    public void testToBinary() {
        int[] expected = {0, 1, 0, 1};
        int[] actual = toBinary(5, 4);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testToDecimal() {
        int[] input = {0, 1, 0, 1};
        int actual = toDecimal(input);
        Assertions.assertEquals(5, actual);
    }
}
