package leetcodingchallenge.june2022;

/**
 * Date: Sat, June 18, 2022
 * 745. Prefix and Suffix Search
 * https://leetcode.com/problems/prefix-and-suffix-search/
 */

public class P745 {
    // space: O(arr_len * word_len)
    TrieNode trie; // this is the root
    // overall time: O(arr_len * word_len * word_len)
    // construct the Trie
    public P745(String[] words) {
        trie = new TrieNode();
        // weight here is actually the index of the word within the array
        // takes O(arr_len)
        for (int weight = 0; weight < words.length; weight++) {
            // transformed word to create the combination of `{suffix}#{original}`
            String word = words[weight] + "{"; // choose '{' here because it is the charater after 'z'
            // iterates through every possible suffixs [i...(n-1)] to construct the trie
            // takes O(word_len)
            for (int i = 0; i < word.length(); i++) {
                TrieNode cur = trie;
                cur.weight = weight;
                // why j upper value is 2 * n - 1? -> original + `#` + original = (n - 1) + 1 + (n - 1)
                // takes O(word_len)
                for (int j = i; j < 2 * word.length() - 1; j++) {
                    // mapped int of current character
                    int k = word.charAt(j % word.length()) - 'a';
                    // initialize a new TrieNode if it does not exist previously
                    if (cur.children[k] == null)
                        cur.children[k] = new TrieNode();
                    // move forward to the next node
                    cur = cur.children[k];
                    // update weight for node (largest one is desired)
                    cur.weight = weight;
                }
            }
        }
    }

    // time: O(word_len)
    public int f(String prefix, String suffix) {
        TrieNode cur = trie;
        for (char letter : (suffix + '{' + prefix).toCharArray()) {
            if (cur.children[letter - 'a'] == null) return -1;
            cur = cur.children[letter - 'a'];
        }
        return cur.weight;
    }

    private class TrieNode {
        TrieNode[] children;
        int weight;
        public TrieNode() {
            children = new TrieNode[27]; // including `#` as well
            weight = 0;
        }
    }
}

/**
 * references
 * https://leetcode.com/problems/prefix-and-suffix-search/solution/
 */