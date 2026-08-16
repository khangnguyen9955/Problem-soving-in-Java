package ProblemsInBook.StackAndQueue;

// Implement a stack data structure LIFO
// pop() - removes and returns the top element
// push() - adds an element to the top of the stack
// peek() - returns the top element without removing it
// isEmpty() - returns true if the stack is empty, false otherwise
public class Stack<T> {
  private StackNode<T> top;

  private static class StackNode<T> {
    T data;
    StackNode<T> next;

    public StackNode(T value) {
      this.data = value;
    }
  }

  public T pop() {
    if (top == null) {
      return null;
    }
    T data = top.data;
    top = top.next; // next node will be top
    return data;
  }

  public void push(T value) {
    StackNode<T> node = new StackNode<>(value);
    node.next = top;
    top = node;
  }

  public T peek() {
    return top != null ? top.data : null;
  }

  public boolean isEmpty() {
    return top == null;
  }

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
    stack.push(6);

    System.out.println(stack.peek()); // 6
    System.out.println(stack.pop()); // 6
    System.out.println(stack.peek()); // 5
    System.out.println(stack.isEmpty()); // false
    stack.pop();
    stack.pop();
    stack.pop();
    stack.pop();
    stack.pop();
    System.out.println(stack.isEmpty()); // true
  }

}
