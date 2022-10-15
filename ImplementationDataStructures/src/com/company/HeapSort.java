package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class HeapSort {

    int Parent(int i){
         return i/2;
     }
     int Left(int i){
         return 2*i + 1;
     }
     int Right(int i){
         return 2*i +2;
     }

   void MaxHeapify(int [] A,int n, int i){
         int l = Left(i);
         int r = Right(i);
         int largest = i;
         if(l <  n && A[l] > A[largest]){
                largest = l;
         }
         if (r < n && A[r] >A[largest]){
             largest = r;
         }
         if (largest != i){
             int swap =A[i];
             A[i] =A[largest];
             A[largest] = swap;
             MaxHeapify(A,n,largest);
         }
     }
     void BuildMaxHeap(int [] A) {
        int n = A.length;
        for (int i =A.length/2 -1 ;i>=0;i--){
            MaxHeapify(A,n,i);
        }
     }
     // heapsort
     void HeapSort (int[] A){
        BuildMaxHeap(A);
        int n = A.length;
        for(int i = A.length - 1; i >=1;i--){
            int swap =A[i];
            A[i] = A[0];
            A[0] = swap;
            n= n-1;
            MaxHeapify(A,n,0);
        }
     }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


    public static void main(String[] args) {
	 // write your code here
        int [] arr = {3,2,3,1,2,4,5,5,6};
        HeapSort heap = new HeapSort();
        // 16 4 10 14 7 9 3 2 8 1

        Arrays.sort(arr);
        // test maxheapify
//        heap.MaxHeapify(arr,arr.length,1);

        // test buildMaxheap
        // 4 1 3 2 16 9 10 14 8 7
//        heap.BuildMaxHeap(arr);

        heap.HeapSort(arr);
        printArray(arr);

    }
}
