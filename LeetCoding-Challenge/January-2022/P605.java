package leetcodingchallenge.january2022;

/**
 * Date: Jan 18, 2022
 * 605. Can Place Flowers
 * https://leetcode.com/problems/can-place-flowers/
 */

public class P605 {
    // my own solution
    // time: O(n)
    // space: O(1)
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                if (--n == 0) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        P605 obj = new P605();
        System.out.println("Expected: true. Received: " + obj.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        System.out.println("Expected: false. Received: " + obj.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
        System.out.println("Expected: false. Received: " + obj.canPlaceFlowers(new int[]{1, 0, 1, 0, 1, 0, 1}, 1));
        System.out.println("Expected: false. Received: " + obj.canPlaceFlowers(new int[]{1, 0, 1, 0, 1, 0, 1}, 0));
        System.out.println("Expected: true. Received: " + obj.canPlaceFlowers(new int[]{0, 0, 1, 0, 1}, 1));
    }
}

/**
 * reference
 * https://leetcode.com/problems/can-place-flowers/solution/
 */
