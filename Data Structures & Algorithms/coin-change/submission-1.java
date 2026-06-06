class Solution {
    Map<Integer, Integer> memo = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        int res = dfs(coins, amount);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int dfs(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return Integer.MAX_VALUE;
        if (memo.containsKey(amount)) return memo.get(amount);

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = dfs(coins, amount - coin);
            if (sub != Integer.MAX_VALUE) {
                min = Math.min(min, sub + 1);
            }
        }
        memo.put(amount, min);
        return min;
    }
}