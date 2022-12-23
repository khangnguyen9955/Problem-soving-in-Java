package com.company;

public class Main {
    // ZeroMatrix: Write an algorithm that if an element in an MxN matrix is 0,
    // its entire row and column are set to 0

    // with this solution, we can reduce the space to O(1) instead of O(MN) of using 2 loops

    public static void nullifyCol(int[][]matrix, int col){
        for (int i = 0; i <matrix.length ; i++) {
            matrix[i][col] = 0;
        }
    }

    public static void nullifyRow(int[][]matrix, int row){
        for (int i = 0; i <matrix[0].length ; i++) {
            matrix[row][i] =0;
        }
    }
    public static void setZeros(int [][]matrix){
        boolean colHasZero = false;
        boolean rowHasZero = false;

        // check first row has zero
        for (int i = 0; i < matrix[0].length ; i++) {
            if (matrix[0][i] == 0){
                rowHasZero = true;
                break;
            }
        }
        // check first col has zero
        for (int i = 0; i <matrix.length ; i++) {
            if (matrix[i][0] == 0){
                colHasZero = true;
                break;
            }
        }

        // check zeros and set the first row or col of that cell to zero
        for (int i = 1; i <matrix.length ; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j]==0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // nullify rows based on values in first col
        for (int i = 1; i < matrix.length ; i++) {
            if (matrix[i][0] == 0){
                nullifyRow(matrix,i);
            }
        }
        //nullify cols based on values in first row
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0){
                nullifyCol(matrix,i);
            }
        }
        if (rowHasZero){
            nullifyRow(matrix,0);
        }
        if(colHasZero){
            nullifyCol(matrix,0);
        }
    }

    public static void main(String[] args) {
	// write your code here

    }
}
