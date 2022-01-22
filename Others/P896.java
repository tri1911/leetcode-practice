package others;

/**
 * Date: Jan 21, 2022
 * 896. Monotonic Array
 * https://leetcode.com/problems/monotonic-array/
 */

public class P896 {
    // my own solution
    // time: O(n)
    // space: O(1)
    public boolean isMonotonic(int[] nums) {
        boolean inc = true, dec = true;
        for (int i = 1; i < nums.length; i++) {
            if (inc && nums[i] < nums[i - 1]) inc = false;
            if (dec && nums[i] > nums[i - 1]) dec = false;
        }
        return inc || dec;
    }

    /*  Great Solution
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < A.length - 1; ++i) {
            if (A[i] > A[i+1])
                increasing = false;
            if (A[i] < A[i+1])
                decreasing = false;
        }

        return increasing || decreasing;
     */
}

/**
 * reference
 * https://leetcode.com/problems/monotonic-array/solution/
 */