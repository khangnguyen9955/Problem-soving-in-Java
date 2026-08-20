package ProblemsInBook.StackAndQueue;

// Implement a stack data structure that supports push, pop, and retrieving the minimum element in constant time
// approach 1: use one stack and keep store the min value

public class StackWithMin {
  class StackNodeWithMin {
    public int value; // value of stack
    public int min; // keep track the min value of the stack

    public StackNodeWithMin(int v, int min) {
      this.min = min;
      value = v;
    }
  }

  public class StackMin extends Stack<StackNodeWithMin> {

    public void push(int value) {
      int newMin = Math.min(value, min());
      super.push(new StackNodeWithMin(value, newMin));
    }

    public int min() {
      if (this.isEmpty()) {
        return Integer.MAX_VALUE;
      } else {
        return super.peek().min;
      }
    }

  }
  // approach 2: using another stack to store the min value instead
  // so we can save the storage/space, no need to keep track the min value for
  // each node

  public class StackMin2 extends Stack<Integer> {
    Stack<Integer> minStack;

    public StackMin2() {
      minStack = new Stack<>();
    }

    public int min() {
      if (minStack.isEmpty()) {
        return Integer.MAX_VALUE;
      } else {
        return minStack.peek();
      }
    }

    // when push we need to check if the value is min -> push it to minStack
    public void push(int value) {
      if (value <= min()) {
        minStack.push(value);
      }
      super.push(value);
    }

    // when pop, check if the value is min -> pop it from minStack
    public Integer pop() {
      int value = super.pop();
      if (value == min()) {
        minStack.pop();
      }
      return value;
    }
  }

  public static void main(String[] args) {
    StackMin stack = new StackWithMin().new StackMin();
    stack.push(5);
    System.out.println(stack.min()); // 5
    stack.push(6);
    System.out.println(stack.min()); // 5
    stack.push(3);
    System.out.println(stack.min()); // 3
    stack.pop();
    System.out.println(stack.min()); // 5
    ///
    System.out.println("--------------------");
    StackMin2 stack2 = new StackWithMin().new StackMin2();
    stack2.push(5);
    System.out.println(stack2.min()); // 5
    stack2.push(6);
    System.out.println(stack2.min()); // 5

    stack2.push(3);
    System.out.println(stack2.min()); // 3
    stack2.pop();
    System.out.println(stack2.min()); // 5

  }
}
