import java.util.Arrays;

public class CQueue {
  int SIZE; // Size of Circular Queue
  int front, rear;
  Student[] items;

  public CQueue(int Size) {
    front = -1;
    rear = -1;
    SIZE = Size;
    items = new Student[SIZE];
  }

  // Check if the queue is full
  boolean isFull() {
    if (front == 0 && rear == SIZE - 1) {
      return true;
    }
    if (front == rear + 1) {
      return true;
    }
    return false;
  }

  // Check if the queue is empty
  boolean isEmpty() {
    if (front == -1)
      return true;
    else
      return false;
  }

  // Adding an element
  int enQueue(Student element) {
    if (isFull()) {
      System.out.println("Queue is full");
      return -1;
    } else {
      if (front == -1)
        front = 0;
      rear = (rear + 1) % SIZE;
      items[rear] = element;
      System.out.println("Inserted " + element);
      return 0;
    }
  }

  // Removing an element
  Student deQueue() {
    Student element;
    if (isEmpty()) {
      System.out.println("Queue is empty");
      return (new Student("No Student", "000"));
    } else {
      element = items[front];
      if (front == rear) {
        front = -1;
        rear = -1;
      } /* Q has only one element, so we reset the queue after deleting it. */
      else {
        front = (front + 1) % SIZE;
      }
      return (element);
    }
  }

  void display() {
    /* Function to display status of Circular Queue */
    int i;
    if (isEmpty()) {
      System.out.println("Empty Queue");
    } else {
      // System.out.println("Front -> " + front);
      // System.out.println("Items -> ");
      for (i = front; i != rear; i = (i + 1) % SIZE)
        System.out.print(items[i] + " ");
      System.out.println(items[i]);
      // System.out.println("Rear -> " + rear);
    }
  }

  @Override
  public String toString() {
    return "CQueue [items=" + Arrays.toString(items) + "]";
  }

  int elementCount() {
    int size;
    if (front == -1 && rear == -1) {
      size = 0;
    } else {
      size = front > rear ? (SIZE - front + rear + 1) : (rear - front + 1);
    }
    return size;
  }

  public int search(String mPhone) {
    for (Student stu : items) {
      if (stu.getPhone().equals(mPhone)) {
        return stu.getCounter();
      }
    }
    return -1;
  }

  // Main
  // public static void main(String[] args) {

  // CQueue q = new CQueue(5);

  // // Fails because front = -1
  // q.deQueue();

  // q.enQueue(new Student("name1", "001"));
  // q.enQueue(new Student("name2", "002"));
  // // q.enQueue(new Student("name3", "003"));
  // q.enQueue(new Student("name4", "004"));
  // // q.enQueue(new Student("name5", "005"));

  // // Fails to enqueue because front == 0 && rear == SIZE - 1
  // q.enQueue(new Student("name6", "006"));

  // q.display();

  // Student elem = q.deQueue();
  // Student empty = new Student("No Student", "000"); //isEmpty will also return
  // this

  // if (!elem.getPhone().equals(empty.getPhone()) ) {
  // System.out.println("Deleted Element is " + elem);
  // }
  // q.display();

  // // q.enQueue(new Student("name6", "007"));

  // q.display();

  // // Fails to enqueue because front == rear + 1
  // // q.enQueue(new Student("name8", "008"));

  // System.out.println(q.elementCount());
  // }

}
