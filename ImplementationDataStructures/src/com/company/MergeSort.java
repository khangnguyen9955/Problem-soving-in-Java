package com.company;

public class MergeSort {

    void merge(int arr[], int l, int m, int r ){
        // find sizes of two subarrays => create temp arrays => copy value to those temp arrays
        int n1= m - l +1;
        int n2 = r - m;
        int L[] = new int [n1];
        int R[] = new int[n2];
        for(int i = 0 ; i< n1;i++){
            L[i] = arr[l+i]; // copy values from 0 to mid
        }
        for (int i = 0; i < n2; i++) {
            R[i] = arr[m+1+i]; // copy values from mid +1 to right
        }
        int i = 0,j = 0;
        int k = l;  // index of merged array
        while(i<n1 &&  j < n2){
            if (L[i] <= R[j]){
                arr[k] =  L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        // copy remaining values to merged array
        while(i<n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j<n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    void sort (int arr[], int l , int r){
        if(l<r){

            int mid = l+(r-l)/2;
            sort(arr,l,mid);
            sort(arr,mid+1,r);

            merge(arr,l,mid,r);
        }
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}
