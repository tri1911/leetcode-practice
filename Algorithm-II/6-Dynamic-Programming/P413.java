package algorithm2.dynamicProgramming;

// date: Dec 22, 2021
// 413. Arithmetic Slices
// https://leetcode.com/problems/arithmetic-slices/

public class P413 {
    // time complexity: O(n)
    // space complexity: O(1)
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        int ans = 0, count = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2])
                ans += ++count;
            else
                count = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        P413 p = new P413();
        System.out.println("---------------------------------------");
        System.out.println("Input: nums = [1, 2, 3, 4]. Expect: 3");
        System.out.println("Output: " + p.numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
        System.out.println("---------------------------------------");
        System.out.println("Input: nums = [1]. Expect: 0");
        System.out.println("Output: " + p.numberOfArithmeticSlices(new int[]{1}));
    }
}
