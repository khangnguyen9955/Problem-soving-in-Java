package com.company;

import java.util.Scanner;

public class Main {
//
//    Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
//
//    The overall run time complexity should be O(log (m+n)).
//
//
//
//    Example 1:
//
//    Input: nums1 = [1,3], nums2 = [2]
//    Output: 2.00000
//    Explanation: merged array = [1,2,3] and median is 2.
//    Example 2:
//
//    Input: nums1 = [1,2], nums2 = [3,4]
//    Output: 2.50000
//    Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
//
// One leetcode a day keep unemployment away
// Just do it.



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("nums 1: ");
        int n1 = sc.nextInt();
        System.out.println("nums 2: ");
        int n2 = sc.nextInt();

        int [] nums1 = new int[n1];
        int [] nums2 = new int[n2];

        System.out.println("input nums 1:");
        for(int i = 0; i<n1;i++){

            nums1[i] = sc.nextInt();
        }
        System.out.println("input nums 2:");
        for(int i = 0; i<n2;i++){
            nums2[i] = sc.nextInt();
        }





        // write your code here
    }
}
