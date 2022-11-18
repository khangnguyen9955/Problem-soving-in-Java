package com.company;

public class URLify {
    // write a method to replace all spaces in a string with "%20".
    // assume that the string has sufficient space at the end to hold the additional characters
    // and that you are given the "true" length of the string
    // Note: if implementing in Java, please use a character array so that you can perform this operation in place
    // Example:
    // input: "Mr John Smith    ", 13
    // Mr = 2, ' ' = 1, John = 4, ' ' = 1, Smith = 5
    // trueLength = 13
    // str.length = 17;
    // output:"Mr%20John%20Smith"

    static void replacePlaces(char[] str, int trueLength){
        int spaceCount = 0 , index = 0;
        for (int i = 0; i < trueLength ; i++) {
            if (str[i] == ' '){
                spaceCount++;
            }
        }
        index = trueLength + spaceCount * 2; // spaceCount * 2 because we will replace by "%" +"20"
        // index = 17
        if(trueLength < str.length) str[trueLength] = '\0';

        for (int i = trueLength - 1; i >= 0 ; i--) {
            if(str[i] == ' '){
                str[index-1] = '0';
                str[index-2] = '2';
                str[index-3] = '%';
                index-=3;
            }else{
                str[index-1] = str[i];
                index--;
            }
        }
        System.out.println(str);
    }

    public static void main(String[] args) {
        replacePlaces("Mr John Smith    ".toCharArray(), 13);
        replacePlaces("Mr Khang Nguyen Ne Ku        ".toCharArray(),21);
        
    }
}
