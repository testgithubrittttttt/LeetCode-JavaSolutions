public class queueImplementation {
    private int[] queueArray;
    private int front;
    private int rear;
    private int maxSize;
    private int currentSize;

    // Constructor
    public queueImplementation(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        currentSize = 0;
    }

    // Enqueue: Add element at the rear
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full! Cannot enqueue.");
            return;
        }
        rear = (rear + 1) % maxSize;
        queueArray[rear] = data;
        currentSize++;
    }

    // Dequeue: Remove element from the front
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Cannot dequeue.");
            return -1;
        }
        int data = queueArray[front];
        front = (front + 1) % maxSize;
        currentSize--;
        return data;
    }

    // Peek: Get the element at the front
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Nothing to peek.");
            return -1;
        }
        return queueArray[front];
    }

    // IsEmpty: Check if the queue is empty
    public boolean isEmpty() {
        return currentSize == 0;
    }

    // IsFull: Check if the queue is full
    public boolean isFull() {
        return currentSize == maxSize;
    }

    // Size: Get the current size of the queue
    public int size() {
        return currentSize;
    }
}
