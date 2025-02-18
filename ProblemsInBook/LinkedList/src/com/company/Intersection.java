package com.company;
// Problem: Given two (singly) linked lists, determine if the two lists
// intersect. Return the intersecting node. Note that the intersection is
// defined based on reference, not value. That is, if the kth node of the first
// linked list is the exact same node (by reference) as the jth node of the
// second linked list, then they are intersecting.
//

import com.company.RemoveDups.LinkedListNode;

public class Intersection {

  LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode list2) {
    if (list1 == null || list2 == null) return null; // base case
    int length1 = getLength(list1);
    int length2 = getLength(list2);

    LinkedListNode tailNode1 = getTailNode(list1);
    LinkedListNode tailNode2 = getTailNode(list2);
    if(tailNode1.data != tailNode2.data ){
      return null;
    }

    LinkedListNode shorter = length1 < length2 ? list1 : list2;
    LinkedListNode longer = length1 < length2 ? list2 : list1;

    longer = getKthNode(longer,Math.abs(length1-length2)); // move the longer linkedlist to k node

    while(shorter != longer){
      shorter = shorter.next;
      longer = longer.next;
    }
    System.out.println(longer.data);
    return longer;
  }


   LinkedListNode getTailNode(LinkedListNode list) {
    if(list == null) return null;
    int size = 1;
    LinkedListNode currentNode = list;
    while(currentNode.next != null){
      currentNode = currentNode.next;
      size++;
    }
    return currentNode;
   }


  int getLength(LinkedListNode list) {
    int length = 0;
    while (list != null) {
      length++;
      list = list.next;
    }
    return length;
  }

  LinkedListNode getKthNode (LinkedListNode head, int k ){
    LinkedListNode current = head;
    while( k > 0 && current != null){
      current = current.next; // move
      k--;
    }
    return current;


  }


  public static void main(String[] args) {
    LinkedListNode list1 = new LinkedListNode(1);
    LinkedListNode node2List1 = new LinkedListNode(2);
    list1.next = node2List1;
    LinkedListNode node3List1 = new LinkedListNode(3);
    node2List1.next = node3List1;
    LinkedListNode node4List1 = new LinkedListNode(4);
    node3List1.next = node4List1;
    LinkedListNode node5List1 = new LinkedListNode(5);
    node4List1.next = node5List1;
    LinkedListNode node6List1 = new LinkedListNode(6);
    node5List1.next = node6List1;

    LinkedListNode list2 = new LinkedListNode(2);
    LinkedListNode node2List2 = new LinkedListNode(3);
    list2.next = node2List2;
    LinkedListNode node3List2 = new LinkedListNode(4);
    node2List2.next = node3List2;
    node3List2.next = node5List1;

    Intersection intersection = new Intersection();
    intersection.findIntersection(list1, list2);
  }
}
