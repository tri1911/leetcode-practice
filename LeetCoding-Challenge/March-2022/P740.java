package leetcodingchallenge.march2022;

/**
 * Date: March 05, 2022
 * 740. Delete and Earn
 * https://leetcode.com/problems/delete-and-earn/
 */

public class P740 {
    // time: O(max + n)
    // space: O(max)
    public int deleteAndEarn(int[] nums) {
        // find max
        int largest = Integer.MIN_VALUE;
        for (int num : nums) largest = Math.max(largest, num);
        // initialize hash table
        int[] hash = new int[largest + 1];
        // fill values
        for (int num : nums) hash[num] += num;
        // find the solution
        int first = hash[0], second = hash[1];
        // base case:
        // the optimal solution [:1] would be either hash[0] or hash[1]
        int best = Math.max(first, second);
        for (int i = 2; i <= largest; i++) {
            best = Math.max(first + hash[i], second);
            first = second;
            second = best;
        }
        return best;
    }
}
