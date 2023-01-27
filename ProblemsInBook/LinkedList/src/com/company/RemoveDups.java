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
    // This solution takes O(n) time, where N is the number of elements
    // but this takes O(n) space due to using hash table

    // Follow up: No buffer allowed
    public static void deleteDupsNoBuffer (LinkedListNode head){
        LinkedListNode current = head;
        while (current != null){
            LinkedListNode runner = current;
            // check all the rest elements is same with current or not
            while(runner.next != null){
                if(runner.next.data == current.data){
                    runner.next = runner.next.next;
                }else{
                    runner = runner.next;
                }
            }
            //checking done
            current = current.next; // move current
        }
    }
    // This solution will take O(1) space, but will run in O(n^2) time

    public static void main(String[] args) {
	// write your code here
    }
}
