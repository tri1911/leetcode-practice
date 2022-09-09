package leetcodingchallenge.september2022;

import java.util.Arrays;

/**
 * Date: September 09, 2022
 * 1996. The Number of Weak Characters in the Game
 * https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/
 */

public class P1996 {
    // time: O(n*log(n))
    // space: O(1)
    public int numberOfWeakCharacters(int[][] properties) {
        // sort property[0] in descending order & property[1] in ascending order
        Arrays.sort(properties, (p1, p2) -> p1[0] != p2[0] ? p2[0] - p1[0] : p1[1] - p2[1]);
        int ans = 0, tmp = Integer.MIN_VALUE;
        for (int[] prop : properties) {
            // cause the attack values are sorted, we only need to care about the defense values
            if (prop[1] < tmp) ans++;
            // update the current max defense so far
            tmp = Math.max(prop[1], tmp);
        }
        return ans;
    }
}
