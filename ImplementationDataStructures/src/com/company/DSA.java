package com.company;

import java.util.Scanner;

public class DSA {



    public void printArray(int [] arr){
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
     DSA array = new DSA();
        Scanner sc = new Scanner(System.in);
        System.out.println("Input n: ");
        int n = sc.nextInt();
        int [] arr= new int[n];
        for (int i = 0; i < n ; i++) {
            arr[i] = sc.nextInt();
        }
        array.printArray(arr);
        System.out.println();
        System.out.println("input the index of element that you want to add: ");
        // 1 2 3 4 5 6
        // 1 2 3 7 4 5 6
        int k = sc.nextInt();
        System.out.println("input the element that you want to add: ");
        int l = sc.nextInt();
        int [] arr1= new int[n+1];
        for (int i = 0; i < k ; i++) {
            arr1[i] = arr[i];
        }
        arr1[k] = l;
        int j = k;
        for (int i = k+1; i < arr1.length; i++,j++) {
            if(j < arr.length){
            arr1[i] = arr[j];}
        }
        array.printArray(arr1);


    }


}
