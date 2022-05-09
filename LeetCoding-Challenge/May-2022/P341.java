package leetcodingchallenge.may2022;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.ListIterator;

/**
 * Date: May 08, 2022
 * 341. Flatten Nested List Iterator
 * https://leetcode.com/problems/flatten-nested-list-iterator/
 */

public class P341 {
    // stack contains list iterators
    private Deque<ListIterator> stack;

    public P341(List<NestedInteger> nestedList) {
        stack = new ArrayDeque<>();
        stack.push(nestedList.listIterator());
    }

    public Integer next() {
        // call hasNext() to prepare for the next Integer
        if (this.hasNext()) {
            ListIterator<NestedInteger> listIterator = stack.peek();
            NestedInteger nextNestedInteger = listIterator.next();
            return nextNestedInteger.getInteger();
        }
        return null;
    }

    public boolean hasNext() {
        while (!stack.isEmpty()) {
            ListIterator<NestedInteger> listIterator = stack.peek();
            if (listIterator.hasNext()) {
                // examine the next NestedInteger in the list at the top
                NestedInteger nextNestedInteger = listIterator.next();
                // if the next nestedInteger is an integer then returning true
                if (nextNestedInteger.isInteger()) {
                    // move backward before returning true
                    listIterator.previous();
                    return true;
                } else {
                    // if the next nestedInteger is a list then push that list into the stack
                    List<NestedInteger> nestedList = nextNestedInteger.getList();
                    stack.push(nestedList.listIterator());
                }
            } else { // if there is no element anymore in the list at the top, throwing away it
                stack.pop();
            }
        }
        return false;
    }

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    private interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}


/**
 * references
 * https://leetcode.com/problems/flatten-nested-list-iterator/discuss/80146/Real-iterator-in-Python-Java-C%2B%2B
 */

 // TODO: implement the better solution
 /*
    public class NestedIterator implements Iterator<Integer> {
        List<Integer> list;
        int index = 0;
        
        public NestedIterator(List<NestedInteger> nestedList) {
            list = new ArrayList<Integer>();
            worker(nestedList);
        }

        void worker(List<NestedInteger> node) {
            if(node == null) {
                return;
            }
            for(NestedInteger next : node) {
                if(next.isInteger()) {
                    list.add(next.getInteger());
                } else {
                    worker(next.getList());
                }
            }
        }
        
        @Override
        public Integer next() {
            int val = list.get(index++);
            index++;
            return val;
        }

        @Override
        public boolean hasNext() {
            return index < list.size();
        }
    }
 */