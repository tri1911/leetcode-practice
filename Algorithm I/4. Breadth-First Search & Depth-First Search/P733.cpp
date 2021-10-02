// Date: Tue, Sep 28, 2021
// 733. Flood Fill (https://leetcode.com/problems/flood-fill/)

// time complexity: O(n)
// space complexity: O(1)
void dfs(vector<vector<int>>& image, int row, int col, int oldColor, int newColor) {
	int rows = image.size(), cols = image[0].size();
	if (image[row][col] != oldColor)
		return;
	image[row][col] = newColor;
	if (col > 0)
		dfs(image, row, col - 1, oldColor, newColor);
	if (col < cols - 1)
		dfs(image, row, col + 1, oldColor, newColor);
	if (row > 0)
		dfs(image, row - 1, col, oldColor, newColor);
	if (row < rows - 1)
		dfs(image, row + 1, col, oldColor, newColor);
}

vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
	int rows = image.size(), cols = image[0].size();
	int oldColor = image[sr][sc];
	if (oldColor != newColor)
		dfs(image, sr, sc, oldColor, newColor);
	return image;
}