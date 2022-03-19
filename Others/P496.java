package others;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Date: Jan 22, 2022 - Redo on March 19, 2022
 * 496. Next Greater Element I
 * https://leetcode.com/problems/next-greater-element-i/
 */

public class P496 {
    // monotonic stack
    // time: O(n)
    // space: O(n)
    public int[] _nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        // stack to keep possible first greater candidates for the current checking
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> hashTable = new HashMap<>();
        // the current checking element push at most once, and pop at most once
        // therefore, the time complexity will be O(n)
        for (int i = n - 1; i >= 0; i--) {
            int value = nums2[i];
            while (!stack.isEmpty() && stack.getFirst() < value) stack.pop();
            hashTable.put(value, stack.isEmpty() ? -1 : stack.getFirst());
            stack.push(value);
        }
        int[] answer = new int[m];
        for (int i = 0; i < m; i++)
            answer[i] = hashTable.get(nums1[i]);
        return answer;
    }

    // redo on March 19, 2022
    // time: O(n1 + n2)
    // space: O(1)
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[] hash = new int[10001];
        // find the greater element in nums2 array - takes O(n2)
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n2 - 1; i >= 0; i--) {
            int current = nums2[i];
            while (!stack.isEmpty() && stack.peek() < current) stack.pop();
            hash[current] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(current);
        }
        // populate solution array - takes O(n1)
        int[] ans = new int[n1];
        for (int i = 0; i < n1; i++) ans[i] = hash[nums1[i]];
        return ans;
    }
}

/**
 * reference
 * https://leetcode.com/problems/next-greater-element-i/discuss/97595/Java-10-lines-linear-time-complexity-O(n)-with-explanation
 * https://labuladong.gitbook.io/algo-en/ii.-data-structure/monotonicstack
 * https://www.baeldung.com/java-array-deque
 */