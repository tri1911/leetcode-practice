# Useful Algorithms

- [Quick Select](https://leetcode.com/problems/top-k-frequent-elements/solution/) (Hoare's selection algorithm)
  - https://rcoh.me/posts/linear-time-median-finding/
  - https://youtu.be/BP7GCALO2v8
  - https://stackoverflow.com/questions/11068429/nth-element-implementations-complexities

## Tree

- [KMP](https://leetcode.com/problems/shortest-palindrome/solution/)
- [Morris Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/solution/)
  - https://stackoverflow.com/questions/5502916/explain-morris-inorder-tree-traversal-without-using-stacks-or-recursion

## Graph

- [Minimum Spanning Tree - Kruskal & Prim](https://leetcode.com/problems/min-cost-to-connect-all-points/solution/)
  - [1584. Min Cost to Connect All Points](https://leetcode.com/problems/min-cost-to-connect-all-points/solution/)
- [Disjoint Set Union (DSU)](https://leetcode.com/explore/learn/card/graph/618/disjoint-set/)
  - [1202. Smallest String With Swaps](https://leetcode.com/problems/smallest-string-with-swaps/solution/)

# Useful Data Structures

## Trie

- [208. Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/solution/)
- [211. Design Add and Search Words Data Structure](https://leetcode.com/problems/design-add-and-search-words-data-structure/)
- [745. Prefix and Suffix Search](https://leetcode.com/problems/prefix-and-suffix-search/solution/)
- [1268. Search Suggestions System](https://leetcode.com/problems/search-suggestions-system/)

# Snippets to review

## Iterative In-order Traversal Implementation - Credit: https://leetcode.com/problems/binary-tree-inorder-traversal/solution/

```java
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode current = root;
    while (current != null || !stack.isEmpty()) {
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
        current = stack.pop();
        ans.add(current.val);
        current = current.right;
    }
    return ans;
}
```
