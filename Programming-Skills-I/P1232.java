package programmingSkills1;

/**
 * Date: March 19, 2022
 * 1232. Check If It Is a Straight Line
 * https://leetcode.com/problems/check-if-it-is-a-straight-line/
 */

public class P1232 {
    // time: O(n)
    // space: O(1)
    public boolean checkStraightLine(int[][] coordinates) {
        for (int i = 0; i < coordinates.length - 2; i++) {
            if (!check(coordinates[i], coordinates[i + 1], coordinates[i + 2])) return false;
        }
        return true;
    }

    private boolean check(int[] c1, int[] c2, int[] c3) {
        return (c2[1] - c1[1]) * (c3[0] - c2[0]) == (c3[1] - c2[1]) * (c2[0] - c1[0]);
    }

    public static void main(String[] args) {
        P1232 obj = new P1232();
        System.out.println("Expected: true. Received: " + obj.checkStraightLine(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
        System.out.println("Expected: false. Received: " + obj.checkStraightLine(new int[][]{{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}}));
        System.out.println("Expected: true. Received: " + obj.checkStraightLine(new int[][]{{0, 0}, {0, 1}, {0, -1}}));
    }
}

/**
 * reference
 * https://leetcode.com/problems/check-if-it-is-a-straight-line/discuss/620096/Java-Python3-CPP-or-Simple-code-with-explanation-or-100-fast-or-O(1)-space
 */