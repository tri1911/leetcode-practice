package leetcodingchallenge.june2022;

/**
 * Date: June 19, 2022
 * 1268. Search Suggestions System
 * https://leetcode.com/problems/search-suggestions-system/
 */

import java.util.ArrayList;
import java.util.List;

// TODO: redo for understanding more & read Binary Search approach in the official solution 

public class P1268 {
    private class Node {
        Node[] children = new Node[26];
        boolean isWord = false;
    }

    Node root, current;
    List<String> resultBuffer;

    private void insert(String word) {
        current = root;
        for (char ch : word.toCharArray()) {
            int key = ch - 'a';
            if (current.children[key] == null) {
                current.children[key] = new Node();
            }
            current = current.children[key];
        }
        current.isWord = true;
    }

    private void dfs(Node node, StringBuilder sb) {
        if (resultBuffer.size() == 3) return;
        if (node.isWord) resultBuffer.add(sb.toString());
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                dfs(node.children[i], sb.append((char) ('a' + i)));
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    private List<String> getWordsStartWith(StringBuilder prefix) {
        current = root;
        resultBuffer = new ArrayList<>();
        for (int i = 0; i < prefix.length(); i++) {
            int key = prefix.charAt(i) - 'a';
            // return an empty list of words
            if (current.children[key] == null) {
                return resultBuffer;
            }
            current = current.children[key];
        }
        dfs(current, prefix);
        return resultBuffer;
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        root = new Node();
        // construct the Trie
        for (String product : products) {
            insert(product);
        }
        // iterate through possible prefix of `searchWord`
        // to generate the corresponding list of word suggestions
        StringBuilder prefix = new StringBuilder();
        for (char ch : searchWord.toCharArray()) {
            result.add(getWordsStartWith(prefix.append(ch)));
        }
        return result;
    }
}

/**
 * references
 * https://leetcode.com/problems/search-suggestions-system/solution/
 */


