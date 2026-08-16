package ProblemsInBook.StackAndQueue;

// Implement a queue data structure FIFO
// add() - adds an element to the end of the queue -- enqueue
// remove() - removes and returns the element at the front of the queue -- dequeue 
// peek() - returns the element at the front of the queue without removing it
// isEmpty() - returns true if the queue is empty, false otherwise
public class Queue<T> {
  private QueueNode<T> last;
  private QueueNode<T> first;

  private static class QueueNode<T> {
    T data;
    QueueNode<T> next;

    public QueueNode(T data) {
      this.data = data;
    }
  }

  /*
   * Add an element to the end of the queue
   */
  public void enqueue(T value) {
    QueueNode<T> node = new QueueNode<>(value);
    if (this.last != null) {
      this.last.next = node;
    } else {
      first = node;
    }
    last = node;
  }

  /*
   * Remove and return the element at the front of the queue
   */
  public T dequeue() {
    if (this.first == null) {
      return null;
    }
    T data = this.first.data;
    this.first = this.first.next; // move the first pointer to the next node
    if (this.first == null) {
      this.last = null; // if the queue is now empty, set last to null
    }
    return data;
  }

  /*
   * Return the element at the front of the queue without removing it
   */
  public T peek() {
    return this.first != null ? this.first.data : null;
  }

  public boolean isEmpty() {
    return this.first == null ? true : false;
  }

  public static void main(String[] args) {
    Queue<Integer> queue = new Queue<>();
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    queue.enqueue(5);
    queue.enqueue(6);
    System.out.println(queue.peek());
    System.out.println(queue.peek());
    System.out.println(queue.dequeue());
    System.out.println(queue.isEmpty());
    System.out.println(queue.peek());

    Queue<String> queue2 = new Queue<>();
    queue2.enqueue("A");
    queue2.enqueue("B");
    System.out.println(queue2.peek());
    System.out.println(queue2.dequeue());
    System.out.println(queue2.dequeue());
    System.out.println(queue2.isEmpty());
  }

}
