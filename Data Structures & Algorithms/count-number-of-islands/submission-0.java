class Solution {
    private int[] rowDir = {-1,1,0,0};
    private int[] colDir = {0,0,-1,1};
    public int numIslands(char[][] grid) {
        int islands = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    islands++;
                }
            }
        }
        return islands;
    }

    public void dfs(char[][] grid, int row, int col){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]=='0'){
            return;
        }

        grid[row][col] = '0';

        for(int i=0;i<4;i++){
            int nRow = row + rowDir[i];
            int nCol = col + colDir[i];
            dfs(grid, nRow, nCol);
        }
    }
}
