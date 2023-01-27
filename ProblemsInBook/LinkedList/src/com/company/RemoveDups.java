package com.company;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.HashSet;
import java.util.LinkedList;

public class RemoveDups {
    // Remove Dups: Write code to remove duplicates from an unsorted linked list
    // Follow up: How would you solve this problem if a temporary buffer is not allowed?
    public class LinkedListNode {
        int data;
        LinkedListNode next;
        LinkedListNode previous;
    }
    public static void deleteDups(LinkedListNode n){
        HashSet<Integer> set = new HashSet<Integer>();
        LinkedListNode previous = null;
        while (n!=null){
            if(set.contains(n.data)) { // if contained, duplicated element
               previous.next = n.next; // skip this element, point to next of this element
            }
            else{
                set.add(n.data); // add to hash table
                previous = n; // move pre pointer to this elem
            }
            n = n.next;
        }
    }

    public static void main(String[] args) {
	// write your code here
    }
}
