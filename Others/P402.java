package others;

/**
 * Date: Jan 26, 2022
 * 402. Remove K Digits
 * https://leetcode.com/problems/remove-k-digits/
 */

// TODO: check out whether there is better implementation

public class P402 {
    // observation: we can rephrase the problem as finding the smallest subsequence of length n - k
    // time: O(n)
    // space: O(n)
    public String removeKdigits(String num, int k) {
        // calculate the `target` which is the length of returned string
        int n = num.length(), target = n - k;
        if (target == 0) return "0";
        // stack contains the characters within returned string
        char[] stack = new char[target];
        for (int i = 0, j = 0; i < n; i++) {
            // if num[i] is less than the most recently added element (top element of stack), we pop it out of stack
            while (j > 0 && i < n - (target - j) && stack[j - 1] > num.charAt(i)) j--;
            // we push the num[i] into the stack (if the stack is not full)
            if (j < target) stack[j++] = num.charAt(i);
        }
        // get rid of leading zeros before return the result string
        int offset = 0;
        while (offset < target - 1 && stack[offset] == '0') offset++;
        return new String(stack, offset, target - offset);
    }

    public static void main(String[] args) {
        P402 obj = new P402();
        System.out.println("Expected: 1219. Received: " + obj.removeKdigits("1432219", 3));
        System.out.println("Expected: 200. Received: " + obj.removeKdigits("10200", 1));
        System.out.println("Expected: 0. Received: " + obj.removeKdigits("10", 2));
        System.out.println("Expected: 0. Received: " + obj.removeKdigits("10", 1));
    }
}
