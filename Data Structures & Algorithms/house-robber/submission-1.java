class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return recursion(nums,nums.length-1,dp);
    }

    public int recursion(int[] nums, int index, int[] dp){
        if(index<0) return 0;
        if(index==0) return nums[0];
        if(dp[index]!=-1) return dp[index];
        int take = nums[index] + recursion(nums, index-2,dp);
        int notTake = recursion(nums,index-1,dp);
        return dp[index] = Math.max(take,notTake);
    }
}
