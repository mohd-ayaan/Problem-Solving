class Solution {
public:
    // DFS function to mark all connected '1's as visited ('0')
    void dfs(vector<vector<char>>& grid, int i, int j) {
        int n = grid.size();
        int m = grid[0].size();

        // Base case: If the current cell is out of bounds or is not '1', return
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] != '1') {
            return;
        }

        // Mark the current cell as visited ('0')
        grid[i][j] = '0';

        // Recursively visit all four neighboring cells (up, down, left, right)
        dfs(grid, i - 1, j); // up
        dfs(grid, i + 1, j); // down
        dfs(grid, i, j - 1); // left
        dfs(grid, i, j + 1); // right
    }

    int numIslands(vector<vector<char>>& grid) {
        int n = grid.size();
        int m = grid[0].size();

        int islandCount = 0; // Initialize the island count

        // Traverse the entire grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    // Perform DFS to mark all connected '1's as visited ('0')
                    dfs(grid, i, j);
                    islandCount++; // Increment the island count
                }
            }
        }

        return islandCount;
    }
};