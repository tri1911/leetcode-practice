package leetcodingchallenge.march2022;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Date: March 20, 2022
 * 895. Maximum Frequency Stack
 * https://leetcode.com/problems/maximum-frequency-stack/
 */

public class P895 {
    // time: O(1) for push, pop operations
    // space: O(n)
    class FreqStack {
        private int currentMax;
        // 2 key points
        // - need to know the frequency of a specific value (when it is pushed) => use hash table
        private Map<Integer, Integer> valToFreq;
        // - among the same frequency, need to know about which one is the most recently pushed => use stack
        private Map<Integer, Deque<Integer>> freqToStack;

        public FreqStack() {
            currentMax = 0;
            valToFreq = new HashMap<>();
            freqToStack = new HashMap<>();
        }

        public void push(int val) {
            // compute the new frequency for the pushed val
            int newFreq = valToFreq.getOrDefault(val, 0) + 1;
            // update its frequency from the computed value
            valToFreq.put(val, newFreq);
            // update the global current max
            currentMax = Math.max(currentMax, newFreq);
            // push the value into the stack grouped by frequency
            freqToStack.computeIfAbsent(newFreq, z -> new ArrayDeque<>()).push(val);
        }

        public int pop() {
            // from the current max, look at the stack of values with the max frequency
            // pop the value from that stack
            int removedVal = freqToStack.get(currentMax).pop();
            // update the popped value's freq
            valToFreq.put(removedVal, currentMax - 1);
            // update the global currentMax
            if (freqToStack.get(currentMax).isEmpty()) currentMax--;
            return removedVal;
        }
    }
}


/**
 * reference
 * https://leetcode.com/problems/maximum-frequency-stack/solution/
 */