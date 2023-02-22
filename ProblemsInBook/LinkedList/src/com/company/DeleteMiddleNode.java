package com.company;

public class DeleteMiddleNode {
 /*
  Problem: Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node
  not necessarily the exact middle) of a singly linked list, given only access to that node.
  Example:
  Input: the node c from the linked list a->b->c->d->e->f
  Result: nothing is returned, but the new linked list looks like a->b->d->e->f


   This simply like we have to delete the node that we are given (?) rather than delete middle node
  */

    public static boolean DeleteNode (RemoveDups.LinkedListNode n){
        if(n==null || n.next == null){
            // base case
            // n.next == null means last node
            return false;
        }
        RemoveDups.LinkedListNode next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }
 public static void main(String[] args) {


     RemoveDups.LinkedListNode node1 = new RemoveDups.LinkedListNode(1);
     RemoveDups.LinkedListNode node2 = new RemoveDups.LinkedListNode(2);
     RemoveDups.LinkedListNode node3 = new RemoveDups.LinkedListNode(3);
     RemoveDups.LinkedListNode node4 = new RemoveDups.LinkedListNode(4);
     node1.next = node2;
     node2.next = node3;
     node3.next= node4;
     DeleteNode(node1);
     RemoveDups.LinkedListNode test = node1;

         while(test!= null){
         System.out.println(test.data);
         test=test.next;
         }
    }
}
