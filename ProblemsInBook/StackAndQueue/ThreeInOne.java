package ProblemsInBook.StackAndQueue;

// Use single array to implement three stacks
public class ThreeInOne {
  int[] values;
  int[] sizes;
  int stackSize;

  public ThreeInOne(int stackSize) {
    this.stackSize = stackSize;
    values = new int[stackSize * 3];
    sizes = new int[3];
  }

  public void push(int stackNum, int value) {
    if (isFull(stackNum)) {
      return;
    }
    int index = topOfStack(stackNum) + 1; // get the index of the top of the stack
    sizes[stackNum]++;
    values[index] = value;
  }

  public int pop(int stackNum) {
    if (isEmpty(stackNum)) {
      return -1;
    }
    int index = topOfStack(stackNum);
    int value = values[index];
    values[index] = 0; // clear the value
    sizes[stackNum]--;
    return value;
  }

  public int peek(int stackNum) {
    if (isEmpty(stackNum)) {
      return -1;
    }
    int index = topOfStack(stackNum);
    return values[index];
  }

  public boolean isEmpty(int stackNum) {
    return sizes[stackNum] == 0;
  }

  public boolean isFull(int stackNum) {
    return sizes[stackNum] == stackSize;
  }

  private int topOfStack(int stackNum) {
    int offset = stackNum * stackSize;
    int size = sizes[stackNum];
    return offset + size - 1;
  }

  public static void main(String[] args) {
    ThreeInOne stack = new ThreeInOne(4); // stack with 4 elements
    // stack 1
    stack.push(0, 1);
    stack.push(0, 2);
    stack.push(0, 3);
    stack.push(0, 4);
    // stack 2
    stack.push(1, 1);
    stack.push(1, 2);
    stack.push(1, 3);
    stack.push(1, 4);

    // stack 3
    stack.push(2, 1);
    stack.push(2, 2);
    stack.push(2, 3);
    stack.push(2, 4);

    System.out.println(stack.peek(0)); // 4
    System.out.println(stack.peek(1)); // 4
    System.out.println(stack.peek(2)); // 4
  }
}
