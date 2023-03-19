package com.company;

public class SumList {
    static RemoveDups.LinkedListNode addLists(RemoveDups.LinkedListNode l1, RemoveDups.LinkedListNode l2, int carry){
        if (l1 == null && l2 == null && carry == 0 ){
            return null;
        }

        int value = carry;
        RemoveDups.LinkedListNode result = new RemoveDups.LinkedListNode();
        if(l1 != null){
            value+= l1.data;
        }
        if(l2 != null){
            value += l2.data;
        }
        result.data = value % 10; // get remainder
        RemoveDups.LinkedListNode next = new RemoveDups.LinkedListNode();
        if(l1!=null || l2 != null){
            // checking null
            next = addLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next, value >= 10 ? 1 : 0);
        }
        result.next = next;
return result;
    }
    // in the implementation above, we did not handle the case when one linked list is shorter than other
    // for example 7->1->6
    // ADD:        5->9
    // it must be 7 1 6
    //           +  5 9
    //              7 5
    /*
    Follow Up:

     */



    public static void main(String[] args) {
        // TEST
        RemoveDups.LinkedListNode l1 = new RemoveDups.LinkedListNode(7);
        l1.next = new RemoveDups.LinkedListNode(1);
        l1.next.next = new RemoveDups.LinkedListNode(6);
        RemoveDups.LinkedListNode l2 = new RemoveDups.LinkedListNode(5);
                l2.next = new RemoveDups.LinkedListNode(9);
//        RemoveDups.LinkedListNode result = addLists(l1,l2,0);
        RemoveDups.LinkedListNode res = PartialSum.addLists(l1,l2);
        while(res!= null){
            System.out.println(res.data);
            res=res.next;
        }




    }
}
