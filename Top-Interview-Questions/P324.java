package topInterviewQs;

import java.util.Arrays;

/**
 * Date: April 09, 2022
 * 324. Wiggle Sort II
 * https://leetcode.com/problems/wiggle-sort-ii/
 */

public class P324 {
    // time:
    // space:
    public void wiggleSort(int[] nums) {

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
    }
}

/**
 * reference
 * https://leetcode.com/problems/wiggle-sort-ii/discuss/77677/O(n)%2BO(1)-after-median-Virtual-Indexing
 * https://youtu.be/BP7GCALO2v8
 * https://rcoh.me/posts/linear-time-median-finding/
 * https://stackoverflow.com/questions/11068429/nth-element-implementations-complexities
 * https://leetcode.com/problems/top-k-frequent-elements/solution/
 */
