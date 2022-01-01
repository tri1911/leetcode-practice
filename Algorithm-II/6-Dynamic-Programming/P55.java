package algorithm2.dynamicProgramming;

// date: Dec 21, 2021
// 55. Jump Game
// https://leetcode.com/problems/jump-game/

public class P55 {
    // time complexity: O(n)
    // space complexity: O(1)
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i <= maxReach; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        P55 p = new P55();
        System.out.println("Input: nums = [2, 3, 1, 1, 4]");
        System.out.println("Expect: true");
        System.out.println("Output: " + p.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println("----------------------------");
        System.out.println("Input: nums = [3, 2, 1, 0, 4]");
        System.out.println("Expect: false");
        System.out.println("Output: " + p.canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
