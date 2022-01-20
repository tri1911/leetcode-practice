package others;

// Date: Jan 5, 2022
// 373. Find K Pairs with the Smallest Sums
// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/

// this problem is similar to the problem 378 (rows and columns are sorted in ascending order)
// we can see it as a problem that we need to merge k sorted lists
// -> similar approach as 2-way merge sort

import java.util.*;

// TODO: optimize the implementation

public class P373 {
    // time complexity: O(k*log(n)) where n is the length of nums2
    // space complexity: O(n)
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> heap = new PriorityQueue<>();
        for (int i = 0; i < n; i++)
            heap.add(new Node(i, 0, nums2[i] + nums1[0]));
        while (!heap.isEmpty() && k > 0) {
            k--;
            Node removedNode = heap.poll();
            ans.add(Arrays.asList(nums1[removedNode.j], nums2[removedNode.i]));
            if (removedNode.j == m - 1) continue;
            heap.add(new Node(removedNode.i, removedNode.j + 1, nums2[removedNode.i] + nums1[removedNode.j + 1]));
        }
        return ans;
    }

    private class Node implements Comparable<Node> {
        int i, j, val;

        public Node(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }

        @Override
        public int compareTo(Node other) {
            return this.val - other.val;
        }
    }

    public static void main(String[] args) {
        P373 obj = new P373();
        System.out.println("Expected: [[1, 3], [2, 3]]");
        System.out.println("Received: " + obj.kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3));
    }
}

// reference
// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/discuss/84551/simple-Java-O(KlogK)-solution-with-explanation
// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/discuss/84566/share-my-solution-which-beat-9642

// TODO: learn more about k-way merge sort
// https://www.youtube.com/watch?v=Xo54nlPHSpg
