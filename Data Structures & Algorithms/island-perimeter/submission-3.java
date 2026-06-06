class Solution {
    int perimeter = 0;
    int[] rowDir = {-1, 1, 0, 0};
    int[] colDir = {0, 0, -1, 1};

    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    return perimeter; // Only one island, so return directly
                }
            }
        }
        return 0;
    }

    public void dfs(int[][] grid, int row, int col) {
        // out of bounds → contributes 1 perimeter side
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            perimeter++;
            return;
        }

        // water → contributes 1 perimeter side
        if (grid[row][col] == 0) {
            perimeter++;
            return;
        }

        // already visited land
        if (grid[row][col] == -1) {
            return;
        }

        // mark visited
        grid[row][col] = -1;

        // explore all 4 directions
        for (int i = 0; i < 4; i++) {
            int nRow = row + rowDir[i];
            int nCol = col + colDir[i];
            dfs(grid, nRow, nCol);
        }
    }
}
