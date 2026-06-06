class Solution {
    private int[] rowDir = {-1,1,0,0};
    private int[] colDir = {0,0,-1,1};
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(maxArea, dfs(grid,i,j)); 
                }
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int row, int col){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]==0){
            return 0;
        }

        grid[row][col] = 0;
        int area = 1;
        for(int i=0;i<4;i++){
            int nRow = row + rowDir[i];
            int nCol = col + colDir[i];
            area += dfs(grid, nRow, nCol);
        }
        return area;
    }
}
