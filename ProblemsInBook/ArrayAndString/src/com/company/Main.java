package com.company;

public class Main {

 // Question: Implement an algorithm to determine a string has all unique characters, cannot use additional data structures
    public static boolean isUnique(String s){
        if(s.length() > 128) return false; // this means there will be duplicated character in this string, right?
        boolean [] contains = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            int castChar = s.charAt(i);
            if(contains[castChar]){
                System.out.println("False");
                return false;
            }
            contains[castChar] = true;
        }
        System.out.println("True");
        return true;
    }

    public static void main(String[] args) {
        isUnique("test");
        isUnique("Test");
        isUnique("abc");
        isUnique("Hello");

    }
}
