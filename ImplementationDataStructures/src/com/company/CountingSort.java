package com.company;

public class CountingSort {

    void countingSort(int arr[])
    {
        int n = arr.length;

        int output[] = new int[n];
        int count[] = new int[n+1];

        // initialize each elements in count = 0
        for (int i = 0; i < n; ++i)
            count[i] = 0;


        // arr[i] tuc la gia tri o vi tri i => tim vi tri co gia tri = arr[i] va ++ no len
        for (int i = 0; i < n; ++i)
            ++count[arr[i]];

        //  i = i + i-1
        // dung de luu gia tri dem truoc do
        // de biet duoc minh da dem bao nhieu ptu
        for (int i = 1; i <=n; ++i)
            count[i] += count[i - 1];

        // lay gia tri tai arr[i] va di den count[arr[i]]
        // sau do di den output[count[arr[i]]]
        // roi gan gia tri arr[i] cho thang output[count[arr[i]]]
        // sau do -1 thang count[arr[i]] di vi da sap xep so do vao 1 vi tri roi


        for (int i = 0; i< n; i++) {
            output[count[arr[i]]-1] = arr[i];
            --count[arr[i]];
        }


        for (int i = 0; i < n ; i++) {
            arr[i] = output[i];
        }


    }




    public static void main(String args[])
    {
        CountingSort test = new CountingSort();
        int arr[] = { 1,4,1,2,7,5,2};

        test.countingSort(arr);

        System.out.print("Sorted  array is ");
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i]);
    }
}
