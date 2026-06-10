class Solution {
    Integer[][] dp;

    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new Integer[n][2];

        return dfs(prices, 0, 0); // 0 = not holding, 1 = holding
    }

    private int dfs(int[] prices, int i, int holding) {
        if (i >= prices.length) {
            return 0;
        }

        if (dp[i][holding] != null) {
            return dp[i][holding];
        }

        int ans;

        if (holding == 1) {
            // Sell or Hold
            int sell = prices[i] + dfs(prices, i + 2, 0); // cooldown
            int hold = dfs(prices, i + 1, 1);

            ans = Math.max(sell, hold);
        } else {
            // Buy or Skip
            int buy = -prices[i] + dfs(prices, i + 1, 1);
            int skip = dfs(prices, i + 1, 0);

            ans = Math.max(buy, skip);
        }

        return dp[i][holding] = ans;
    }
}