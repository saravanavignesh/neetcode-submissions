class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return Math.max(houseRob(nums,0,dp),houseRob(nums,1,dp));
    }
    public int houseRob(int[] nums, int level, int[] dp){
        if(level>=nums.length) return 0;
        if(dp[level]!=-1) return dp[level];
        int take = nums[level]+houseRob(nums,level+2,dp);
        int notTake = houseRob(nums,level+1,dp);
        System.out.println("level:"+level+", take:"+take+", notTake:"+notTake);

        return dp[level] = Math.max(take,notTake);

    }
}
