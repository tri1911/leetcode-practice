package leetcodingchallenge.january2022;

import java.util.HashSet;
import java.util.Set;

/**
 * Date: Jan 27, 2022
 * 421. Maximum XOR of Two Numbers in an Array
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
 */

// TODO: check out the Trie approach

public class P421 {
    // bit manipulation approach
    // time: O(n)
    // space: O(n)
    public int findMaximumXOR(int[] nums) {
        int ans = 0, mask = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 31; i >= 0; i--) {
            mask |= 1 << i;
            int target = ans | (1 << i);
            for (int num : nums) {
                int partial = num & mask;
                if (set.contains(partial ^ target)) {
                    ans = target;
                    break;
                }
                set.add(partial);
            }
            set.clear();
        }
        return ans;
    }

    /*
        int max = 0, mask = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 31; i >= 0; i--) {
            // mask will be 1000.., 1100..., 1110..., 1111...
            mask |= 1 << i;
            // we examine the left part til ith bit;
            // trick: get partial bits -> using &
            for (int num : nums) set.add(num & mask);
            // look for the desired max
            // trick: set bit using |
            int tmp = max | (1 << i);
            for (int num : set) {
                // trick: a ^ b = c <=> a ^ c = b (since: a ^ a ^ b = a ^ c)
                if (set.contains(num ^ tmp)) {
                    max = tmp;
                    break;
                }
            }
            // reset the set
            set.clear();
        }
        return max;
     */

    public static void main(String[] args) {
        P421 obj = new P421();
        System.out.println("Expected: 28. Received: " + obj.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
        System.out.println("Expected: 127. Received: " + obj.findMaximumXOR(new int[]{14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70}));
    }
}

/**
 * reference
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/discuss/91049/Java-O(n)-solution-using-bit-manipulation-and-HashMap
 * https://leetcode.com/problems/path-sum-iii/discuss/91878/17-ms-on-java-prefix-sum-method
 * https://www.geeksforgeeks.org/maximum-xor-of-two-numbers-in-an-array/
 * https://www.geeksforgeeks.org/maximum-xor-of-two-numbers-in-an-array-set-2/
 * https://www.youtube.com/watch?v=HAuqbJojVPk
 */
