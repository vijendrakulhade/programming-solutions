package com.kulhade.programming.simple;

import java.util.ArrayList;
import java.util.List;

public class TwoDimensionalArrayPrograms {
    /**
     * Method prints matrix in regular order
     * 00 01 02
     * 10 11 12
     * 20 21 22
     */
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

    public void print(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    /**
     * Method prints transpose of matrix
     * 00 01 02
     * 10 11 12 --> column first
     * 20 21 22
     */
    public void printTwoDimArrTranspose(){
        int[][] matrix = new int[4][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                matrix[j][i]=i+j;
                System.out.print(matrix[j][i]+" ");
            }
            System.out.println();
        }
    }

    /**
     * Method prints matrix in spiral order
     * 00 01 02
     * 10 11 12  --> 00 01 02 12 22 21 20 10 11
     * 20 21 22
     */
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

    /**
     * Num of Islands
     * Method will count group of 1's and return the number
     */
    public int numOfIsland(int[][] matrix){
        if(matrix==null)return 0;
        int m= matrix.length;
        int n=matrix[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1) {
                    count++;
                    searchLand(matrix, i, j);
                }
            }
        }
        return count;
    }

    private void searchLand(int[][] matrix,int i,int j){
        int m= matrix.length;
        int n=matrix[0].length;
        if((i<0 || i>=m) || (j<0 || j>=n) || matrix[i][j]!=1){
            return;
        }
        matrix[i][j]+=1;
        searchLand(matrix,i+1,j);
        searchLand(matrix,i,j+1);
        searchLand(matrix,i-1,j);
        searchLand(matrix,i,j-1);
    }

    public void rotate(int[][] matrix) {
        if(matrix==null) return;
        if(matrix.length != matrix[0].length) return;
        int m=matrix.length,n=matrix[0].length;
        for(int i=0;i<m/2;i++){
            for(int j=0;j<Math.ceil((double)n/2.) ;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[m-i-1][j];
                matrix[m-i-1][j] = matrix[m-i-1][n-j-1];
                matrix[m-i-1][n-j-1] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }

    }
    public boolean search2DMatrix(int[][] matrix,int target){
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return false;
        return search(matrix,0,matrix.length,0,matrix[0].length,target);
    }
    private  boolean search(int[][] m,int r_s,int r_e,int c_s,int c_e,int target){
        if(r_s==r_e-1 && c_s==c_e-1) {
            return m[r_s][c_s]==target;
        }
        int r_p = r_s+((r_e-r_s)/2);
        int c_p = c_s+((c_e-c_s)/2);
        if(r_p==0){
            //Only columns
            if(c_p==c_e-1){
                return m[r_p][c_p]==target;
            }
            if(m[r_p][c_s]<=target && m[r_p][c_p-1]>=target){
                if(m[r_p][c_s]==target) return true;
                if(m[r_p][c_p-1]==target) return true;
                return search(m,r_s,r_p,c_s,c_p,target);
            }else{
                return search(m,r_s,r_p,c_p,c_e,target);
            }
        }
        if(c_p==0){
            if(r_p==r_e-1){
                return m[r_p][c_p]==target;
            }
            if(m[r_s][c_s]<=target && m[r_p-1][c_p]>=target){
                if(m[r_s][c_s]==target) return true;
                if(m[r_p-1][c_p]==target) return true;
                return search(m,r_s,r_p,c_s,c_p,target);
            }else{
                return search(m,r_s,r_e,c_s,c_p,target);
            }
        }
        if(m[r_s][c_s]<=target && m[r_p-1][c_p-1]>=target){
            if(m[r_s][c_s]==target) return true;
            if(m[r_p-1][c_p-1]==target) return true;
            return search(m,r_s,r_p,c_s,c_p,target);
        }else if(m[r_p][c_s]<=target && m[r_e-1][c_p-1]>=target){
            if(m[r_p][c_s]==target) return true;
            if(m[r_e-1][c_p-1]==target) return true;
            return search(m,r_p,r_e,c_s,c_p,target);
        }else if(m[r_s][c_p]<=target && m[r_p-1][c_e-1]>=target){
            if(m[r_s][c_p]==target) return true;
            if(m[r_p-1][c_e-1]==target) return true;
            return search(m,r_s,r_p,c_p,c_e,target);
        }else{
            return search(m,r_p,r_e,c_p,c_e,target);
        }

    }


}
