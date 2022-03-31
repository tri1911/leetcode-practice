package others;

import java.util.Arrays;

/**
 * Date: March 31, 2022
 * 16. 3Sum Closest
 * https://leetcode.com/problems/3sum-closest/
 */

public class P16 {
    // time: O(n^2)
    // space: O(1)
    public int threeSumClosest(int[] nums, int target) {
        int ans = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int first = 0; first < nums.length - 2; first++) {
            int second = first + 1, third = nums.length - 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                // return early if the sum equals the target
                if (sum == target) return sum;
                // update the global solution
                if (Math.abs(sum - target) < Math.abs(ans - target)) ans = sum;
                // update the pointers for the next iteration
                if (sum > target) {
                    // skip duplicates
                    while (second < third && nums[third - 1] == nums[third]) third--;
                    // update
                    third--;
                } else {
                    // skip duplicates
                    while (second < third && nums[second + 1] == nums[second]) second++;
                    // update
                    second++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        P16 obj = new P16();
        System.out.println("Expected: 2. Received: " + obj.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}

/**
 * reference
 * https://leetcode.com/problems/3sum-closest/discuss/7872/Java-solution-with-O(n2)-for-reference
 */
