class Solution {
    int[] dp;
    public int climbStairs(int n){
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return rec(0,n);
    }

    public int rec(int level, int n){
        if(level>n) return 0;
        if(level==n){
            return 1;
        }
        if(dp[level]!=-1){
            return dp[level];
        }
        return dp[level] = rec(level+1,n)+rec(level+2,n);
    }
}
