package leetcodingchallenge.june2022;

/**
 * Date: June 26, 2022
 * 1423. Maximum Points You Can Obtain from Cards
 * https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 */

public class P1423 {
    // time: O(n)
    // space: O(1)
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length, sum = 0;
        for (int point : cardPoints) sum += point;
        int currentWindow = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (i < n - k) {
                currentWindow += cardPoints[i];
                if (i == n - k - 1) {
                    ans = sum - currentWindow;
                }
            } else {
                currentWindow = currentWindow - cardPoints[i - (n - k)] + cardPoints[i];
                ans = Math.max(ans, sum - currentWindow);
            }
        }
        return ans;
    }
}
