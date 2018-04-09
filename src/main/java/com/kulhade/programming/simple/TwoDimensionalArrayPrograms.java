package com.kulhade.programming.simple;

import java.util.ArrayList;
import java.util.List;

public class TwoDimensionalArrayPrograms {

    public void printTwoDimArr(){
        int[][] matrix = new int[3][4];
        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                matrix[i][j]=i+j;
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public List<Integer> spiralPrint(int[][] matrix){
        List<Integer> result = new ArrayList<>();
        if(matrix==null || matrix.length==0){
            return result;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = 0;
        while(m>0 && n>0){
            if(m==1){
                for(int i=0;i<n;i++){
                    result.add(matrix[x][y++]);
                }
                break;
            }
            if(n==1){
                for(int i=0;i<m;i++){
                    result.add(matrix[x++][y]);
                }
                break;
            }
            for(int i=0;i<n-1;i++){
                result.add(matrix[x][y++]);
            }
            for(int i=0;i<m-1;i++){
                result.add(matrix[x++][y]);
            }
            for(int i=0;i<n-1;i++){
                result.add(matrix[x][y--]);
            }
            for(int i=0;i<m-1;i++){
                result.add(matrix[x--][y]);
            }
            x++;y++;
            m=m-2;n=n-2;
        }

        return result;
    }
}
