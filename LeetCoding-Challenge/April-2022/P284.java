package leetcodingchallenge.april2022;

import java.util.Iterator;

/**
 * Date: April 25, 2022
 * 284. Peeking Iterator
 * https://leetcode.com/problems/peeking-iterator/
 */

public class P284 implements Iterator<Integer> {
    private Integer peekVal = null;
    private Iterator<Integer> current;

    public P284(Iterator<Integer> iterator) {
        // initialize any member here.
        current = iterator;
        peekVal = current.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return peekVal;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        // cache the current peek to return
        Integer ans = peekVal;
        // update the cached peek value
        peekVal = current.hasNext() ? current.next() : null;
        return ans;
    }

    @Override
    public boolean hasNext() {
        return peekVal != null;
    }
}
