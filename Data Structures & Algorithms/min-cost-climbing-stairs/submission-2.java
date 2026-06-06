class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(rec(cost,0,dp),rec(cost,1,dp));    
    }

    public int rec(int[] cost, int level, int[] dp){
        //base case
        if(level>=cost.length){
            return 0;
        }
        if(dp[level]!=-1) return dp[level];
        //save and compute
        int ans = 0;
        ans += Math.min(cost[level]+rec(cost,level+1,dp),cost[level]+rec(cost,level+2,dp));
        return dp[level] = ans;
    }
}
