class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];

        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        
        return Math.max(houseRob(nums,nums.length-1,0,dp1),houseRob(nums,nums.length,1,dp2));
    }
    public int houseRob(int[] nums, int length, int level, int[] dp){
        if(level>=length) return 0;
        if(dp[level]!=-1) return dp[level];
        int take = nums[level]+houseRob(nums,length,level+2,dp);
        int notTake = houseRob(nums,length,level+1,dp);
        System.out.println("level:"+level+", take:"+take+", notTake:"+notTake);

        return dp[level] = Math.max(take,notTake);

    }
}
