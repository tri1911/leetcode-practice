package programmingSkills1;

import java.util.Arrays;

/**
 * Date: March 19, 2022
 * 976. Largest Perimeter Triangle
 * https://leetcode.com/problems/largest-perimeter-triangle/
 */

public class P976 {
    // time: O(n*log(n))
    // space: O(1)
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 3; i >= 0; i--) {
            if (nums[i] + nums[i + 1] > nums[i + 2]) return nums[i] + nums[i + 1] + nums[i + 2];
        }
        return 0;
    }

    public static void main(String[] args) {
        P976 obj = new P976();
        System.out.println("Expected: 5. Received: " + obj.largestPerimeter(new int[]{2, 1, 2}));
        System.out.println("Expected: 0. Received: " + obj.largestPerimeter(new int[]{1, 2, 1}));
        System.out.println("Expected: 5. Received: " + obj.largestPerimeter(new int[]{1, 2, 2, 4, 18, 8}));
    }
}

/**
 * reference
 * https://leetcode.com/problems/largest-perimeter-triangle/solution/
 */
