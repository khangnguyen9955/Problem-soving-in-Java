package com.company;

import com.company.RemoveDups.LinkedListNode;

import java.util.Stack;

public class Palindrome {
    /*
    Problem: Implement a function to check if a linked list is a palindrome.
     */

    // we can simply reverse the list and compare vs the original list
    // 1 -> 2 -> 3 -> 2 -> 1
    // then we will reverse the list and compare
    // 1 <- 2 <- 3 <- 2 <-1
    boolean isPalindrome(LinkedListNode head) {
        LinkedListNode reversedList = reversed(head);
        return isEqual(head, reversedList);
    }

    LinkedListNode reversed(LinkedListNode node) {
        LinkedListNode head = null;
        while (node != null) {
            LinkedListNode n = new LinkedListNode(node.data);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    boolean isEqual(LinkedListNode l1, LinkedListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.data != l2.data) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }

    // actually we only need to compare the first half of the list with the second half
    // so if we want to reverse front half of list we need to use a stack
    // if we know the size of linked list, we can iterate through the first half of elements in a standard for loop
    // if we don't know the size of linkedlist, we can iterate through the linked list, using fast runner and slow runner technique
    // onto a stack

    boolean isPalindrome2(LinkedListNode head) {
        LinkedListNode fast = head;
        LinkedListNode slow = head;
        Stack<Integer> stack = new Stack<Integer>();
        while (fast != null && fast.next != null){
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }
        // 1 -> 2 -> 3 -> 4 -> 3 -> 2 -> 1
        // f         f         f         f
        // s    s    s    s
        while(fast != null){
            // mean that fast pointer is at the end and
            // slow pointer is at the middle now we skip slow pointer to the next node
            slow = slow.next;
        }
        while(slow!=null){
            // now pop the node in stack out and compare with slow pointer now
            int top = stack.pop().intValue();
            if(top != slow.data){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
