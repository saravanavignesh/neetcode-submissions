class Solution {
    int[] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp,-1);
        int maxLis = 1;
        for(int i=0;i<n;i++){
            maxLis = Math.max(maxLis,rec(nums,i));
        }
        return maxLis;
    }

    public int rec(int[] nums, int i){
        if(dp[i]!=-1) return dp[i];
        int lis=1;
        for(int j=i+1;j<nums.length;j++){
            if(nums[i]<nums[j]){
                lis = Math.max(lis, 1+ rec(nums,j));
            }
        }
        dp[i]=lis;
        return lis;
    }
}
