package leetcodingchallenge.may2022;

/**
 * Date: May 29, 2022
 * 318. Maximum Product of Word Lengths
 * https://leetcode.com/problems/maximum-product-of-word-lengths/
 */

/**
 * Observation:
 * we take 26 bits to represent existing letters in the current `word`
 * indication of the letter existence with 1
 * e.g. 0....01 indicates the current word has 'a'
 * flip bits with OR binary operation |
 */
public class P318 {
    // time: O(n^2) where n is the number of words
    // space: O(n)
    public int maxProduct(String[] words) {
        int n = words.length;
        // step 1. populate the binary representations
        int[] binRep = new int[n]; // also, be called mask
        for (int i = 0; i < n; i++) {
            char[] current = words[i].toCharArray();
            for (char ch : current) {
                binRep[i] |= 1 << (ch - 'a');
            }
        }
        // 2. brute force iterate through pairs to find the solution
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                // valid if there is no shared letters
                if ((binRep[i] & binRep[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }
}

/**
 * references
 * https://leetcode.com/problems/maximum-product-of-word-lengths/discuss/76959/JAVA-Easy-Version-To-Understand!!!!!!!!!!!!!!!!!
 * https://leetcode.com/problems/maximum-product-of-word-lengths/discuss/76976/Bit-shorter-C%2B%2B
 */
