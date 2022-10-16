package com.company;

public class IsUnique {

 // Question: Implement an algorithm to determine a string has all unique characters, and what if we cannot use additional data structures?
    // solution:
    // clarify the string is ASCII string or unicode ?
    // and we assume this is ASCII
    // it's also okay to assume the boolean to 256 chars, this is extended ASCII.
    // Clarify it!

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

    // time: 0(n)
    // space: O(1)
    // Could argue that the time complexity is O(1) since the loop never iterate through more than 128 chars (for sure)
    // if we didnt want to assume the char set is fixed, we could express the complexity as O(c) space, and O(min(c,n)) time or O(c) time
    // where c is the size of the char set
    // Now we can reduce our space usage by a factor of eight by using a bit vector.
    // we will assume that the string only uses the lowercase letters from a to z. This will allow us to use a single int.

    public static boolean isUnique2(String s){
        int checker = 0; // create a hash table (?) by integer, actually an integer is an array with 32 bit (4 bytes * 8)
        for (int i = 0; i < s.length() ; i++) {
            int val = s.charAt(i);
            if ((checker & (1 << val)) > 0){
                return false;
            }
            checker |= (1<<val);
            // checker |= (1 << val); // set flag at index val to true
            // for example val of "a"
            // it will be
            // 00000000000000000000000000000001
            // checker=
            // 00000000000000000000000000000000 (checker = 0 at first)
            // now checker becomes
            //checker=
            // 00000000000000000000000000000001
            // so forth
            // when the "a" appear again
            // a
            // 00000000000000000000000000000001
            // checker
            // 00000000000000000000000000000001
            // with the condition  if ((checker & (1 << val)) > 0){
            // checker & (1<<val) will be 1 ,and it is greater than 0
            // because the & will copy over a "1" only if both checker and 1<<val have a "1" at that index

        }
        return true;
    }

    public static void main(String[] args) {
        isUnique2("test");
        isUnique("Test");
        isUnique("abc");
        isUnique("Hello");

    }
}
