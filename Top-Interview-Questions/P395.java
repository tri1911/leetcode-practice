package topInterviewQs;

import java.util.Arrays;

/**
 * Date: Jan 17, 2022
 * 395. Longest Substring with At Least K Repeating Characters
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 */

// TODO: implement divide and conquer approach

public class P395 {
    // time: O(26 * n) -> O(n)
    // space: O(n)
    public int longestSubstring(String s, int k) {
        int n = s.length();
        if (n < k) return 0;
        int[] counter = new int[26];
        // count the max number of unique characters
        int uniqueMax = 0;
        for (char ch : s.toCharArray()) {
            if (counter[ch - 'a'] == 0) {
                counter[ch - 'a']++;
                uniqueMax++;
            }
        }
        // find the solution
        int ans = 0;
        for (int uniqueTotal = 1; uniqueTotal <= uniqueMax; uniqueTotal++) {
            // slide window technique
            Arrays.fill(counter, 0);
            int left = 0, right = 0;
            int currentValid = 0, currentUnique = 0;
            while (right < n) {
                if (currentUnique <= uniqueTotal) { // expands the window
                    int val = s.charAt(right++) - 'a';
                    if (counter[val]++ == 0)
                        currentUnique++;
                    if (counter[val] == k)
                        currentValid++;
                } else { // shrinks the window
                    int val = s.charAt(left++) - 'a';
                    if (counter[val]-- == k)
                        currentValid--;
                    if (counter[val] == 0)
                        currentUnique--;
                }
                if (currentUnique == uniqueTotal && currentValid == currentUnique)
                    ans = Math.max(ans, right - left);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        P395 obj = new P395();
        System.out.println("Expected: 3. Received: " + obj.longestSubstring("aaabb", 3));
        System.out.println("Expected: 5. Received: " + obj.longestSubstring("ababbc", 2));
    }
}

/**
 * reference
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/solution/
 */