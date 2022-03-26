package programmingSkills1;

/**
 * Date: March 25, 2022
 * 1603. Design Parking System
 * https://leetcode.com/problems/design-parking-system/
 */

public class P1603 {
    private final int[] spaces;

    // time: O(1)
    public P1603(int big, int medium, int small) {
        spaces = new int[]{big, medium, small};
    }

    // time: O(1)
    public boolean addCar(int carType) {
        if (spaces[carType - 1] == 0) return false;
        spaces[carType - 1]--;
        return true;
    }
}
