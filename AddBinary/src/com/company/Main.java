package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /*
        Given two binary strings a and b, return their sum as a binary string.

        ************************************
        One leetcode a day keep unemployment away.
        Keep learning.
        Keep trying.
         */

        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap vao a");
        String a = sc.next();
        System.out.println("Nhap vao b");
        String b = sc.next();

        int b1 = Integer.parseInt(a,2);
        int b2 = Integer.parseInt(b,2);
        int sum = b1+b2;
        System.out.println(Integer.toBinaryString(sum));



    }
}
