package algorithm2.twoPointers;

// date: Dec 17, 2021
// 11. Container With Most Water
// https://leetcode.com/problems/container-with-most-water/

// TODO: Redo to gain more understand of the solution

// time complexity: O(n)
// space complexity: O(1)
public class P11 {
    // first attempt (Wrong Answer)
//    public static int _maxArea(int[] height) {
//        int left = 0, right = height.length - 1;
//        int ans = Integer.MIN_VALUE;
//        while (left < right) {
//            int minHeight = Math.min(height[left], height[right]);
//            ans = Math.max(ans, (right - left) * minHeight);
//            if (Math.min(height[left + 1], height[right]) > Math.min(height[left], height[right - 1]))
//                left++;
//            else
//                right--;
//        }
//        return ans;
//    }

    public static int maxArea(int[] height) {
        int ans = Integer.MIN_VALUE;
        int left = 0, right = height.length - 1;
        while (left < right) {
            // update the global max
            ans = Math.max(ans, (right - left) * Math.min(height[left], height[right]));
            // decide which way to move right/left pointers
            // case 1: (left, right - 1), (left, right - 2)... always decrease
            if (height[left] < height[right]) left++;
            else right--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Expected: 49. Output: " + maxArea(height));

        height = new int[]{1, 1};
        System.out.println("Expected: 1. Output: " + maxArea(height));

        height = new int[]{4, 3, 2, 1, 4};
        System.out.println("Expected: 16. Output: " + maxArea(height));

        height = new int[]{1, 2, 1};
        System.out.println("Expected: 2. Output: " + maxArea(height));

        height = new int[]{1, 3, 2, 5, 25, 24, 5};
        System.out.println("Expected: 24. Output: " + maxArea(height));
    }
}

// reference
// https://leetcode.com/problems/container-with-most-water/discuss/200246/Proof-by-formula (Author: https://leetcode.com/chipbk10/)
