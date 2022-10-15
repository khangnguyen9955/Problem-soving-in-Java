package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /*
        Given two stings ransomNote and magazine, return true if ransomNote can be constructed from magazine and false otherwise.

        Each letter in magazine can only be used once in ransomNote.

       One leetcode a day keep unemployment away.
       Keep trying.
       Keep learning.
     */

        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap vao ransomNote");
        String ransomNote = sc.next();
        System.out.println("Nhap vao magazine");
        String magazine = sc.next();

        int [] count= new int [26];
        for (int i =0 ;i< magazine.length();i++){
            count[magazine.charAt(i) - 'a']++;
        }
        for(int i =0;i<ransomNote.length();i++){
            if( count[ransomNote.charAt(i) - 'a'] < 0 ){
                System.out.println("Khong thuoc");
            }
        }
        System.out.println("Thuoc");

// Done


    }
}
