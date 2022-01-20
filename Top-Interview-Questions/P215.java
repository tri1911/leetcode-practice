package topInterviewQs;

// Date: Jan 8, 2022
// 215. Kth Largest Element in an Array
// https://leetcode.com/problems/kth-largest-element-in-an-array/

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// TODO: implement linear time algorithm

public class P215 {
    // sorting
    // time complexity: O(nlog(n))
    // space complexity: O(1)
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /*  using max heap
        // time complexity: O(nlog(k))
        // space complexity: O(k)
        public int findKthLargest(int[] nums, int k) {
            Queue<Integer> heap = new PriorityQueue<>();
            for (int num : nums) {
                heap.offer(num);
                if (heap.size() > k) heap.poll();
            }
            return heap.peek();
        }
     */

    public static void main(String[] args) {
        P215 obj = new P215();
        System.out.println("Expected: 5. Output: " + obj.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println("Expected: 4. Output: " + obj.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}

// reference
// https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/60294/Solution-explained
