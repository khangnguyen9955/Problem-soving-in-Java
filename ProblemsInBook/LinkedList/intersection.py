class ListNode:
    def __init__(self, x, next=None):
        self.val = x
        self.next = None

class IntersectionOfLinkedList:
    def getIntersectionNode(self, list1,list2):
        len1,len2 = self.getLength(list1), self.getLength(list2)
        print("Length of List1:", len1)
        print("Length of List2:", len2)
        while len1 > len2:
            list1 = list1.next
            len1 -= 1
        while len2 > len1:
            list2 = list2.next
            len2 -= 1
        
        print("List1:", list1.val)
        print("List2:", list2.val)
        while list1 != list2:
            print("List1:", list1.val)
            print(
            "List2:", list2.val)
            list1 = list1.next
            list2 = list2.next
        return list1

    def getLength(self, list):
        length = 0
        while list:
            length += 1
            list = list.next
        return length

def main():
    # Create linked lists
    common_node = ListNode(7)
    list1 = ListNode(1)
    list1.next = ListNode(9)
    list1.next.next = common_node

    list2 = ListNode(3)
    list2.next = common_node

    solution = IntersectionOfLinkedList()
    intersection_node = solution.getIntersectionNode(list1, list2)

    if intersection_node is not None:
        print("Intersection Node Value:", intersection_node.val)
    else:
        print("No Intersection")

if __name__ == "__main__":
    main()

