package algorithm2.backtracking;

// date: Dec 21, 2021
// 79. Word Search
// https://leetcode.com/problems/word-search/

// TODO: analyze time complexity & find the better solution

// reference
// https://www.youtube.com/watch?v=m9TrOL1ETxI
// https://leetcode.com/problems/word-search/discuss/27658/Accepted-very-short-Java-solution.-No-additional-space.

public class P79 {
    /* Attempt 1 - Wrong answer
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];
                if (backtracking(0, i, j, visited, board, word)) return true;
            }
        }
        return false;
    }

    private boolean backtracking(int current, int row, int col, boolean[][] visited, char[][] board, String word) {
        if (current == word.length()) return true;
        visited[row][col] = true;
        if (board[row][col] != word.charAt(current)) return false;
        return (row > 0 && !visited[row - 1][col] && backtracking(current + 1, row - 1, col, visited, board, word))
                || (row < board.length - 1 && !visited[row + 1][col] && backtracking(current + 1, row + 1, col, visited, board, word))
                || (col > 0 && !visited[row][col - 1] && backtracking(current + 1, row, col - 1, visited, board, word))
                || (col < board[row].length - 1 && !visited[row][col + 1] && backtracking(current + 1, row, col + 1, visited, board, word));
    }

    Second attempt (171 ms -> Not efficient)

    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] isUsed = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                isUsed[i][j] = true;
                if (backtracking(isUsed, i, j, board, 0, word))
                    return true;
                isUsed[i][j] = false;
            }
        }
        return false;
    }

    private boolean backtracking(boolean[][] isUsed, int row, int col, char[][] board, int i, String word) {
        if (board[row][col] != word.charAt(i))
            return false;
        if (i == word.length() - 1)
            return true;
        for (int k = 0; k < 4; k++) {
            int newRow = row + directions[k][0];
            int newCol = col + directions[k][1];
            if (isValid(newRow, newCol, isUsed)) {
                isUsed[newRow][newCol] = true;
                if (backtracking(isUsed, newRow, newCol, board, i + 1, word)) {
                    return true;
                }
                isUsed[newRow][newCol] = false;
            }
        }
        return isUsed[row][col] = false;
    }

    private boolean isValid(int row, int col, boolean[][] visited) {
        return row >= 0 && col >= 0 && row < visited.length && col < visited[0].length && !visited[row][col];
    }
     */

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j] && search(i, j, board, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(int row, int col, char[][] board, int index, String word) {
        if (index == word.length())
            return true;
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(index))
            return false;
        board[row][col] = '*';
        if (search(row + 1, col, board, index + 1, word) ||
                search(row - 1, col, board, index + 1, word) ||
                search(row, col + 1, board, index + 1, word) ||
                search(row, col - 1, board, index + 1, word))
            return true;
        board[row][col] = word.charAt(index);
        return false;
    }

    public static void main(String[] args) {
        P79 p = new P79();

        System.out.println("Input: board = [[A, B, C, E], [S, F, C, S], [A, D, E, E]], word = `ABCCED`");
        System.out.println("Expect: true");
        System.out.println("Output: " + p.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));

        System.out.println("Input: board = [[A, B, C, E], [S, F, C, S], [A, D, E, E]], word = `SEE`");
        System.out.println("Expect: true");
        System.out.println("Output: " + p.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"));

        System.out.println("Input: board = [[A, B, C, E], [S, F, C, S], [A, D, E, E]], word = `ABCB`");
        System.out.println("Expect: false");
        System.out.println("Output: " + p.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB"));

        System.out.println("Input: board = [[a]], word = `a`");
        System.out.println("Expect: true");
        System.out.println("Output: " + p.exist(new char[][]{{'a'}}, "a"));

        System.out.println("Input: board = [[A, B, C, E], [S, F, E, S], [A, D, E, E]], word = `ABCESEEEFS`");
        System.out.println("Expect: true");
        System.out.println("Output: " + p.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCESEEEFS"));
    }
}

/* 1 ms solution
    public boolean hasEnoughChars(char[][] board, String word) {
        if (board.length * board[0].length < word.length()) {
            return false;
        }
        int[] boardChars = new int[128];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boardChars[board[i][j]]++;
            }
        }
        for (char c : word.toCharArray()) {
            if (--boardChars[c] < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        if (!hasEnoughChars(board, word) || !checkNeighbours(board, word)) {
            return false;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (find(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkNeighbours(char[][] board, String word) {
        boolean[][] neighbours = new boolean[128][128];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i > 0) {
                    char c1 = board[i][j];
                    char c2 = board[i - 1][j];
                    neighbours[c1][c2] = true;
                    neighbours[c2][c1] = true;
                }
                if (j > 0) {
                    char c1 = board[i][j];
                    char c2 = board[i][j - 1];
                    neighbours[c1][c2] = true;
                    neighbours[c2][c1] = true;
                }
            }
        }
        for (int i = 0; i < word.length() - 1; i++) {
            if (!neighbours[word.charAt(i)][word.charAt(i + 1)]) {
                return false;
            }
        }
        return true;
    }

    public boolean find(char[][] board, int row, int col, int pos, String word) {

        if (pos == word.length()) {
            return true;
        }

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return false;
        }

        char c = word.charAt(pos);
        if (c == board[row][col]) {
            pos++;
            board[row][col] = '0';
            if (find(board, row - 1, col, pos, word) ||
                    find(board, row + 1, col, pos, word) ||
                    find(board, row, col - 1, pos, word) ||
                    find(board, row, col + 1, pos, word)) {
                return true;
            }
            board[row][col] = c;
        }
        return false;
    }
 */
