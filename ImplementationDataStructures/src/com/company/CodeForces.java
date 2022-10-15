package com.company;

import java.util.Scanner;

public class CodeForces{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int  a= 0;
        for(int i=0; i<n; i++){
            int sum = 0;
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            sum += x+y+z;
            if(sum>1){
                a+= 1;
            }
        }
        System.out.println(a);
    }
}