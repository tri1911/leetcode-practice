package topInterviewQs;

// Date: Dec 29, 2021 - Redo on March 29, 2022 (Daily LeetCode Challenge)
// 287. Find the Duplicate Number
// https://leetcode.com/problems/find-the-duplicate-number/

public class P287 {
    // see the array as a linked list
    // nums[i] represents the next pointer of ith node -> nums[0] represents the head
    // Floyd's Tortoise and Hare algorithm
    // time complexity: O(n)
    // space complexity: O(1)
    public int findDuplicate(int[] nums) {
        int tortoise = nums[0], hare = nums[0];
        // find the intersection point
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);
        // find the entrance of the cycle
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        return hare;
    }

    // binary search approach
    // time: O(n * log(n))
    // space: O(1)
    public int _findDuplicate(int[] nums) {
        int low = 1, high = nums.length - 1, mid, count, ans = -1;
        // takes O(log(n)) time
        while (low <= high) {
            mid = (low + high) / 2;
            // count the # of numbers that less than or equal to mid
            count = 0;
            // takes O(n) time
            for (int num : nums) count += (num <= mid) ? 1 : 0;
            if (count > mid) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    // TODO: learn about other approaches

    public static void main(String[] args) {
        P287 obj = new P287();
        System.out.println("Expect: 2. Output: " + obj.findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println("Expect: 3. Output: " + obj.findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }
}

// reference
// https://leetcode.com/problems/find-the-duplicate-number/solution/