package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    /*
    You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
     The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
    Increment the large integer by one and return the resulting array of digits.
                    Example 1:
                Input: digits = [1,2,3]
                Output: [1,2,4]

                    Example 2:
                Input: digits = [4,3,2,1]
                Output: [4,3,2,2]

                    Example 3:
                Input: digits = [0]
                Output: [1]

                    Example 4:
                Input: digits = [9]
                Output: [1,0]
              ****************************************************
              One leetcode a day keep unemployment away
              Keep learning
              Keep trying
     */
/*
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int [] digits = new int [size];
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        System.out.println("Nhap vao mang");
        for (int i = 0;i<size;i++){
            digits[i] = sc.nextInt();
        }
        int j = 1;
        int sum = 1;
        while(size>0){
            sum  +=  digits[size-1] * j;
            j *= 10;
            size--;
        }

        System.out.println(sum);
        while(sum >0){
            list.add(sum%10);
            sum /= 10;
        }
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
  */
    // Sai


        int size = digits.length;
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i = size-1;i>=0;i--){
            if(digits[i] != 9){
                digits[i] +=1;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newNumber = new int [size+1];
        newNumber[0] = 1;

        return newNumber;
    }

    }
}
