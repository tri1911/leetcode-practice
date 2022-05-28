package topInterviewQs;

/**
 * Date: Jan 8, 2022 - Redo: May 28, 2022
 * 268. Missing Number
 * https://leetcode.com/problems/missing-number/
 */

public class P268 {
    /*  First attempt
        // time complexity: O(n)
        // space complexity: O(1)
        public int missingNumber(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                while (nums[i] < n && nums[nums[i]] != nums[i]) {
                    int tmp = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = tmp;
                }
            }
            int ans = 0;
            while (ans < n && nums[ans] == ans)
                ans++;
            return ans;
        }
     */

    // use XOR, trick is a^b^b = a
    // time complexity: O(n)
    // space complexity: O(1)
    public int missingNumber(int[] nums) {
        int ans = nums.length;
        for (int i = 0; i < nums.length; i++)
            ans = ans ^ i ^ nums[i];
        return ans;
    }

    // redo on May 28, 2022
    public int _missingNumber(int[] nums) {
        int n = nums.length, sum = 0;
        for (int num : nums) sum += num;
        return n * (n + 1) / 2 - sum;
    }
}

/**
 * reference
 * https://leetcode.com/problems/missing-number/discuss/69791/4-Line-Simple-Java-Bit-Manipulate-Solution-with-Explaination
 */