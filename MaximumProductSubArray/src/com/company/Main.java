package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /*
        One leetcode a day keep unemployment away.
        Keep learning
        Keep trying
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao size");
        int size = sc.nextInt();
        int[] nums = new int [size];
        System.out.println("Nhap vao nums[]");
        for(int i =0;i<size;i++){
            nums[i] = sc.nextInt();
        }
        int max = Integer.MIN_VALUE;
        int temp = 1;
        for(int i = 0 ; i<size;i++){
            if(max < nums[i]){
                max = nums[i];
            }
           temp  *= nums[i];
            if(temp > max){
                max = temp;
            }
            if(max < 0) {
                max = 0;
                temp = 1;
            }
        }
        System.out.println(max);

    }
}
