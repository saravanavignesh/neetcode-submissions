class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int right;
        for(int left=0;left<nums.length-1;left++){
            right=left+1;
            while(right<=left+k && right<nums.length){
                if(left!=right && nums[left]==nums[right] && Math.abs(left-right)<=k){
                    return true;
                }
                right++;
            }
        }
        return false;
    }
}