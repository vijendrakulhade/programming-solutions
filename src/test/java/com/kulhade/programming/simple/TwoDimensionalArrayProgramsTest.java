package com.kulhade.programming.simple;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;

@RunWith(JUnit4.class)
public class TwoDimensionalArrayProgramsTest {

    static TwoDimensionalArrayPrograms twoDimensionalArrayPrograms;
    @BeforeClass
    public static void setup(){
        twoDimensionalArrayPrograms = new TwoDimensionalArrayPrograms();
    }

    @Test
    public void testPrint(){
        twoDimensionalArrayPrograms.printTwoDimArr();
    }

    @Test
    public void testSpiralOrder(){
        int[][] matrix = new int[3][4];
        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                matrix[i][j]=i+j;
            }
        }
        List<Integer> expected = Arrays.asList(0,1,2,3,4,5,4,3,2,1,2,3);
        List<Integer> actual = twoDimensionalArrayPrograms.spiralPrint(matrix);
        Assert.assertArrayEquals(expected.toArray(),actual.toArray());

    }
}
