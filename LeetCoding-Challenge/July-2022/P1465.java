package leetcodingchallenge.july2022;

import java.util.Arrays;

/**
 * Date: July 02, 2022
 * 1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
 * https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
 */

public class P1465 {
    // time: O(m*log(m) + n*log(n))
    // space: O(1)
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int m = horizontalCuts.length, n = verticalCuts.length;
        int maxHeight = 0, maxWidth = 0;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        for (int i = 0; i <= m; i++) {
            int current = (i == m ? h : horizontalCuts[i]) - (i == 0 ? 0 : horizontalCuts[i - 1]);
            maxHeight = Math.max(maxHeight, current);
        }
        for (int i = 0; i <= n; i++) {
            int current = (i == n ? w : verticalCuts[i]) - (i == 0 ? 0 : verticalCuts[i - 1]);
            maxWidth = Math.max(maxWidth, current);
        }
        return (int)((long) maxHeight * maxWidth % 1_000_000_007);
    }
}
