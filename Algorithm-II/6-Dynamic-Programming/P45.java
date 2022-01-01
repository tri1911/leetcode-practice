package algorithm2.dynamicProgramming;

// date: Dec 22, 2021
// 45. Jump Game II
// https://leetcode.com/problems/jump-game-ii/

// TODO: check out the better solution

public class P45 {
    // time complexity: O(n)
    // space complexity: O(1)
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int ans = 0;
        int globalReach = 0, localReach = 0;
        for (int i = 0; i <= localReach; i++) {
            globalReach = Math.max(globalReach, i + nums[i]); // update the global reach
            if (globalReach >= nums.length - 1) // if reach the last position, stop!
                break;
            if (i == localReach) { // reach the end of the current stage
                localReach = globalReach; // update the limit for the next stage
                ans += 1; // update the steps
            }
        }
        return ans + 1;
    }

    public static void main(String[] args) {
        P45 p = new P45();
        System.out.println("------------------------------------------");
        System.out.println("Input: nums = [2, 3, 1, 1, 4] -> Expect: 2.");
        System.out.println("Output: " + p.jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println("------------------------------------------");
        System.out.println("Input: nums = [2, 3, 0, 1, 4] -> Expect: 2.");
        System.out.println("Output: " + p.jump(new int[]{2, 3, 0, 1, 4}));
        System.out.println("------------------------------------------");
        System.out.println("Input: nums = [2, 1, 1, 1, 4] -> Expect: 3.");
        System.out.println("Output: " + p.jump(new int[]{2, 1, 1, 1, 4}));
        System.out.println("------------------------------------------");
        System.out.println("Input: nums = [2] -> Expect: 0.");
        System.out.println("Output: " + p.jump(new int[]{2}));
        System.out.println("------------------------------------------");
        System.out.println("Input: nums = [2, 1] -> Expect: 1.");
        System.out.println("Output: " + p.jump(new int[]{2, 1}));
    }
}
