class Solution {
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return dfs(obstacleGrid, m, n, 0, 0);
    }
    public int dfs(int[][] obstacleGrid, int m, int n, int i, int j){
        if(i>=m||j>=n||i<0||j<0 || obstacleGrid[i][j]==1) return 0;
        if(i==m-1 && j==n-1) return 1;
        if(dp[i][j]!=-1) return dp[i][j];

        int res = 0;
        res += dfs(obstacleGrid,m,n,i+1,j) + dfs(obstacleGrid,m,n,i,j+1);
        return dp[i][j]=res;
    }
}