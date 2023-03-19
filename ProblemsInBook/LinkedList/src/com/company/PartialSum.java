package com.company;

public class PartialSum {
/*
Follow up
*/
public RemoveDups.LinkedListNode sum = null;
public int carry = 0;
static RemoveDups.LinkedListNode addLists(RemoveDups.LinkedListNode l1, RemoveDups.LinkedListNode l2){
    int len1= length(l1);
    int len2= length(l2);

    // Pad the shorter list with zeros
    if(len1 < len2){
        l1 = padList(l1,len2-len1);
    }else {
        l2  = padList (l2, len1-len2);
    }

    // Add lists
    PartialSum sum = addListHelper(l1,l2);

    // If there was a carry left over, insert this at the front of the list
    // otherwise, just return the linked list.
    if (sum.carry == 0 ){
        return sum.sum;
    }
    else{
        RemoveDups.LinkedListNode result = insertBefore(sum.sum, sum.carry);
        return  result;
    }
}

static PartialSum addListHelper(RemoveDups.LinkedListNode l1, RemoveDups.LinkedListNode l2){
    if(l1 == null && l2 == null){
        PartialSum sum = new PartialSum();
        return sum;
    }
    // Add smaller digits recursively
    PartialSum sum = addListHelper(l1.next,l2.next);

    // Add carry to current data
    int val = sum.carry + l1.data + l2.data;

    // Insert sum of current digits
    RemoveDups.LinkedListNode full_result = insertBefore(sum.sum, val%10);

    // Return the sum so far, and the carry value
    sum.sum = full_result;
    sum.carry = val/10;
    return sum;
}
// Pad list with zeros
static RemoveDups.LinkedListNode padList(RemoveDups.LinkedListNode l1, int padding){
     RemoveDups.LinkedListNode head = l1;
     for (int i = 0; i < padding ; i++) {
         head = insertBefore(head,0);
     }
     return head;
 }

 // helper function to insert node in front of the linked list
    static RemoveDups.LinkedListNode insertBefore(RemoveDups.LinkedListNode list, int data){
        RemoveDups.LinkedListNode node = new RemoveDups.LinkedListNode(data);
        if(list != null){
            node.next = list;
        }
        return node;
    }
    public static  int length (RemoveDups.LinkedListNode l){
    int cnt =0;
    while(l != null){
        cnt++;
        l= l.next;
    }
    return cnt;
    }


}


