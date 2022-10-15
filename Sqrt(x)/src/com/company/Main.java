package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
                /*
        Given a non-negative integer x, compute and return the square root of x.

        Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

        Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.

        One leetcode a day keep unemployment away.
        Keep learning.
        Keep trying.
         */

        // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
        // lo           mid                    hi
        // temp = 8*8 = 64
        // temp > n ? => hi = mid;
        // 1 2 3 4 5 6 7 8
        // lo   mid      hi
        // temp = mid = 4*4 = 16;
        // temp > n ? hi = mid : lo = mid;
        // 4 5 6 7 8
        // lo      hi
        // mid
        //////////////////
        // 1 2 3 4 5 6 7 8
        // lo            hi
        // lo   mid      hi
        // lo   (mid)temp     hi
        // 1 2 3 4
        //lo mid(temp) hi == 4;

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao n de ban oi!");
        int n = sc.nextInt();
        int [] a = new int [n];
        int mid = 0;
        int lo = 1;
        int hi = n;
        int temp = 0;

        while(lo<hi){
            mid = (lo + hi )/2;
            if (mid > n/mid) {
                hi = mid - 1;
            } else {
                if (mid + 1 > n/(mid + 1))
                    System.out.println("Sqrt(x): " + mid);
                    lo = mid + 1;
            }

        }
    }
}
