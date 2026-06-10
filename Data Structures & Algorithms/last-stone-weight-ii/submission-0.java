class Solution {
    int[][]dp;
    public int lastStoneWeightII(int[] stones) {
        int totalSum = Arrays.stream(stones).sum();
        int mid = totalSum/2;
        dp = new int[stones.length][mid+1];
        for(int i=0;i<stones.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int minVal = dfs(stones, mid, 0, 0);
        System.out.println("minVal:"+minVal+",total:"+totalSum+",mid:"+mid);
        return (totalSum-minVal)-minVal;
    }

    public int dfs(int[] stones, int target, int sum, int index){
        if(index>=stones.length) return 0;
        if(dp[index][sum]!=-1) return dp[index][sum];
        int take = Integer.MIN_VALUE;
        if(sum+stones[index]<=target){
            take = stones[index] + dfs(stones, target, sum+stones[index], index+1);
        }
        int notTake = dfs(stones,target,sum,index+1);
        return dp[index][sum] = Math.max(take,notTake);
    }
}