package com.company;

// implement a method to perform basic string compression using the counts
// of repeated characters. For example, the string "aabcccccaaa" would become a2b1c5a3.
// if the "compressed" string would not become smaller than the original string, your method should return the original string
// you can assume the string has only uppercase and lowercase letters (a-z)
public class StringCompression{
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

    // improve this problem a little
    // instead of create Stringbuilder and then if this stringbuilder length is larger than the original
    // it is wasteful
    // now we just check it first
    // but it will be duplicated code and we have second loop
    public static String compress(String str){
        int finalLength = countCompression(str);
        if(finalLength >= str.length()){
            System.out.println(str);
            return str;}
        StringBuilder stringBuilder = new StringBuilder(finalLength);
        int cnt =0;
        for (int i = 0; i < str.length(); i++) {
            cnt++;
            if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)){
                stringBuilder.append(str.charAt(i));
                stringBuilder.append(cnt);
                cnt=0;
            }
        }
        System.out.println(stringBuilder.toString());
        return  stringBuilder.toString();
    }
    public static int countCompression(String str){
        int cntCompressed= 0;
        int cnt =0;
        for (int i = 0; i < str.length(); i++) {
            cnt++;
            if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)){
                cntCompressed += 1 + String.valueOf(cnt).length(); // +1 means a character + valueof(cnt).length means "1" will be 1
                // "10" will be 2 characters.
                cnt=0;
            }
        }
        return cntCompressed;
    }
    public static void main(String[] args) {
        compress("abbbbcccddeef");
    }
}
