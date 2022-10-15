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



    public static int maxSubArray(int []nums){
            int max = Integer.MIN_VALUE;
            int maxEnd = 0;

        for (int i = 0; i < nums.length; i++) {
            maxEnd += nums[i];

            max = maxEnd > max ? maxEnd : max;
        if(maxEnd < 0 ){
            maxEnd = 0;
        }
        }
        return max;
    }



    public static void main (String []args){
//        int [] nums = {0,0,1,1,1,2,2,3,3,4};
//        removeDuplicates(nums);
        int [] nums = {-3,-5,-3,-1,-2,-3,-5,-3};
        maxSubArray(nums);
    }

}
