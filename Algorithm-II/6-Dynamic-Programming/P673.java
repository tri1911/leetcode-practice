package algorithm2.dynamicProgramming;

// date: Dec 23, 2021
// 673. Number of the Longest Increasing Subsequence
// https://leetcode.com/problems/number-of-longest-increasing-subsequence/

// TODO: spend some time to learn about `Segment Tree` and `Binary Indexed Tree` concepts
// https://www.educative.io/edpresso/what-is-a-binary-indexed-tree
// https://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/
// https://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/

// TODO: check out whether there is any better approach? with O(nlog(n)) time?
// https://leetcode.com/problems/number-of-longest-increasing-subsequence/discuss/107295/9ms-C%2B%2B-Explanation%3A-DP-%2B-Binary-search-%2B-prefix-sums-O(NlogN)-time-O(N)-space

public class P673 {
    // dynamic programming approach
    // time complexity: O(n*n)
    // space complexity: O(n)
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int globalMax = Integer.MIN_VALUE, ans = 0;
        // records the longest increasing subsequence ending at ith index
        int[] maxLen = new int[n];
        // records the number of the longest increasing subsequence ending at ith index
        int[] counter = new int[n];
        for (int i = 0; i < n; i++) {
            maxLen[i] = counter[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // update the maxLen[i] & counter[i]
                    if (maxLen[j] + 1 > maxLen[i]) {
                        maxLen[i] = maxLen[j] + 1;
                        counter[i] = counter[j];
                    } else if (maxLen[j] + 1 == maxLen[i])
                        counter[i] += counter[j];
                }
            }
            if (maxLen[i] > globalMax) {
                globalMax = maxLen[i];
                ans = counter[i];
            } else if (maxLen[i] == globalMax) {
                ans += counter[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        P673 p = new P673();
        System.out.println("------------------------");
        System.out.println("Input: nums = [1, 3, 5, 4, 7]");
        System.out.println("Expect: 2");
        System.out.println("Output: " + p.findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println("------------------------");
        System.out.println("Input: nums = [2, 2, 2, 2, 2]");
        System.out.println("Expect: 5");
        System.out.println("Output: " + p.findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));
    }
}

// reference
// https://leetcode.com/problems/number-of-longest-increasing-subsequence/discuss/107293/JavaC%2B%2B-Simple-dp-solution-with-explanation