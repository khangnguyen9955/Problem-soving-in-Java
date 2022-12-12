package com.company;

// implement a method to perform basic string compression using the counts
// of repeated characters. For example, the string "aabcccccaaa" would become a2b1c5a3.
// if the "compressed" string would not become smaller than the original string, your method should return the original string
// you can assume the string has only uppercase and lowercase letters (a-z)
public class Main {
    public static String compressBad(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            cnt++;
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) { // next character != current
                stringBuilder.append(str.charAt(i));
                stringBuilder.append(cnt);
                cnt = 0; // reset to new character
            }
        }
        return stringBuilder.length() > str.length() ? str : stringBuilder.toString();

    }
    public static void main(String[] args) {
	// write your code here
    }
}
