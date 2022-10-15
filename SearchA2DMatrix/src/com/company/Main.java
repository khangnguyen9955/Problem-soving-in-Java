package com.company;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        /*
        Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

        Integers in each row are sorted from left to right.
        The first integer of each row is greater than the last integer of the previous row.

        Cases:
        Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
        Output: true
        Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
        Output: false

        *****************************************************************
        One leetcode a day keep unemployment away.
            Keep learning !
            Keep trying !

    */
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap row vs col");
        int row = sc.nextInt();
        int col = sc.nextInt();
        int [][] matrix = new int [row][col];
        System.out.println("Nhap vao target");
        int target = sc.nextInt();

        for(int i =0 ;i<row;i++){
            for(int j = 0;j<col;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        for(int i =0 ;i<row;i++){
            for(int j = 0;j<col;j++){
                System.out.print(matrix[i][j] + " ");
                }
            System.out.println("\n");
        }


        if(row == 1){
            for(int i =0 ;i<col;i++){
                if(matrix[0][i] == target){
                    System.out.println("Day ne" + "0" + " " + i);
                }
                else{
                    System.out.println("Khong co trong nay");
                }
            }
        }
        else{
            if(target >= matrix[row-1][0]) {
                for (int i = 0; i < col; i++) {
                    if (target == matrix[row - 1][i]) {
                        System.out.println("Tim duoc roi" + (row-1) +" "+ i );
                    } else {
                        System.out.println("Khong co trong nay");
                    }
                }
            }
            else{
                for(int i=0;i< row-1 ;i++){
                    if(target == matrix[i][0]){
                        System.out.println("Tim duoc roi" + i +" " + "0");
                    }
                    else if(target < matrix[i+1][0] ){
                        for(int j =0 ;j<col;j++){
                            if(matrix[i][j] == target)
                                System.out.println("Tim duoc roi" + i + " " + j);

                        }
                    }

                }
            }
        }

// Done

    }

}
