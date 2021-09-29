// Date: Tue, Sep 28, 2021
// 733. Flood Fill (https://leetcode.com/problems/flood-fill/)

// time complexity: O(n)
// space complexity: O(n)
void helper(vector<vector<int>>& image, int row, int col, int oldColor, int newColor, vector<vector<bool>>& visited) {
	int rows = image.size(), cols = image[0].size();
	if (!(row >= 0 && row < rows && col >= 0 && col < cols) || image[row][col] != oldColor || visited[row][col])
		return;
	image[row][col] = newColor;
	visited[row][col] = true;
	helper(image, row, col - 1, oldColor, newColor, visited);
	helper(image, row, col + 1, oldColor, newColor, visited);
	helper(image, row - 1, col, oldColor, newColor, visited);
	helper(image, row + 1, col, oldColor, newColor, visited);
}

vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
	int rows = image.size(), cols = image[0].size();
	vector<vector<bool>> visited(rows, vector<bool>(cols));
	helper(image, sr, sc, image[sr][sc], newColor, visited);
	return image;
}