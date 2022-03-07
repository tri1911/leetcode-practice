package leetcodingchallenge.march2022;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: March 04, 2022
 * 799. Champagne Tower
 * https://leetcode.com/problems/champagne-tower/
 */

public class P799 {
    // time: O(n*n)
    // space: O(n*n)
    public double champagneTower(int poured, int query_row, int query_glass) {
        List<double[]> tower = new ArrayList<>();
        tower.add(new double[]{poured});
        for (int row = 0; row < query_row; row++) {
            tower.add(new double[row + 2]);
            for (int glass = 0; glass <= row; glass++) {
                double amount = (tower.get(row)[glass] - 1) / 2;
                if (amount > 0) {
                    tower.get(row + 1)[glass] += amount;
                    tower.get(row + 1)[glass + 1] += amount;
                }
            }
        }
        return Math.min(1, tower.get(query_row)[query_glass]);
    }
}

/**
 * reference
 * https://leetcode.com/problems/champagne-tower/solution/
 */
