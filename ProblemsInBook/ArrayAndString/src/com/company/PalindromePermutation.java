package com.company;

public class PalindromePermutation {
    // Given a string, write a function to check if it is a permutation of a palindrome.
    // A palindrome is a word or phrase that is the same forwards and backwards.
    // A permutation is a rearrangement of letters. The palindrome does not
    // need to be limited to just dictionary words.

    // Example
    // input: Tact Coa
    // output: true (permutations: "taco cat", "atco cta", etc.)
    //       |
    // t a c o c a t
    //       |
    // a t c o  c t a
    // 2 sides are the same letters

    // so basically we cannot have 2 odd letters in our string right?
    // if we got even string // for example: aaab = odd + odd = even length
    // aabb = even + even = even length
    // aab = even + odd = odd length
    // the even string cannot have an odd number of unique characters
    // even = even + even || odd + odd
    // odd = odd + even
    public static int getCharNumber(char c){
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int cValue = Character.getNumericValue(c);
        if (cValue >= a && cValue <= z){ // check character c is from a-z
            return cValue - a ;
        }
        return -1;
    }
    public static boolean isPermutationOfPalindrome(String str ){
        int[] table = new int [ Character.getNumericValue('z') - Character.getNumericValue('a') + 1 ];
        boolean foundOdd = false;
        // mapping the characters to the table
        for (char c: str.toCharArray()
             ) {
            int cValue = getCharNumber(c);
            if(cValue != -1){
                table[cValue]++;
            }
        }

        for (int c: table){
                if(c % 2 != 0){
                    if (foundOdd){
                        return false;
                    }else{
                    foundOdd = true;
                    }
                }
        }
        return true;
    }
    public static void main(String[] args) {
        if(isPermutationOfPalindrome("Tact Coa")){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }

    }
}
