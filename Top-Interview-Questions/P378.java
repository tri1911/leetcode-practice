package topInterviewQs;

/**
 * Date: Jan 4, 2022 - Redo on August 02, 2022 (Daily Leetcode challenge)
 * 378. the Kth Smallest Element in a Sorted Matrix
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */

import java.util.PriorityQueue;
import java.util.Queue;

// TODO: implement the solution using binary search approach

public class P378 {
    // min heap approach
    // time: O(k * log(n))
    // space: O(n)
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        Queue<Node> minHeap = new PriorityQueue<>();
        // populate the min heap with the first row - which takes O(n)
        for (int j = 0; j < n; j++)
            minHeap.add(new Node(0, j, matrix[0][j]));
        // pop the root out from the min heap k - 1 times - which takes k * log(n)
        while (k > 1) {
            k--;
            Node minNode = minHeap.poll();
            if (minNode.i == n - 1) continue;
            minHeap.add(new Node(minNode.i + 1, minNode.j, matrix[minNode.i + 1][minNode.j]));
        }
        return minHeap.poll().val;
    }

    private class Node implements Comparable<Node> {
        int i, j, val;

        public Node(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }

        public int compareTo(Node other) {
            return this.val - other.val;
        }
    }

    // Binary search approach
    // time: 
    // space: 
    public int _kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0], high = matrix[n - 1][n - 1];
        while (low < high) {
            int mid = (low + high) / 2;
            int position = getPosition(matrix, mid);
            // search in the next range
            if (position > k) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    // a helper fn to determine the position of `val` in matrix
    private int getPosition(int[][] matrix, int val) {
        // TODO
    }

    public static void main(String[] args) {
        P378 obj = new P378();
        int[][] matrix = {{1, 2}, {3, 3}};
        System.out.println("Expected: 3. Received: " + obj.kthSmallest(matrix, 3));
        matrix = new int[][]{{1, 2}, {1, 3}};
        System.out.println("Expected: 1. Received: " + obj.kthSmallest(matrix, 2));
        matrix = new int[][]{{1, 3, 5}, {6, 7, 12}, {11, 14, 14}};
        System.out.println("Expected: 1. Received: " + obj.kthSmallest(matrix, 1));
    }
}

/**
 * references
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/85173/Share-my-thoughts-and-Clean-Java-Code
 * https://www.geeksforgeeks.org/kth-smallest-element-in-a-row-wise-and-column-wise-sorted-2d-array-set-1/
 * https://docs.oracle.com/javase/8/docs/api/java/util/PriorityQueue.html
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/85177/Java-1ms-nlog(max-min)-solution
 */
