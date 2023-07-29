package com.company;

import com.company.RemoveDups.LinkedListNode;

public class SumList {
  /*
   * Problem: You have two numbers represented by a linked list, where each node
   * contains a single digit. The digits
   * are stored in reverse order, such that the 1's digit is at the head of the
   * list. Write a function that adds the
   * two numbers and returns the sum as a linked list.
   * EXAMPLE
   * Input: (7->1->6) + (5->9->2). That is, 617 + 295
   * Output: 2->1->9. That is, 912
   * FOLLOW UP
   * Suppose the digits are stored in forward order. Repeat the above problem.
   * EXAMPLE
   * Input: (6->1->7) + (2->9->5). That is, 617 + 295
   * Output: 9->1->2. That is, 912
   */

  // Solution 1: we just need to add the number and put the "excess" value to the
  // next node
  public static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
    if (l1 == null && l2 == null && carry == 0) {
      return null;
    }

    int value = carry;
    LinkedListNode result = new LinkedListNode();
    if (l1 != null) {
      value += l1.data;
    }
    if (l2 != null) {
      value += l2.data;
    }
    result.data = value % 10; // get remainder
    LinkedListNode next = new LinkedListNode();
    if (l1 != null || l2 != null) {
      // checking null
      next = addLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next, value >= 10 ? 1 : 0);
    }
    result.next = next;
    return result;
  }
  // in the implementation above, we did not handle the case when one linked list
  // is shorter than other
  // for example 7->1->6
  // ADD: 5->9
  // it must be 7 1 6
  // + 5 9
  // 7 5
  /*
   * Follow Up:
   */

  public static class PartialSum {
    public LinkedListNode sum = null;
    public int carry = 0;
  }

  public static LinkedListNode addLists2(LinkedListNode l1, LinkedListNode l2) {
    int len1 = length(l1);
    int len2 = length(l2);
    // check the shorter and add 0 to it
    if (len1 < len2) {
      l1 = pad(l1, len2 - len1);
    } else {
      l2 = pad(l2, len1 - len2);
    }
    PartialSum sum = addListHeper(l1, l2);
    if (sum.carry == 0) {
      return sum.sum;
    } else {
      LinkedListNode result = insertBefore(sum.sum, sum.carry);
      return result;
    }

  }

  public static PartialSum addListHeper(LinkedListNode l1, LinkedListNode l2) {
    if (l1 == null && l2 == null) {
      PartialSum sum = new PartialSum();
      return sum;
    }

    // add smaller digits recursively
    PartialSum sum = addListHeper(l1.next, l2.next);

    // add carry to current data
    int val = sum.carry + l1.data + l2.data;

    // insert sum of current digits and the carry
    LinkedListNode result = insertBefore(sum.sum, val % 10);

    // return the sum and its carry value
    sum.sum = result;
    sum.carry = val / 10;
    return sum;
  }

  public static int length(LinkedListNode l1) {
    int len = 0;
    while (l1 != null) {
      l1 = l1.next;
      len++;
    }

    return len;
  }

  public static LinkedListNode pad(LinkedListNode l1, int padding) {
    LinkedListNode head = l1;
    for (int i = 0; i < padding; i++) {
      head = insertBefore(head, 0);
    }
    return head;
  }

  public static LinkedListNode insertBefore(LinkedListNode list, int data) {
    LinkedListNode node = new LinkedListNode(data);
    if (list != null) {
      node.next = list;
    }
    return node;
  }

  public static void main(String[] args) {
    // TEST
    LinkedListNode l1 = new LinkedListNode(7);
    l1.next = new LinkedListNode(1);
    l1.next.next = new LinkedListNode(6);
    LinkedListNode l2 = new LinkedListNode(5);
    l2.next = new LinkedListNode(9);
    // RemoveDups.LinkedListNode result = addLists(l1,l2,0);
    LinkedListNode res = addLists2(l1, l2);
    while (res != null) {
      System.out.print(res.data);
      res = res.next;
    }

  }
}
