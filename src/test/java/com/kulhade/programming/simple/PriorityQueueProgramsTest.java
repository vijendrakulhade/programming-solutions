package com.kulhade.programming.simple;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PriorityQueueProgramsTest {

    private static PriorityQueuePrograms programs = null;

    @BeforeClass
    public static void setUp() {
        programs = new PriorityQueuePrograms();
    }
    @Test
    public void testHeapSort(){
        int[] nums = {1,4,2,5,3,6,0};
        int[] actual = programs.heapSort(nums);
        int[] expected = {0,1,2,3,4,5,6};
        Assert.assertArrayEquals(expected,actual);
    }
}
