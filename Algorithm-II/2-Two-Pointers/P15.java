package algorithm2.twoPointers;

// date: Dec 14, 2021
// 15. 3Sum
// https://leetcode.com/problems/3sum/

import java.util.*;

// time complexity: O(n^2)
// space complexity: O(1)
public class P15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        int n = nums.length;
        if (n < 3) return ans;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] > 0) return ans;
            if (i == 0 || nums[i - 1] != nums[i]) {
                int low = i + 1;
                int high = nums.length - 1;
                int target = -nums[i];
                while (low < high) {
                    if (nums[low] + nums[high] == target) {
                        ans.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low + 1] == nums[low]) low++;
                        while (low < high && nums[high - 1] == nums[high]) high--;
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] > target) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Expect: [[-1,-1,2],[-1,0,1]]. Received: " + threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println("Expect: []. Received: " + threeSum(new int[]{}));
        System.out.println("Expect: []. Received: " + threeSum(new int[]{0}));
    }
}

// reference
// https://leetcode.com/problems/3sum/discuss/7380/Concise-O(N2)-Java-solution
