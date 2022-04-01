package leetcodingchallenge.march2022;

/**
 * Date: March 31, 2022
 * 410. Split Array Largest Sum
 * https://leetcode.com/problems/split-array-largest-sum/
 */

// TODO: checkout dynamic programming approaches & review binary search approaches

public class P410 {
    // Binary Search approach - similar to the MinMaxDivision problem on Codility
    // time: O(n*log(total))
    // space: O(1)
    public int splitArray(int[] nums, int m) {
        int low = nums[0], high = 0;
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }
        int ans = nums[0];
        while (low <= high) {
            int mid = (low + high) / 2;
            int sum = 0, blocks = 1;
            for (int num : nums) {
                if (sum + num > mid) {
                    blocks++;
                    sum = num;
                } else {
                    sum += num;
                }
            }
            if (blocks <= m) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        P410 obj = new P410();
        System.out.println("Expected: 18. Received: " + obj.splitArray(new int[]{7, 2, 5, 10, 8}, 2));
        System.out.println("Expected: 9. Received: " + obj.splitArray(new int[]{1, 2, 3, 4, 5}, 2));
        System.out.println("Expected: 4. Received: " + obj.splitArray(new int[]{1, 4, 4}, 3));
    }
}

/**
 * reference
 * https://leetcode.com/problems/split-array-largest-sum/solution/
 * https://app.codility.com/demo/results/training236TBU-9XN/
 */