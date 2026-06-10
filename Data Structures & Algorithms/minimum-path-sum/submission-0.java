class Solution {
    int[][]dp;
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return dfs(grid, m, n, 0, 0);
    }
    public int dfs(int[][] grid, int m, int n, int i, int j){
        if(i>=m||j>=n||i<0||j<0) return Integer.MAX_VALUE;
        if(i==m-1 && j==n-1) return grid[m-1][n-1];
        if(dp[i][j]!=-1) return dp[i][j];

        int res = 0;
        
        res += grid[i][j] + Math.min(dfs(grid,m,n,i+1,j),dfs(grid,m,n,i,j+1));
        //System.out.println("index i:"+i+",j:"+j+",res:"+res);
        return dp[i][j]=res;
    }
}