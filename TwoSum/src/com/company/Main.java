package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        System.out.println("Input target");
        int target = sc.nextInt();

        System.out.println("input total nums");
        int n = sc.nextInt();
        int [] nums = new int[n];

        for(int i = 0 ;i<nums.length;i++){
            nums[i] = sc.nextInt();
        }

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        int [] results = new int [2];

        int temp = 0;
        for(int i = 0; i<nums.length;i++){
            temp = target-nums[i];
            if(map.containsKey(temp)){
                results[0] = i;
                results[1] = map.get(target-nums[i]);
//                return results;
            }
            map.put(nums[i],i);
        }





    }
}
