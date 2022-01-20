package topInterviewQs;

/**
 * Date: Jan 10, 2022
 * 169. Majority Element
 * https://leetcode.com/problems/majority-element/
 */

public class P169 {
    // Boyer-Moore Voting Algorithm
    // time complexity: O(n)
    // space complexity: O(1)
    public int majorityElement(int[] nums) {
        Integer candidate = null, count = 0;
        for (int num : nums) {
            if (count == 0) candidate = num;
            count += candidate == num ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        P169 obj = new P169();
        System.out.println("Expected: 3. Received: " + obj.majorityElement(new int[]{3, 2, 3}));
        System.out.println("----");
        System.out.println("Expected: 2. Received: " + obj.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}

/**
 * reference
 * https://leetcode.com/problems/majority-element/solution/
 */