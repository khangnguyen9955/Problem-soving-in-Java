package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int n = sc.nextInt();
        int [] nums = new int[n];
        for(int i = 0 ;i<n;i++){
            nums[i] = sc.nextInt();
        }

        int result;
        int h = nums.length - 1;
        int l = 0;
        int mid;
        if(h==l){
            if(nums[0] == target){
                System.out.println("return cmm de");
            }
        }
        while(h>=l){
            mid = (h+l)/2;
            if(nums[mid] == target){
                System.out.println("return mid" + mid);
            }
            if( nums[l] <= nums[mid]){
                if (nums[l] <= target && target < nums[mid]){
                    h = mid-1;
                }else {
                    l = mid+1;
                }
            }
            else {
                if(nums[mid] < target && target <= nums[h]) {
                    l = mid+1;
                }
                else {
                    h = mid-1;
                }
            }
            }

        System.out.println("return -1");

    }
}
