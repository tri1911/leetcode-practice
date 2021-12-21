package algorithm2.bdfAndDfs;

// date: Dec 15, 2021
// 117. Populating Next Right Pointers in Each Node II
// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

// TODO: Look at another precise solution
// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/discuss/37828/O(1)-space-O(n)-complexity-Iterative-Solution

//    public Node connect(Node root) {
//        var dummy = new Node();
//        Node current = dummy;
//        Node head = root;
//
//        while (root != null) {
//            if (root.left != null) {
//                current.next = root.left;
//                current = current.next;
//            }
//            if (root.right != null) {
//                current.next = root.right;
//                current = current.next;
//            }
//            root = root.next;
//            if (root == null) {
//                current = dummy;
//                root = dummy.next;
//                dummy.next = null;
//            }
//        }
//        return head;
//    }

// First attempt
// time complexity: O(n)
// space complexity: O(1)
public class P117 {
    // first attempt
//    public static Node connect(Node root) {
//        Node firstAtLevel = root;
//        while (firstAtLevel != null) {
//            Node current = firstAtLevel;
//            // connect all children of nodes at the current level
//            while (current != null) {
//                Node currentNext = current.next;
//                while (currentNext != null && currentNext.left == null && currentNext.right == null) {
//                    currentNext = currentNext.next;
//                }
//                if (current.left != null && current.right != null) {
//                    current.left.next = current.right;
//                    current.right.next = (currentNext != null) ? ((currentNext.left != null) ? currentNext.left : currentNext.right) : null;
//                } else if (current.left != null) {
//                    current.left.next = (currentNext != null) ? ((currentNext.left != null) ? currentNext.left : currentNext.right) : null;
//                } else if (current.right != null) {
//                    current.right.next = (currentNext != null) ? ((currentNext.left != null) ? currentNext.left : currentNext.right) : null;
//                }
//                current = currentNext;
//            }
//            // move down to the next level
//            while (firstAtLevel.left == null && firstAtLevel.right == null) {
//                if (firstAtLevel.next != null) {
//                    firstAtLevel = firstAtLevel.next;
//                } else {
//                    return root;
//                }
//            }
//            if (firstAtLevel.left != null) {
//                firstAtLevel = firstAtLevel.left;
//            } else {
//                firstAtLevel = firstAtLevel.right;
//            }
//        }
//        return null;
//    }

    // redo on Dec 19, 2021
    public static Node connect(Node root) {
        if (root == null) return null;
        Node parent = root;
        // use this dummy node to cache the leading node in the next level
        // (save into its next pointer)
        Node dummy = new Node();
        Node current = dummy;
        while (parent != null) {
            if (parent.left != null) {
                current.next = parent.left;
                current = current.next;
            }
            if (parent.right != null) {
                current.next = parent.right;
                current = current.next;
            }
            parent = parent.next;
            if (parent == null) {
                parent = dummy.next;
                // reset the dummy.next node to null
                dummy.next = null;
                current = dummy;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2, new Node(4), new Node(5), null);
        root.right = new Node(3, null, new Node(7), null);
        connect(root);

        root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node7;
        node3.right = node6;
        node6.right = node8;
        connect(root);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}