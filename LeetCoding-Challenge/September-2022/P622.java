package leetcodingchallenge.september2022;

/**
 * Date: September 25, 2022
 * 622. Design Circular Queue
 * https://leetcode.com/problems/design-circular-queue/
 */

public class P622 {
    // array to store circular queue
    final private int[] queue;
    // indices of front and rear of the circular
    private int front, rear;
    // variable to store the active length of the queue
    private int size;

    public P622(int k) {
        this.queue = new int[k];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        rear = (rear + 1) % queue.length;
        queue[rear] = value;
        this.size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        front = (front + 1) % queue.length;
        this.size--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : queue[front];
    }

    public int Rear() {
        return isEmpty() ? -1 : queue[rear];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == queue.length;
    }
}

/**
 * References
 * https://leetcode.com/problems/design-circular-queue/discuss/149420/Concise-Java-using-array
 */