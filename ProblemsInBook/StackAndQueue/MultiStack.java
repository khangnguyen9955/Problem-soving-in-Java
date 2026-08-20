package ProblemsInBook.StackAndQueue;

// define a flexible stack that we can define the number of stacks 
// and the size of each one, and the stack can grow and shrink dynamically
// using a single array to store all the stacks
public class MultiStack {
  private StackInfo[] info;
  private int[] values;

  public MultiStack(int numberOfStacks, int stackSize) {
    info = new StackInfo[numberOfStacks];
    for (int i = 0; i < numberOfStacks; i++) {
      info[i] = new StackInfo(stackSize * i, stackSize);
    }
    values = new int[numberOfStacks * stackSize];
  }

  public void push(int stackNum, int value) throws Exception {
    System.out.println("-----------------");
    System.out.println("Pushing " + value + " to stack " + stackNum);
    if (allStacksAreFull()) {
      throw new Exception("All stacks are full");
    }
    StackInfo stack = info[stackNum];
    System.out.print("Stack " + stackNum + " info: ");
    System.out.print("Start: " + stack.start + ", Size: " + stack.size + ", Capacity: " + stack.capacity);
    System.out.println();
    if (stack.isFull()) {
      System.out.println("Stack " + stackNum + " is full, expanding...");
      expand(stackNum);
    }
    System.out.println();
    stack.size++;

    System.out.println("size" + stack.size);
    int index = stack.lastElementIndex();
    values[index] = value;
  }

  public int pop(int stackNum) throws Exception {
    System.out.println("-----------------");
    System.out.println("Popping from stack " + stackNum);
    StackInfo stack = info[stackNum];
    if (stack.isEmpty()) {
      throw new Exception("Stack " + stackNum + " is empty");
    }
    int index = stack.lastElementIndex();
    int value = values[index];
    values[index] = 0; // clear the value
    stack.size--;
    return value;
  }

  public int peek(int stackNum) throws Exception {
    StackInfo stack = info[stackNum];
    if (stack.isEmpty()) {
      throw new Exception("Stack " + stackNum + " is empty");
    }
    return values[stack.lastElementIndex()];
  }

  private void expand(int stackNum) {
    System.out.println("Expanding stack " + stackNum);
    StackInfo stack = info[stackNum];
    shift(stackNum);
    stack.capacity++;
  }

  // Shift element in the stack to make room for the next element

  private void shift(int stackNum) {
    StackInfo stack = info[stackNum];

    if (stack.size >= stack.capacity) {
      // this stack is full, need to shift the next stack
      int nextStack = (stackNum + 1) % info.length; // % because, if we are at the last stack, we need to go back to the
                                                    // first stack
      shift(nextStack);
      // increase the cap for stackNum
      stack.capacity++;
    }
    // shift all elements in stackNum by one to the right
    int index = stack.lastCapacityIndex();
    while (stack.isWithinStackCapacity(index)) {
      // assign the previous element to the current index
      values[index] = values[previousIndex(index)];
      // move the index
      index = previousIndex(index);
    }

    // update stack info
    values[stack.start] = 0; // clear the old element
    stack.start = nextIndex(stack.start);
    stack.capacity--;
  }

  private int nextIndex(int index) {
    return (index + 1) % values.length; // % because, if we are at the last index, we need to go back to the first index
  }

  private int previousIndex(int index) {
    // + values.length to avoid negative index
    // % values.length to wrap around the array
    return (index - 1 + values.length) % values.length;
  }

  private boolean allStacksAreFull() {
    int totalSize = 0;
    for (StackInfo stack : info) {
      totalSize += stack.size;
    }
    System.out.println("Total size: " + totalSize + ", Values length: " + values.length);
    return totalSize == values.length;
  }

  private class StackInfo {
    public int start, size, capacity;

    public StackInfo(int start, int capacity) {
      this.start = start;
      this.capacity = capacity;
    }

    public boolean isWithinStackCapacity(int index) {
      return index >= start && index < start + capacity;
    }

    public int lastCapacityIndex() {
      // % values.length to wrap around the array if needed
      return (start + capacity - 1) % values.length;
    }

    public int lastElementIndex() {
      // % values.length to wrap around the array if needed
      return (start + size - 1) % values.length;
    }

    public boolean isEmpty() {
      return size == 0;
    }

    public boolean isFull() {
      return size == capacity;
    }

  }

  public static void main(String[] args) throws Exception {
    MultiStack stack = new MultiStack(4, 4);
    stack.push(0, 0);
    stack.push(0, 1);
    stack.push(0, 2);
    stack.push(0, 3);
    stack.push(0, 10);
    stack.push(1, 10);
    stack.push(1, 11);
    stack.push(2, 20);
    stack.push(3, 30);
  }

}
