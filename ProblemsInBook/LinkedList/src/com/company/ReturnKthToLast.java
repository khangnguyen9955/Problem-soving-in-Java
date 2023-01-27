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
    // But this solution is only valid if the interviewer accepts it

    // Secondly, we can create a class Index to wrap the counter value and return it
    public class Index {
        public int value = 0;
    }
    RemoveDups.LinkedListNode kthToLast (RemoveDups.LinkedListNode head, int k){
        Index idx = new Index();
        return kthToLast(head,k,idx);
    }

    RemoveDups.LinkedListNode kthToLast(RemoveDups.LinkedListNode head, int k ,Index index){
        if(head==null){
            return null;
        }
        RemoveDups.LinkedListNode node  = kthToLast(head.next,k,index);
        index.value = index.value+1;
        if(index.value == k){
            return head;
        }
        return node;
    }
// This takes O(n) space due to recursive calls

    public static void main(String[] args) {

    }
}
