package leetcodingchallenge.june2022;

/**
 * Date: Mon, June 27, 2022
 * 1689. Partitioning Into Minimum Number Of Deci-Binary Numbers
 * https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
 */

public class P1689 {
    // Observation: 82734 -> 2 (11111 + 11111) + 60514 -> 1 + 50403 -> 3 + 20100 -> 1 + 10000 -> 1 + 00000 => = 2 + 1 + 3 + 1 + 1
    // first attempt
    // time: O(n)
    // space: O(1)
    public int _minPartitions(String n) {
        int ans = n.charAt(0) - '0';
        for (int i = 1; i < n.length(); i++) {
            ans = Math.max(ans, n.charAt(i) - '0');
        }
        return ans;
    }

    // optimized solution
    public int minPartitions(String n) {
        int ans;
        for (ans = 9; ans >= 0; ans--) if (n.contains(String.valueOf(ans))) break;
        return ans;
    }
}
