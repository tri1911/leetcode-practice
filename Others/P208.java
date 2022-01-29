package others;

/**
 * Date: Jan 28, 2022
 * 208. Implement Trie (Prefix Tree)
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */

class P208 {
    private TrieNode root;

    public P208() {
        root = new TrieNode();
    }

    // time: O(m) where m is the length of word
    // space: O(m)
    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            if (!current.containsKey(ch)) {
                current.put(ch, new TrieNode());
            }
            current = current.get(ch);
        }
        current.setEnd();
    }

    // time: O(m)
    // space: O(1)
    private TrieNode prefixSearch(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            if (current.containsKey(ch)) {
                current = current.get(ch);
            } else {
                return null;
            }
        }
        return current;
    }

    // time: O(m)
    // space: O(1)
    public boolean search(String word) {
        TrieNode node = prefixSearch(word);
        return node != null && node.isEnd();
    }

    // time: O(m)
    // space: O(1)
    public boolean startsWith(String prefix) {
        return prefixSearch(prefix) != null;
    }

    // TrieNode definition
    private class TrieNode {
        private final int R = 26;

        private TrieNode[] links;
        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }
}

/**
 * reference
 * https://leetcode.com/problems/implement-trie-prefix-tree/solution/
 */