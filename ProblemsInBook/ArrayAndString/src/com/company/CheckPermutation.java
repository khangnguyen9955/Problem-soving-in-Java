package com.company;

import java.util.Arrays;

// question:
// given two strings, write a method to decide if one is a permutation of the other
//solution:
// 1) sort and then compare?
// 2) hash table by the char size
public class CheckPermutation {
    public static String sort(String s){
        char [] sortedStr = s.toCharArray();
         java.util.Arrays.sort(sortedStr);
        return new String(sortedStr);
    }
    public static boolean CheckPermutationSolution1 (String s1, String s2){
        if(s1.length() != s2.length()){ //base case
            System.out.println("False");
            return false;
        }
        boolean  res= sort(s1).equals(sort(s2)); // for visualize only
        if(res){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }
        // just return the sort... above
        return res;
    }
// time complexity of this solution based mainly on the Sort algorithm of Java: depends on it is quick sort or merge sort or ...?
    // Time complexity : O(nLog(n))
    // we can improve this by O(n)
    public static boolean CheckPermutationSolution2(String s1,String s2){
        if(s1.length() != s2.length()){ //base case
            System.out.println("False");
            return false;
        }
        int [] count = new int[128]; //assume
        char[]countChars = s1.toCharArray();
        for(char c: countChars){
            count[c]++;
        }
        for (int i = 0; i < s2.length(); i++) { // O(n) , two string lengths will be same, if not return false
            int convert = s2.charAt(i);
            count[convert]--;
            if(count[convert] < 0){
                System.out.println("False");
                return false;
            }
        }
        System.out.println("true");
        return true;
    }
    public static void main(String[] args) {
        CheckPermutationSolution1("abc","bca");
        CheckPermutationSolution2("abc","bca");
        CheckPermutationSolution1("abc","bcs");
        CheckPermutationSolution2("abc","bcs");
    }

}
