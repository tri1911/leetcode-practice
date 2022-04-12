package topInterviewQs;

/**
 * Date: Feb 11, 2022 - Redo on April 12, 2022
 * 289. Game of Life
 * https://leetcode.com/problems/game-of-life/
 */

public class P289 {
    // use 2 bits to represent the next state and current state
    // i.e. 10 = next state is live <- current state is dead

    // rules:
    // live with < 2 or > 3 => die (do not care about this one)
    // live with lives == 2 or 3 => live
    // die with lives == 3 => live

    // initially, next state of all cells is dead
    // => only need to make an update when next state is live (transition 00 (0) -> 10 (2) or 01 (1) -> 11 (3))

    // important tricks
    // - get the current state using `& 1`
    // - update the next state by setting to 10, 11

    // time: O(mn)
    // space: O(1)
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        // examine each cell one by one
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int lives = 0;
                // count the number of neighbor lives
                for (int newRow = row - 1; newRow <= row + 1; newRow++)
                    for (int newCol = col - 1; newCol <= col + 1; newCol++)
                        if (newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && !(newRow == row && newCol == col))
                            lives += board[newRow][newCol] & 1;
                // determine the next state based on the # of lives
                // update 01 -> 11
                if (board[row][col] == 1 && (lives == 2 || lives == 3))
                    board[row][col] = 3;
                // update 00 -> 10
                if (board[row][col] == 0 && lives == 3)
                    board[row][col] = 2;
            }
        }
        // finalize the cells' state => get rid the current state
        for (int row = 0; row < m; row++)
            for (int col = 0; col < n; col++)
                board[row][col] >>= 1;
    }
}

/**
 * reference
 * https://leetcode.com/problems/game-of-life/discuss/73223/Easiest-JAVA-solution-with-explanation
 */