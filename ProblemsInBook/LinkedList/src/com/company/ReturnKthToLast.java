package com.company;

public class ReturnKthToLast {
    // Return Kth To Last: Implement an algorithm to find the kth to last element of a singly linked list

    // There are many solutions for this problem
    // Firstly, we just simply print the Kth to last element.
    // Then, we can pass back the value of the counter simply through return values;
    // But this solution will return an Integer, not a node

    int printKthToLast(RemoveDups.LinkedListNode head, int k){
        if(head == null){
            return 0;
        }
        int index = printKthToLast(head.next,k)+ 1;
        if (index==k){
            System.out.println(k+ "th to last node is: " + head.data);
        }
        return index;
    }



    public static void main(String[] args) {

    }
}
