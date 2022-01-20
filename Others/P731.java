package others;

// Date: Jan 9, 2022
// 731. My Calendar II
// https://leetcode.com/problems/my-calendar-ii/

import java.util.Map;
import java.util.TreeMap;

// TODO: check for better implementation
// https://leetcode.com/problems/my-calendar-ii/solution/

public class P731 {
    // the map used to save the change in the number of events at each timestamp
    private Map<Integer, Integer> events;

    public P731() {
        events = new TreeMap<>();
    }

    // my own implementation
    // TODO: double check the time complexity calculation
    // time complexity: O(n(log(n)) -> why O(n^2)
    // space complexity: O(n)
    public boolean book(int start, int end) {
        // insertion operation takes O(log(n))
        events.put(start, events.getOrDefault(start, 0) + 1);
        events.put(end, events.getOrDefault(end, 0) - 1);
        // check number of booked events - takes O(nlog(n))
        // run through each timestamp O(n) * look up the number of booked events O(log(n))
        int current = 0;
        // for (int time : events.keySet()) {
            // current += events.get(time);
        for (int bookedEvents : events.values()) {
            current += bookedEvents;
            if (current == 3) {
                events.put(start, events.get(start) - 1);
                if (events.get(start) == 0) events.remove(start);
                events.put(end, events.get(end) + 1);
                // if (events.get(end) == 0) events.remove(end); -> do not need this check
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */

/*  Solution sample with 10ms run time
    class MyCalendarTwo {

        // construct binary search tree
        private class Node {
            int start;
            int end;
            int count;
            Node left;
            Node right;
            Node(int start, int end) {
                this.start = start;
                this.end = end;
                count = 1;
            }
        }

        Node root;

        private Node book(Node node, int start, int end) {  // return reconstruced BST root
            if (node == null) {
                return new Node(start, end);
            }
            if (node.start >= end) {
                node.left = book(node.left, start, end);
                return node;
            }
            if (node.end <= start) {
                node.right = book(node.right, start, end);
                return node;
            }
            // there are overlap
            int leftStart = Math.min(start, node.start);
            int leftEnd = Math.max(start, node.start);
            int rightStart = Math.min(end, node.end);
            int rightEnd = Math.max(end, node.end);
            node.left = book(node.left, leftStart, leftEnd);
            node.right = book(node.right, rightStart, rightEnd);
            node.start = leftEnd;
            node.end = rightStart;
            node.count ++;
            return node;
        }

        private boolean canBook(Node node, int start, int end) {
            if (node == null || start >= end) {
                return true;
            }
            if (node.start >= end) {
                return canBook(node.left, start, end);
            }
            if (node.end <= start) {
                return canBook(node.right, start, end);
            }
            if (node.count == 2) {
                return false;
            }
            boolean left = canBook(node.left, start, node.start);
            if (!left) {
                return false;
            }
            return canBook(node.right, node.end, end);
        }

        public MyCalendarTwo() {
            root = book(root, 0, 0);
        }

        public boolean book(int start, int end) {
            if (canBook(root, start, end)) {
                book(root, start, end);
                return true;
            }
            return false;
        }
    }
 */