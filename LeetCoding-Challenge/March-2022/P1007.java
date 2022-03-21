package leetcodingchallenge.march2022;

/**
 * Date: March 20, 2022
 * 1007. Minimum Domino Rotations For Equal Row
 * https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
 */

// TODO: checkout better solution

public class P1007 {
    // time: O(n)
    // space: O(1)
    public int _minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        // the target would be either tops[0] or bottoms[0]
        int target1 = tops[0], target2 = bottoms[0];
        int top1 = 0, bottom1 = 0, top2 = 0, bottom2 = 0;
        for (int i = 0; i < n; i++) {
            if (tops[i] != target1 && bottoms[i] != target1) target1 = 0;
            if (tops[i] != target2 && bottoms[i] != target2) target2 = 0;
            if (target1 == 0 && target2 == 0) return -1;
            // count target1
            if (target1 != 0) {
                top1 += tops[i] == target1 ? 1 : 0;
                bottom1 += bottoms[i] == target1 ? 1 : 0;
            }
            // count target2
            if (target2 != 0) {
                top2 += tops[i] == target2 ? 1 : 0;
                bottom2 += bottoms[i] == target2 ? 1 : 0;
            }
        }
        int ans = Integer.MAX_VALUE;
        if (target1 != 0) {
            ans = Math.min(ans, n - Math.max(top1, bottom1));
        }
        if (target2 != 0) {
            ans = Math.min(ans, n - Math.max(top2, bottom2));
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    // another approach (brute force)
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length, ans = Integer.MAX_VALUE;
        int[] targets = {tops[0], bottoms[0]};
        for (int target : targets) {
            int i = 0, topCount = 0, bottomCount = 0;
            for (; i < n; i++) {
                if (tops[i] != target && bottoms[i] != target) break;
                // count # of swaps when target is at top row
                if (tops[i] != target) topCount++;
                // count # of swaps when target is at bottom tow
                if (bottoms[i] != target) bottomCount++;
            }
            if (i != n) continue;
            ans = Math.min(topCount, bottomCount);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        P1007 obj = new P1007();
        int[] tops = {1, 2, 1, 1, 1, 2, 2, 2};
        int[] bottoms = {2, 1, 2, 2, 2, 2, 2, 2};
        System.out.println("Expected: 1. Received: " + obj.minDominoRotations(tops, bottoms));
    }
}

/**
 * reference
 * https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/discuss/252266/C%2B%2B-check-A0-and-B0
 */