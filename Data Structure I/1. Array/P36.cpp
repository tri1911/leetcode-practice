// Date: Sat, Oct 2, 2021
// 36. Valid Sudoku (https://leetcode.com/problems/valid-sudoku/)

// Using Hash Table approach
// time complexity O(n^2)
// space complexity O(n^4)
bool isValidSudoku(vector<vector<char>>& board) {
	// hash tables
	// each row represents the row/col/sub-box
	// e.g. rows_table[1] represents the second row
	// each column represents whether a value occurs in this row/col/sub-box
	// e.g. rows_table[1][8] = true means the number 9 is already exist in the second row
	vector<vector<bool>> rows_table(9, vector<bool>(9)); // OR bool rows_table[9][9] = {};
	vector<vector<bool>> cols_table(9, vector<bool>(9));
	vector<vector<bool>> sub_boxes_table(9, vector<bool>(9));
	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			if (board[i][j] != '.') {
				int value = board[i][j] - '0' - 1;
				int k = (i / 3) * 3 + (j / 3);
				if (rows_table[i][value] || cols_table[j][value] || sub_boxes_table[k][value])
					return false;
				rows_table[i][value] = cols_table[j][value] = sub_boxes_table[k][value] = true;
			}
		}
	}
	return true;
}

// 4ms solution (using bit manipulation)
bool isValidSudoku(vector<vector<char>>& board) {
	int row[9] = {};
	int column[9] = {};
	int square[3][3] = {};
	for(int i = 0; i < 9; i++){
		for(int j = 0; j < 9; j++){
			if(board[i][j] != '.'){
				int x = board[i][j] - '0';
				// check whether the x-1 th bit is 1
				if(row[i] & 1<<(x-1) || column[j] & 1<<(x-1) || square[i/3][j/3] & 1 << (x-1))
					return false;
				// set the x-1 th bit to 1
				row[i] = row[i] | 1<<(x-1);
				column[j] = column[j] | 1<<(x-1);
				square[i/3][j/3] = square[i/3][j/3] | 1<< (x-1);
			}
		}
	}
	return true;
}