package leetcodingchallenge.september2022;

/**
 * Date: September 25, 2022
 * 622. Design Circular Queue
 * https://leetcode.com/problems/design-circular-queue/
 */

public class P622 {
    final int[] queue;
    int front = 0, rear = -1, len = 0;

    public P622(int k) {
        queue = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        rear = (rear + 1) % queue.length;
        queue[rear] = value;
        len++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        front = (front + 1) % queue.length;
        len--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : queue[front];
    }

    public int Rear() {
        return isEmpty() ? -1 : queue[rear];
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public boolean isFull() {
        return len == queue.length;
    }
}

/**
 * References
 * https://leetcode.com/problems/design-circular-queue/discuss/149420/Concise-Java-using-array
 */