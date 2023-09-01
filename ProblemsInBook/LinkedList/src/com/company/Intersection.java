// Problem: Given two (singly) linked lists, determine if the two lists
// intersect. Return the intersecting node. Note that the intersection is
// defined based on reference, not value. That is, if the kth node of the first
// linked list is the exact same node (by reference) as the jth node of the
// second linked list, then they are intersecting.
//

import com.company.RemoveDups.LinkedListNode;

public class Intersection {

  LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode list2) {
    int length1 = getLength(list1);
    int length2 = getLength(list2);

    while (length1 > length2) {
      list1 = list1.next;
      length1--;
    }
    while (length2 > length1) {
      list2 = list2.next;
      length2--;
    }
    while (list1 != list2) {
      list1 = list1.next;
      list2 = list2.next;
    }
    return list1;
  }

  int getLength(LinkedListNode list) {
    int length = 0;
    while (list != null) {
      length++;
      list = list.next;
    }
    return length;
  }

  public static void main(String[] args) {

  }
}
