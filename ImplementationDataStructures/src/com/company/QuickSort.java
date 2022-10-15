package com.company;

public class QuickSort {

    public static void quicksort(int [] A, int p , int r){
        if (p<r) {
            int q = partition(A, p, r);
            quicksort(A, p, q - 1);
            quicksort(A, q + 1, r);
        }
    }


    public static int partition(int[] A, int p , int r){
            int i = p-1;
            int x = A[r]; //pivot

        for (int j = p; j <= r-1 ; j++) {
            if(A[j] < x){
                i++;

                // swap nhung so nho hon x qua ben trai
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        // tu 0 den i chac chan se pha inho hon A[r] (tru khi array dang duoc sort nguoc)
        // loop xong , ta se swap thang lon hon dau tien ve cuoi cung va dem thang A[r] qua ben trai
        int temp = A[i+1];
        A[i+1] = A[r];
        A[r] = temp;
        return i+1; // return ra vi tri pivot !!
    }


    public static void main (String [] args){
        int [] arr = {10,9,8,7,6};
        quicksort(arr,0,(arr.length)-1);


    }




}
