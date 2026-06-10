class Solution {
    //int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return dfs(m,n,0,0);    
    }

    public int dfs(int m, int n, int i, int j){
        if(i>=m||j>=n||i<0||j<0) return 0;
        if(i==m-1 && j==n-1) return 1;
        if(dp[i][j]!=-1) return dp[i][j];

        int res = 0;
        res += dfs(m,n,i+1,j) + dfs(m,n,i,j+1);
        return dp[i][j]=res;
    }

}
