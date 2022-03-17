package programmingSkills1;

/**
 * Date: March 16, 2022
 * 191. Number of 1 Bits
 * https://leetcode.com/problems/number-of-1-bits/
 */

public class P191 {
    // first attempt, but not optimized
    // time & space: O(1)
    public int _hammingWeight(int n) {
        int count = 0, mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) count++;
            mask <<= 1;
        }
        return count;
    }

    // optimized solution
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            ans++;
            n &= n - 1;
        }
        return ans;
    }
}
