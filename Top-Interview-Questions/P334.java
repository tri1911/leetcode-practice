package topInterviewQs;

// Date: Dec 28, 2021
// 334. Increasing Triplet Subsequence
// https://leetcode.com/problems/increasing-triplet-subsequence/

public class P334 {
    // greedy algorithm
    // time complexity: O(n)
    // space complexity: O(1)
    public boolean increasingTriplet(int[] nums) {
        // records two first elements in the triplet - first is the smallest, second is the second-smallest
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int val : nums) {
            if (val <= first) {
                first = val;
            } else if (val <= second) { // val > first, but val <= second
                second = val;
            } else { // val > second -> found the final piece in the increasing triplet
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        P334 obj = new P334();
        System.out.println("Expect: true. Output: " + obj.increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        System.out.println("Expect: false. Output: " + obj.increasingTriplet(new int[]{5, 4, 3, 2, 1}));
        System.out.println("Expect: true. Output: " + obj.increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));
        System.out.println("Expect: true. Output: " + obj.increasingTriplet(new int[]{2, 10, 9, 4, 6}));
    }
}

// reference
// https://leetcode.com/problems/increasing-triplet-subsequence/discuss/79004/Concise-Java-solution-with-comments.