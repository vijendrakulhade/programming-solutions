package com.kulhade.programming.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TwoDimensionalArrayProgramsTest {

    static TwoDimensionalArrayPrograms twoDimensionalArrayPrograms;
    @BeforeAll
    public static void setup(){
        twoDimensionalArrayPrograms = new TwoDimensionalArrayPrograms();
    }

    @Test
    public void testPrint(){
        twoDimensionalArrayPrograms.printTwoDimArr();
    }

    @Test
    public void testPrintTwoDimArrTranspose(){
        twoDimensionalArrayPrograms.printTwoDimArrTranspose();
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
        Assertions.assertArrayEquals(expected.toArray(),actual.toArray());

    }

    @Test
    public void testNumOfIsland(){
        int[][] matrix = new int[4][4];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                matrix[i][j]=1;
            }
        }
        int count = twoDimensionalArrayPrograms.numOfIsland(matrix);
        Assertions.assertEquals(1,count);
    }

    @Test
    public void testNumOfIsland_1(){
        int[][] matrix = new int[4][4];
        for(int i=0;i<4;i++){
            if(i%2!=0)
                matrix[0][i]=1;
            else
                matrix[0][i]=0;
        }
        int count = twoDimensionalArrayPrograms.numOfIsland(matrix);
        Assertions.assertEquals(2,count);
    }

    @Test
    public void testNumOfIsland_2(){
        //
        //[[0,1,0,1,0],[0,0,1,1,1],[1,0,0,1,0],[0,1,1,0,0],[1,0,1,0,1]]
        int[][] matrix = new int[1][1];
                matrix[0][0]=1;
        int count = twoDimensionalArrayPrograms.numOfIsland(matrix);
        Assertions.assertEquals(1,count);
    }

    @Test
    public void testRotateImage(){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        twoDimensionalArrayPrograms.print(matrix);

        twoDimensionalArrayPrograms.rotate(matrix);
        System.out.println();
        twoDimensionalArrayPrograms.print(matrix);

    }

    @Test
    public void testSearch2DMatrix(){
        int[][] m = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        Assertions.assertFalse(twoDimensionalArrayPrograms.search2DMatrix(m,20));
    }

    @Test
    public void testSearch2DMatrix_2(){
        int[][] m = {{-1,3}};
        Assertions.assertTrue(twoDimensionalArrayPrograms.search2DMatrix(m,-1));
    }

    @Test
    public void testSearch2DMatrix_3(){
        int[][] m = {{-1},{3}};
        Assertions.assertTrue(twoDimensionalArrayPrograms.search2DMatrix(m,3));
    }
}
