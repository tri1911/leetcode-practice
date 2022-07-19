package leetcodingchallenge.july2022;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: July 19, 2022 - Redo (already solve in C++ since Sept 19, 2021)
 * 118. Pascal's Triangle
 * https://leetcode.com/problems/pascals-triangle/
 */

public class P118 {
    // time: O(numRows^2)
    // space: O(1)
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int row = 0; row < numRows; row++) {
            List<Integer> list = new ArrayList<>();
            if (row == 0) {
                list.add(1);
            } else {
                List<Integer> prev = ans.get(row - 1);
                for (int col = 0; col < row + 1; col++) {
                    int val = 0;
                    val += col > 0 ? prev.get(col - 1) : 0;
                    val += col < row ? prev.get(col) : 0;
                    list.add(val);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
