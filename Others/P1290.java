package others;

import java.util.Arrays;

/**
 * Date: March 11, 2022
 * 1920. Build Array from Permutation
 * https://leetcode.com/problems/build-array-from-permutation/
 */

public class P1290 {
    // simple approach
    // time & space: O(n)
    public int[] _buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) ans[i] = nums[nums[i]];
        return ans;
    }

    // the optimal solution without using the extra space (constant space O(1))
    // observation: nums[i] < nums.length (1000) -> max # of bits representing nums[i] would be log2(nums.length) which is 10 bits (max value of 10 bits = 2^10 - 1 = 1023)
    // integer in java consists of 32 bits
    public int[] buildArray(int[] nums) {
        // Approach 1
        // find the way to store both the original and the solution at the same cell
        // first 10 bits = solution + last 10 bits = original
        // use & 1023 ( = 00000000000_1111111111) to ignore the first 10 bits (only care about the original)
        // then shifting result bits to the left 10 times before merging
        // for (int i = 0; i < nums.length; i++) nums[i] |= (nums[nums[i]] & 1023) << 10;
        // get solutions
        // for (int i = 0; i < nums.length; i++) nums[i] >>= 10;

        // Approach 2 - at nums[i] stores original & solution = original + (nums[nums[i]] % n) * n
        // get the original by % n
        // get the solution by / n
        int n = nums.length;
        for (int i = 0; i < n; i++) nums[i] += n * (nums[nums[i]] % n);
        for (int i = 0; i < n; i++) nums[i] /= n;
        return nums;
    }

    public static void main(String[] args) {
        P1290 obj = new P1290();
        System.out.println("Expected: [0, 1, 2, 4, 5, 3]\nReceived: " + Arrays.toString(obj.buildArray(new int[]{0, 2, 1, 5, 3, 4})));
        System.out.println("----");
        System.out.println("Expected: [4, 5, 0, 1, 2, 3]\nReceived: " + Arrays.toString(obj.buildArray(new int[]{5, 0, 1, 2, 3, 4})));
    }
}

/**
 * Constraints:
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] < nums.length
 * The elements in nums are distinct.
 * <p>
 * reference
 * https://leetcode.com/problems/build-array-from-permutation/discuss/1316500/Java-solution-using-O(1)-space-with-explanation
 * https://leetcode.com/problems/build-array-from-permutation/discuss/1315480/Java-or-O(1)-Space-O(n)-Time
 */