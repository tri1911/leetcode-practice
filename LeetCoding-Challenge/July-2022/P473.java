package leetcodingchallenge.july2022;

/**
 * Date: July 12, 2022
 * 473. Matchsticks to Square
 * https://leetcode.com/problems/matchsticks-to-square/
 */

import java.util.Arrays;

// TODO: check out dynamic programming approach in official solution

public class P473 {
    private int sideLength;
    private int[] sums;

    // time: O(4^n)
    // space: O(n) (call stack)
    private boolean backtracking(int[] matchsticks, int current) {
        if (current == -1) return sums[0] == sums[1] && sums[1] == sums[2] && sums[2] == sums[3];
        for (int i = 0; i < 4; i++) {
            if (matchsticks[current] + sums[i] <= sideLength) {
                sums[i] += matchsticks[current];
                if (backtracking(matchsticks, current - 1)) {
                    return true;
                }
                sums[i] -= matchsticks[current];
            }
        }
        return false;
    }

    public boolean makesquare(int[] matchsticks) {
        sums = new int[4];
        int perimeter = 0;
        for (int val : matchsticks) perimeter += val;
        if (perimeter % 4 != 0) return false;
        this.sideLength = perimeter / 4;
        Arrays.sort(matchsticks);
        return backtracking(matchsticks, matchsticks.length - 1);
    }
}

/**
 * references
 * https://leetcode.com/problems/matchsticks-to-square/solution/
 */

/**
 * Sample 1ms solution
 * class Solution {
 *     boolean[] st;
 *     public boolean makesquare(int[] nums) {
 *         int sum = 0;
 *         for(int x:nums) sum += x;
 *         if(sum == 0 || sum % 4 != 0) return false;
 *         Arrays.sort(nums);
 *         int[] arr = new int[nums.length];
 *         for(int i = 0;i < nums.length;i++) {
 *             arr[i] = nums[nums.length -1 -i];
 *         }
 *         st = new boolean[nums.length];
 *         return dfs(nums,0,0,0,sum/4);
 *     }
 *
 *     boolean dfs(int[] nums,int u,int cur,int start,int length) {
 *         if(u == 4) return true;
 *         if(cur == length) return dfs(nums,u+1,0,0,length);
 *
 *         for(int i =start;i < nums.length;i++) {
 *             if(!st[i] && cur + nums[i] <= length) {
 *                 st[i] = true;
 *                 if(dfs(nums,u,cur + nums[i],i+1,length)) return true;
 *                 st[i] =false;
 *
 *
 *                 if(cur == 0) return false;
 *                 if(cur + nums[i] == length) return false;
 *                 while(i + 1 < nums.length && nums[i+1] == nums[i]) i++;
 *             }
 *         }
 *         return false;
 *     }
 * }
 */