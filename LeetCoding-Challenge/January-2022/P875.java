package leetcodingchallenge.january2022;

/**
 * Date: Jan 20, 2022
 * 875. Koko Eating Bananas
 * https://leetcode.com/problems/koko-eating-bananas/
 */

// TODO: read official solution if have time

public class P875 {
    // my own solution
    // binary search approach
    // time: O(log(m) * n) where n is piles length & m is the maximum # of bananas
    // space: O(1)
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 1;
        for (int pile : piles) high = Math.max(pile, high);
        int ans = high;
        while (low <= high) {
            int mid = (low + high) / 2;
            int hours = 0;
            for (int pile : piles) hours += (pile + mid - 1) / mid;
            if (hours <= h) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        P875 obj = new P875();
        System.out.println("Expected: 1. Received: " + obj.minEatingSpeed(new int[]{312884470}, 968709470));
    }
}

/**
 * reference
 * https://leetcode.com/problems/koko-eating-bananas/solution/
 */