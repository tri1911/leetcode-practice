package leetcodingchallenge.june2022;

/**
 * Date: June 20, 2022
 * 820. Short Encoding of Words
 * https://leetcode.com/problems/short-encoding-of-words/
 */

import java.util.*;

public class P820 {
    // Approach 1: hash table
    // time: O(n^2)
    // space: O(n)
    public int _minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int begin = 1; begin < word.length(); begin++) {
                set.remove(word.substring(begin));
            }
        }
        int ans = 0;
        for (String word : set) {
            ans += word.length() + 1;
        }
        return ans;
    }

    // ================================================================

    // Approach 2: Trie - time & space: O(n)
    // idea: build prefix-trie (actually are prefixes of revered-words)
    // then the leaves of trie represents words are not be suffix of other
    // problem: quick way to get the words which the leaves represent?
    // leave - has no children
    public int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode();
        // [leaves:index] - space: O(n)
        Map<TrieNode, String> nodes = new HashMap<>();
        // populate the trie - time: O(7 * n) since word.length() <= 7
        for (String word : words) {
            TrieNode cur = root; // iterator
            for (int i = word.length() - 1; i >= 0; i--) {
                cur = cur.get(word.charAt(i));
            }
            nodes.put(cur, word);
        }
        // find solution - O(n)
        int ans = 0;
        for (TrieNode node : nodes.keySet()) {
            if (node.childrenCount == 0) {
                ans += nodes.get(node).length() + 1;
            }
        }
        return ans;
    }
    
    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int childrenCount = 0;
        // method to get the child TrieNode - update count at the same time
        public TrieNode get(char ch) {
            int key = ch - 'a';
            if (children[key] == null) {
                childrenCount++;
                children[key] = new TrieNode();
            }
            return children[key];
        }
    }
}

/**
 * references
 * https://leetcode.com/problems/short-encoding-of-words/solution/
 */
