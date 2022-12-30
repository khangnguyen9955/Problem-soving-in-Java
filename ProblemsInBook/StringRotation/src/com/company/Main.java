package com.company;

public class Main {
    // String Rotation: Assume you have a method isSubstring which checks if one word is a substring
    // of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call
    // to isSubstring
    // e.g, "waterbottle" is a rotation of "erbottlewat"


    // solution:
    // we cut s1 into 2 parts
    // s1 = x+y = waterbottle
    // as the point we rotate the string
    // x = wat
    // y = erbottle
    // s2 = y+x = erbottlewat
    // so basically we need to check if there's a way to split s1 into x and y such that xy=s1 and yx=s2
    // we can see that yx will always be a substring of x"yx"y
    // that is s2 will always be a substring of s1s1

    public static boolean isRotation(String s1, String s2){
        if(s1.length() == s2.length() && s1.length()>0){
            String s1s1 = s1+s1;
            return isSubstring(s1s1,s2);
        }
        return false;
    }
    public static void main(String[] args) {
	// write your code here


    }
}
