package others;

import java.util.Arrays;

/**
 * Date: March 14, 2022
 * 506. Relative Ranks
 * https://leetcode.com/problems/relative-ranks/
 */

public class P506 {
    // time: O(max)
    // space: O(max)
    public String[] findRelativeRanks(int[] score) {
        int max = 0;
        for (int val : score) if (val > max) max = val;
        // hash table: [score:index]
        int[] hash = new int[max + 1];
        for (int i = 0; i < score.length; i++) hash[score[i]] = i + 1;
        String[] ans = new String[score.length];
        int rankNumber = 1;
        for (int s = max; s >= 0; s--) {
            if (hash[s] != 0) {
                String rank = "";
                switch (rankNumber++) {
                    case 1:
                        rank = "Gold Medal";
                        break;
                    case 2:
                        rank = "Silver Medal";
                        break;
                    case 3:
                        rank = "Bronze Medal";
                        break;
                    default:
                        rank += rankNumber - 1;
                }
                ans[hash[s] - 1] = rank;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        P506 obj = new P506();
        System.out.println("Expected: [Gold Medal, Silver Medal, Bronze Medal, 4, 5]\nReceived: " + Arrays.toString(obj.findRelativeRanks(new int[]{5, 4, 3, 2, 1})));
    }
}