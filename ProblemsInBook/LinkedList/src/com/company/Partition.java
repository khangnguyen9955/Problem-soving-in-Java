package com.company;

import com.company.RemoveDups.LinkedListNode;

public class Partition {

  /*
   * Partition: Write code to partition a linked list around a value x, such that
   * all nodes less than x come before all nodes grater than or equal to x.
   * if x is contained within the linked list, the values of x only need to be
   * after the elements less than x.
   * The partition element x can appear anywhere in the "right partition", it does
   * not need to appear between the left and right partition
   */

  /*
   * So with this problem, we can create 2 linked lists that represent left
   * partition and right partition then merge them into 1
   * This approach is mostly "stable" in t hat elements stay in their original
   * order, other than the necessary movement the partition
   */

  static LinkedListNode partition(LinkedListNode node, int x) {
    LinkedListNode beforeStart = null;
    LinkedListNode beforeEnd = null;
    LinkedListNode afterStart = null;
    LinkedListNode afterEnd = null;

    while (node != null) {
      LinkedListNode next = node.next;
      node.next = null;
      if (node.data < x) {
        if (beforeStart == null) {
          beforeStart = node;
          beforeEnd = beforeStart;
        } else {
          beforeEnd.next = node;
          beforeEnd = node;
        }
      } else {
        if (afterStart == null) {
          afterStart = node;
          afterEnd = afterStart;
        } else {
          afterEnd.next = node;
          afterEnd = node;
        }
      }
      node = next;
    }
    if (beforeStart == null) {
      return afterStart;
    }
    beforeEnd.next = afterStart;
    return beforeStart;
  }
  /*
   * Second approach:
   * if we dont care about making elemetns of the list "stable", then we can
   * instead rearrange the elements by growing the list at the head and tail
   * this approach, we start with a "new" list, usign the existing nodes.
   * elements bigger than the pivot element are put at the tail and elements
   * smaller put at head, each time we insert an element,
   * we update either the head or tail.
   */

  static LinkedListNode partition2(LinkedListNode node, int x) {
    LinkedListNode head = node;
    LinkedListNode tail = node;
    while (node != null) {
      LinkedListNode next = node.next;
      if (node.data < x) {
        // insert node at head
        node.next = head;
        head = node;
      } else {
        tail.next = node;
        tail = node;
      }
      node = next;
    }
    tail.next = null;
    return head;
  }

  public static void printing(LinkedListNode node) {
    while (node != null) {
      System.out.print(node.data + " ");
      node = node.next;
    }
  }

  public static void main(String[] args) {
    LinkedListNode node = new LinkedListNode(3);
    LinkedListNode node1 = new LinkedListNode(5);
    LinkedListNode node2 = new LinkedListNode(8);
    LinkedListNode node3 = new LinkedListNode(5);
    LinkedListNode node4 = new LinkedListNode(10);
    LinkedListNode node5 = new LinkedListNode(2);
    LinkedListNode node6 = new LinkedListNode(1);
    node.next = node1;
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;
    node6.next = null;
    printing(node);
    partition(node, 5);
    System.out.println();

    printing(node);
    System.out.println();

    printing(partition2(node, 5));
  }

}
