class Solution {
    int[][] dp;
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        dp = new int[coins.length+1][amount+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        
        return dfs(coins,0,amount);
    }
    public int dfs(int[] coins, int index, int amount){
        if(index>=coins.length) return 0;
        if(amount==0) return 1;
        if(dp[index][amount]!=-1) return dp[index][amount];
        int res=0;
        if(amount>=coins[index]){
            res += dfs(coins,index,amount-coins[index]);
            res += dfs(coins,index+1,amount);
        }
        return dp[index][amount] = res;
    }
}
