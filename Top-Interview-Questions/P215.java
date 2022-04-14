package topInterviewQs;

/**
 * Date: Jan 8, 2022 - Redo on April 11, 2022
 * 215. Kth Largest Element in an Array
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */

import java.util.*;

public class P215 {
    /*  sorting approach
        // time complexity: O(nlog(n))
        // space complexity: O(1)
        public int findKthLargest(int[] nums, int k) {
            Arrays.sort(nums);
            return nums[nums.length - k];
        }
     */

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

    // time: O(n) in average, but wort case is O(n^2)
    // space: O(1)
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        quickSelect(nums, 0, n - 1, n - k);
        return nums[n - k];
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void quickSelect(int[] nums, int left, int right, int target) {
        // base case: there is only one element in the list
        if (left == right) return;
        // 1. randomly select the pivot index
        Random rand = new Random();
        int pivotIdx = rand.nextInt(right - left) + left;
        // 2. partition the array based on the pivot value
        int result = partition(nums, left, right, pivotIdx);
        // 3. check whether the returned index is the target
        if (result == target) return;
        // - if not, recursively call quick select on the right or left part
        if (result > target) quickSelect(nums, left, result - 1, target);
        else quickSelect(nums, result + 1, right, target);
    }

    // helper function to partition the array based on the pivot value
    public static int partition(int[] nums, int left, int right, int pivotIdx) {
        int pivotVal = nums[pivotIdx];
        // 1. swap the pivot idx with the last element
        swap(nums, pivotIdx, right);
        // 2. move the smaller elements to the left
        int j = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivotVal) {
                swap(nums, j++, i);
            }
        }
        // 3. position the pivot back to its final place
        swap(nums, right, j);
        // 4. return the final pivot index
        return j;
    }

    public static void main(String[] args) {
        P215 obj = new P215();
        System.out.println("Expected: 5. Output: " + obj.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println("Expected: 4. Output: " + obj.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}

/**
 * reference
 * https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/60294/Solution-explained
 */