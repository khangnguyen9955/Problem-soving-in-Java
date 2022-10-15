package com.company;

import java.sql.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
       /* Given an integer numRows, return the first numRows of Pascal's triangle.
        In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
        Example 1:
        Input: numRows = 5
        Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
        Example 2:
        Input: numRows = 1
        Output: [[1]]

        Return a list of lists of arrays
        One leetcode a day keeps unemployment away
*/
         Scanner sc = new Scanner(System.in);

        System.out.println("Input Row");
        int row = sc.nextInt();
        row++;
        List<List <Integer>> triangle = new ArrayList<List<Integer>>();
        ArrayList <Integer> eachRow = new ArrayList<Integer>();
         if (row == 1){
        }
        int [][]arr=new int [row][row];
        for(int i = 0;i < row;i++){
            int col = i % row;
             for (int j =0;j<= col;j++){
                     arr[i][col] = 1;
                     arr[i][0] = 1;
                     if(arr[i][j] != 1){
                         arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                     }
                     eachRow.add(arr[i][j]);
             }
             triangle.add(new ArrayList<Integer>(eachRow));
             eachRow.clear();

        }
        System.out.println("Pascal's Triangle");
        System.out.println(triangle.get(row-1));
        System.out.println(triangle.get(row-2));
        System.out.println(triangle.get(row-3));
        System.out.println(triangle.get(row-4));
        System.out.println(triangle.get(row-5));
        System.out.println(triangle.get(row-6));

    }
// Same with Triangle's Pascal but only get index of the row we want
}
