package others;

import java.util.HashSet;
import java.util.Set;

/**
 * Date: March 29, 2022
 * 575. Distribute Candies
 * https://leetcode.com/problems/distribute-candies/
 */

public class P575 {
    // time & space: O(n)
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int type : candyType) set.add(type);
        return Math.min(set.size(), candyType.length / 2);
    }
}
