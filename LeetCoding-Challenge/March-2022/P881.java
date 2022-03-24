package leetcodingchallenge.march2022;

/**
 * Date: March 24, 2022
 * 881. Boats to Save People
 * https://leetcode.com/problems/boats-to-save-people/
 */

import java.util.Arrays;

public class P881 {
    // own solution using 2 pointers & greedy algo
    // time: O(nlog(n))
    // space: O(1)
    public int numRescueBoats(int[] people, int limit) {
        // observation
        // to minimize the # of boats, people should share when possible
        // => choose the lightest & heaviest person
        // if the heaviest cannot share the boat with the lightest, then it is impossible for him/her to share with anyone else
        Arrays.sort(people);
        // find pairs with sum equal or less than limit
        int left = 0, right = people.length - 1, ans = 0;
        while (left <= right) {
            if (people[left] + people[right] <= limit) left++;
            right--;
            ans++;
        }
        return ans;
    }
}
