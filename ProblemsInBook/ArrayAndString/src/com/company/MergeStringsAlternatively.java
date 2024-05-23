//You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
//
//Return the merged string.
//
//
//
//Example 1:
//
//Input: word1 = "abc", word2 = "pqr"
//Output: "apbqcr"
//Explanation: The merged string will be merged as so:
//word1:  a   b   c
//word2:    p   q   r
//merged: a p b q c r
//Example 2:
//
//Input: word1 = "ab", word2 = "pqrs"
//Output: "apbqrs"
//Explanation: Notice that as word2 is longer, "rs" is appended to the end.
//        word1:  a   b
//word2:    p   q   r   s
//merged: a p b q   r   s
//Example 3:
//
//Input: word1 = "abcd", word2 = "pq"
//Output: "apbqcd"
//Explanation: Notice that as word1 is longer, "cd" is appended to the end.
//        word1:  a   b   c   d
//word2:    p   q
//merged: a p b q c   d
class Solution {

    public String mergeAlternately(String word1, String word2) {
        int w1Length = word1.length();
        int w2Length = word2.length();
        // get the longer string
        int longestLength = 0;
        if (w2Length > w1Length){
            longestLength = w2Length;
        }else {
            longestLength = w1Length;
        }
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < longestLength ;i++){
            if (w1Length > 0){
                result.append(word1.charAt(i));
                w1Length--;
            }
            if (w2Length >0){
                result.append(word2.charAt(i));
                w2Length--;
            }
        }
        return result.toString();
    }
}