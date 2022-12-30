package com.company;
// There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character.
// Given two strings, write a function to check if they are one edit (or zero edits) away.
// example
// pale, ple -> true
// pales, pale -> true
// pale, bale -> true
// pale, bake -> false



public class ZeroAway{


    public static boolean OneAway(String firstString, String secondString){
        // basically, we do not need to care about the 3 types
        // we only need to know whether in these two string have more than 1 difference or not?
        // base case
        if(Math.abs(firstString.length()) - Math.abs(secondString.length()) > 1){
            //there is more than 1 difference for sure
            System.out.println("False");
            return false;
        }
        // we need to know which string is longer? to know we move which string if in the case inserting
        String s1 = firstString.length() < secondString.length() ? firstString : secondString;
        String s2 = firstString.length() < secondString.length() ? secondString : firstString;
        // create a flag
        boolean flag = false;
        int id1=0;
        int id2=0;
        while(id1<s1.length() && id2< s2.length()){
            if(s1.charAt(id1) != s2.charAt(id2)){
                if(flag) {
                    System.out.println("False");
                    return false;
                }
                flag = true;
                if(s1.length() == s2.length()){ // 2 strings length ==
                    // means in replace
                    id1++;
                }
                // 2 string's length not equals  => insert
            }else{
                // matched
                id1++;
            }
            id2++;
        }
        System.out.println("True");
        return true;
    }




    public static void main(String[] args) {
        OneAway("pale","ple");
        OneAway("pales","pale");
        OneAway("pale","bale");
        OneAway("pale","bake");
    }
}
