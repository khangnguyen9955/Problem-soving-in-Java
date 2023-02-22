package com.company;

import java.util.HashMap;

public class Practice {
    public static int removeDuplicates(int[] nums) {
            int n = nums.length;
            int j = 0;

         for (int i = 1; i < n; i++) {
            if(nums[i] > nums[j]){
                    nums[++j] = nums[i];
            }
        }
            return j+1;
    }



    // 10. Regular Expression Matching Leetcode
    public static boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        boolean [][] dp = new boolean [n+1][m+1];
        dp[0][0] = true;
        // 0 0 in 2 string will be match 
        // cause nothing there :)
        for(int j = 1 ; j <= m; j++){
            if(p.charAt(j-1) == '*') { // check * in first row
                dp[0][j] = dp[0][j-2];
                // assign to true
            }
        }

        for(int i =1 ; i<= n ; i++){
            for (int j = 1 ; j<=m;j++){
                char sC = s.charAt(i-1);
                char pC = p.charAt(j-1);
                if(sC == pC || pC == '.'){ // if current char in 2 string match, or p char is "."
                    dp[i][j] = dp[i-1][j-1]; // whether the rest of s and p is matched?
                }
                else if (pC == '*'){ // if  p char is ""*", there will be 2 cases to consider
                char prevP = p.charAt(j-2); // get previous char of current p 
                    if(prevP != sC && prevP != '.') // if previous character of P is not same with s character
                    // and prevP is not '.' => obviously these 2 characters will not be matched
                    {
                        dp[i][j]=dp[i][j-2];
                        // dp[i][j-2] == skips || false
                    }
                    else{
                        // means match
                        // so with this "*" we can skip or get previous characters of s
                        dp[i][j] = dp[i][j-2] || dp[i-1][j];
                    }
                }
            }
        }
        return dp[n][m];

    }

    public static int maxArea(int [] height){
        int maxArea = 0;
        int left =0;
        int right = height.length-1;
        while (left < right){
            int area = Math.min(height[left],height[right]) * (right-left); // calculate the area
            // min height[l] or height[r]
            // cause we can only contain the water as its min height
            
            maxArea = Math.max(maxArea, area); // get max so far

            // move 2 pointers
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }








    public static void main (String []args){
//        int [] nums = {0,0,1,1,1,2,2,3,3,4};
//        removeDuplicates(nums);
        // int [] nums = {-3,-5,-3,-1,-2,-3,-5,-3};
        // maxSubArray(nums);
        isMatch("abc","a*b*c");
    }

}
