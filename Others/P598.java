package others;

/**
 * Date: March 31, 2022
 * 598. Range Addition II
 * https://leetcode.com/problems/range-addition-ii/
 */

public class P598 {
    // time: O(n) where n is the # of operations
    // space: O(1)
    public int maxCount(int m, int n, int[][] ops) {
        int height = m, width = n;
        for (int[] op : ops) {
            height = Math.min(height, op[0]);
            width = Math.min(width, op[1]);
        }
        return height * width;
    }
}
