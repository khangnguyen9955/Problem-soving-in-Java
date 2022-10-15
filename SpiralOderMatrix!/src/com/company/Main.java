package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // config matrix
        Scanner sc = new Scanner(System.in);
        System.out.println("input rows and columns");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] matrix = new int [n][m];
        System.out.println("input matrix");
        for (int i =  0 ;i <n;i++){
            for(int j =0 ;j < m;j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        // solve problem
        // initial value;
        int t = 0;
        int b = n -1;
        int l =0;
        int r = m - 1;
        int dir = 0; // direction
        // initial an array 1D to store all elements;
        int [] res = new int [n*m];
        // count every element has pushed to array
        int count = 0;
        while(t <= b && l <= r){
            if(dir == 0){
                for(int i = l; i <= r;i++){
                    res[count] = matrix[t][i];
                    count++;
                }
                t++;
            }
            else if (dir == 1){
                for(int i = t; i <= b ;i++){
                    res[count] = matrix[i][r];
                    count++;
                }
                r--;

            }
            else if (dir == 2){
                for(int i = r ;i >= l ; i--){
                    res[count] = matrix[b][i];
                    count++;
                }
                b--;

            }
            else if (dir == 3){
                for(int i = b ; i >= t;i--){
                    res[count] = matrix[i][l];
                    count++;
                }
                l++;
            }
            dir = (dir+1)%4; // always in range 0->3
        }
        System.out.println(res[0]);
for(int i =0 ; i<count;i++){
    System.out.println(res[i]);
}






    }







}
