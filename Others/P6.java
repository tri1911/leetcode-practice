package others;

/**
 * Date: April 05, 2022
 * 6. Zigzag Conversion
 * https://leetcode.com/problems/zigzag-conversion/
 */

public class P6 {
    /*  first attempt
        public String convert(String s, int numRows) {
            if (numRows == 1) return s;
            int n = s.length();
            int k = numRows + (numRows - 2);
            int numGroups = (n + k - 1) / k;
            char[][] mat = new char[numRows][numGroups * (numRows - 1)];
            int current = 0;
            for (int group = 0; group < numGroups; group++) {
                for (int col = 0; col < numRows - 1 && current < n; col++) {
                    int j = group * (numRows - 1) + col;
                    if (col == 0) {
                        for (int i = 0; i < numRows && current < n; i++) {
                            mat[i][j] = s.charAt(current++);
                        }
                    } else {
                        mat[numRows - 1 - col][j] = s.charAt(current++);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (char[] row : mat) {
                for (char ch : row) {
                    if (isValid(ch)) {
                        sb.append(ch);
                    }
                }
            }
            return sb.toString();
        }

        private boolean isValid(char ch) {
            return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || ch == ',' || ch == '.';
        }
     */

    // time: O(n)
    // space: O(1)
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        int n = s.length();
        int cycleLen = numRows + (numRows - 2);
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < numRows; row++) {
            for (int baseCol = 0; baseCol + row < n; baseCol += cycleLen) {
                int first = baseCol + row, second = baseCol + cycleLen - row;
                sb.append(s.charAt(first));
                if (second < n && second != first && second != baseCol + cycleLen) {
                    sb.append(s.charAt(second));
                }
            }
        }
        return sb.toString();
    }
}

/**
 * reference
 * https://leetcode.com/problems/zigzag-conversion/solution/
 */