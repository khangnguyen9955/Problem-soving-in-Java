package ProblemsInBook.StackAndQueue;

import java.util.ArrayList;

public class StackOfPlates<T> {
  public class Node {
    public Node above;
    public Node below;
    public T value;

    public Node(T value) {
      this.value = value;
    }
  }

  class StackPlate {
    private int capacity;
    public Node top; // the top of the stack
    public Node bottom; // the bottom of the stack
    public int size = 0;

    public StackPlate(int capacity) {
      this.capacity = capacity;
    }

    public boolean isFull() {
      return size == capacity;
    }

    public void join(Node above, Node below) {
      // join two nodes together
      if (below != null)
        below.above = above;
      if (above != null)
        above.below = below;
    }

    public void push(T value) {
      // add a new node to the top of the stack
      // link the new node to the previous top node
      if (size >= capacity)
        return;
      size++;
      Node node = new Node(value);
      if (size == 1)
        bottom = node;
      join(node, top);
      top = node;
    }

    public T pop() {
      // remove the top node from the stack
      if (top == null)
        return null;
      Node node = top;
      top = top.below;
      size--;
      return node.value;
    }

    public T removeBottom() {
      // remove the bottom node from the stack
      T value = bottom.value;
      bottom = bottom.above;
      if (bottom != null)
        bottom.below = null;
      size--;
      return value;
    }

    public boolean isEmpty() {
      return size == 0;
    }

  }

  ArrayList<StackPlate> stacks = new ArrayList<StackPlate>();
  public int capacity;

  public StackOfPlates(int capacity) {
    this.capacity = capacity;
  }

  public StackPlate getLastStack() {
    if (stacks.size() == 0) {
      return null;
    }
    return stacks.get(stacks.size() - 1);
  }

  public void push(T value) {
    // when push new item, we need to check
    StackPlate last = getLastStack();
    if (last != null && last.size < capacity) {
      last.push(value);
    } else {
      // don't have stack yet or last stack is full -> create new stack
      StackPlate stack = new StackPlate(capacity);
      stack.push(value);
      stacks.add(stack);
    }
  }

  public T pop() {
    StackPlate last = getLastStack();
    if (last == null)
      return null;
    T value = last.pop();
    if (last.size == 0) {
      // out of item -> remove this stack
      stacks.remove(stacks.size() - 1);
    }
    return value;
  }

  public T popAt(int index) {
    // pop the last item in a specific stack
    // move the bottom of the next stack to the top of this stack
    return leftShift(index, true);
  }

  private T leftShift(int index, boolean removeTop) {
    StackPlate stack = stacks.get(index);
    T removedItem;
    if (removeTop)
      removedItem = stack.pop(); // remove the top item of this index stack
    else
      removedItem = stack.removeBottom(); // remove the bottom item of this index stack
    if (stack.isEmpty()) {
      // this stack is empty, remove it from the list of stacks
      stacks.remove(index);
    } else if (stacks.size() > index + 1) {
      // if there is a next stack, we need to move the bottom of the next stack to the
      // top of this stack
      T value = leftShift(index + 1, false);
      stack.push(value);
    }
    return removedItem;
  }

  // Imagine a (literal) stack of plates. If the stack gets too hight, it might
  // topple.
  // Therefore, in real life, we would likely start a new stack when the previous
  // stack exceeds some threshold.
  // Implement a data structure SetOfStacks that mimics this. SetOfStacks should
  // be composed of several stacks and should create a new stack once the previous
  // one exceeds capacity.
  // SetOfStacks.push() and pop() should behave identically to a single stack.
  // Follow up: Implement a function popAt(int index) which performs a pop
  // operation on a specific sub-stack.
  public static void main(String[] args) {

    StackOfPlates<Integer> stack = new StackOfPlates<>(3);
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
    stack.push(6);
    stack.push(7);
    stack.push(8);
    stack.push(9);
    System.out.println(stack.popAt(0));
    System.out.println(stack.popAt(0));
    System.out.println(stack.popAt(0));
    System.out.println(stack.popAt(0));
  }

}
