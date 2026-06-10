class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return dfs(text1, text2,m,n,0,0);    
    }

    public int dfs(String text1, String text2, int m, int n, int i, int j){
        if(i>=m||j>=n){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int res=0;
        if(text1.charAt(i)==text2.charAt(j)){
            res = 1+dfs(text1,text2,m,n,i+1,j+1);
        }else{
            res = Math.max(dfs(text1,text2,m,n,i+1,j), dfs(text1,text2,m,n,i,j+1));
        }
        return dp[i][j]=res;
    }

}
