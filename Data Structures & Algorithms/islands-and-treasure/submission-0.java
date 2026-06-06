class Solution {
    private int[] rowDir = {-1,1,0,0};
    private int[] colDir = {0,0,-1,1};
    public void islandsAndTreasure(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    dfs(grid,i,j,0);
                }
            }
        }
        return;
    }

    private void dfs(int[][] grid, int row, int col, int dist) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return;
        if (grid[row][col] < dist) return; // Only update if new distance is smaller
        grid[row][col] = dist;
        for (int k = 0; k < 4; k++) {
            dfs(grid, row + rowDir[k], col + colDir[k], dist + 1);
        }
    }
}
