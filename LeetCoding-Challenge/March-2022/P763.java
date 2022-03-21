package leetcodingchallenge.march2022;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: March 21, 2022
 * 763. Partition Labels
 * https://leetcode.com/problems/partition-labels/
 */

public class P763 {
    // own solution
    // time: O(n)
    // space: O(1)
    public List<Integer> _partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int len = s.length();
        // determine the intervals of each character im the string
        int[][] intervals = new int[26][2];
        int firstCharKey = s.charAt(0) - 'a';
        for (int i = 1; i < len; i++) {
            int key = s.charAt(i) - 'a';
            if (intervals[key][0] == 0 && key != firstCharKey) intervals[key][0] = i;
            intervals[key][1] = i;
        }
        // merge intervals into separate intervals
        int[] merged = {0, intervals[firstCharKey][1]};
        for (int i = 1; i < len; i++) {
            int[] current = intervals[s.charAt(i) - 'a'];
            if (current[0] >= merged[0] && current[0] <= merged[1]) {
                merged[1] = Math.max(merged[1], current[1]);
            } else {
                ans.add(merged[1] - merged[0] + 1);
                merged[0] = current[0];
                merged[1] = current[1];
            }
        }
        ans.add(merged[1] - merged[0] + 1);
        return ans;
    }

    // optimized solution
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) last[s.charAt(i) - 'a'] = i;
        int start = 0, end = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                ans.add(end - start + 1);
                start = end + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        P763 obj = new P763();
        System.out.println("Expected: [9, 7, 8]\nReceived: " + obj.partitionLabels("ababcbacadefegdehijhklij").toString());
        System.out.println("Expected: [1, 9]\nReceived: " + obj.partitionLabels("caedbdedda").toString());
    }
}

/**
 * reference
 * https://leetcode.com/problems/partition-labels/solution/
 */