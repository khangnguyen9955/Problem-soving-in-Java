package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
    /*
    Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.


    One leetcode a day keep unemployment away.
     */

        Scanner sc = new Scanner(System.in);

        System.out.println("input a string");
        String s = sc.next();

        int [] count = new int [25];

        for(int i = 0 ;i < s.length();i++){
            count[s.charAt(i) - 'a']++;
        }
        for(int i =0;i<s.length();i++){
            if(count[s.charAt(i) -'a'] == 1){
                System.out.println("First index" + s.charAt(i) );
            }
        }

        // Done





    }
}
