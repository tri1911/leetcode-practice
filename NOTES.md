# Useful Algorithms
- [Quickselect](https://leetcode.com/problems/top-k-frequent-elements/solution/) (Hoare's selection algorithm)
	- https://rcoh.me/posts/linear-time-median-finding/
	- https://youtu.be/BP7GCALO2v8
	- https://stackoverflow.com/questions/11068429/nth-element-implementations-complexities
 
- [KMP](https://leetcode.com/problems/shortest-palindrome/solution/)
- [Morris Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/solution/)
	- https://stackoverflow.com/questions/5502916/explain-morris-inorder-tree-traversal-without-using-stacks-or-recursion

# Snippets to review
## Iterative In-order Traversal Implementation
```java
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;
    while (curr != null || !stack.isEmpty()) {
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.pop();
        res.add(curr.val);
        curr = curr.right;
    }
    return res;
}
```