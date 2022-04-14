package topInterviewQs;

import java.util.Arrays;
import java.util.Random;

/**
 * Date: April 13, 2022
 * 324. Wiggle Sort II
 * https://leetcode.com/problems/wiggle-sort-ii/
 */

// TODO: need to redo multiple times

public class P324 {
    // counting sort approach
    // time: O(n)
    // space: O(1)
    public void wiggleSort(int[] nums) {
        int[] counter = new int[5001];
        for (int num : nums) counter[num]++;

        // Approach 1: simple, easy to understand
        int current = 5000;
        // populate large number to odd indices
        for (int i = 1; i < nums.length; i += 2) {
            while (counter[current] == 0) current--;
            nums[i] = current;
            counter[current]--;
        }
        // populate small values to even indices
        for (int i = 0; i < nums.length; i += 2) {
            while (counter[current] == 0) current--;
            nums[i] = current;
            counter[current]--;
        }

        /*  Approach 2: use index mapping -> concise
            for (int val = 5000, idx = 0; val >= 0; val--) {
                while (counter[val] > 0) {
                    int mappedIdx = (2 * idx++ + 1) % (nums.length | 1);
                    nums[mappedIdx] = val;
                    counter[val]--;
                    if (idx == nums.length) return;
                }
            }
         */

    }

    // virtual indexing & three-way partition approach
    // time: O(n)
    // space: O(1)
    public void _wiggleSort(int[] nums) {
        int n = nums.length;
        // determine the median - take O(n) time in average, O(1) space
        P215.quickSelect(nums, 0, n - 1, n / 2);
        int median = nums[n / 2];
        // 3-Way QuickSort (Dutch National Flag)
        // order: Large Part -> Median Part -> Small Part
        int left = 0, mid = 0, right = n - 1;
        while (mid <= right) {
            int val = nums[toNewIdx(mid, n)];
            if (val > median) {
                P215.swap(nums, toNewIdx(mid++, n), toNewIdx(left++, n));
            } else if (val < median) {
                P215.swap(nums, toNewIdx(mid, n), toNewIdx(right--, n));
            } else {
                mid++;
            }
        }
    }

    private int toNewIdx(int idx, int n) {
        return (2 * idx + 1) % (n | 1);
    }

    public static void main(String[] args) {
        P324 obj = new P324();
        int[] nums = {1, 5, 1, 1, 6, 4};
        obj.wiggleSort(nums);
        System.out.println("Expected: [1, 6, 1, 5, 1, 4]\nReceived: " + Arrays.toString(nums));
        System.out.println("---");
        nums = new int[]{1, 3, 2, 2, 3, 1};
        obj.wiggleSort(nums);
        System.out.println("Expected: [2, 3, 1, 3, 1, 2]\nReceived: " + Arrays.toString(nums));
        System.out.println("---");
        nums = new int[]{1};
        obj.wiggleSort(nums);
        System.out.println("Expected: [1]\nReceived: " + Arrays.toString(nums));
    }
}

/**
 * reference
 * https://leetcode.com/problems/wiggle-sort-ii/discuss/77677/O(n)%2BO(1)-after-median-Virtual-Indexing
 * <p>
 * Determine the kth element using Quick Selection:
 * https://youtu.be/BP7GCALO2v8
 * https://rcoh.me/posts/linear-time-median-finding/
 * https://stackoverflow.com/questions/11068429/nth-element-implementations-complexities
 * https://leetcode.com/problems/top-k-frequent-elements/solution/
 * <p>
 * Three-way Partition - Dutch National Flag problem:
 * https://en.wikipedia.org/wiki/Dutch_national_flag_problem
 */
