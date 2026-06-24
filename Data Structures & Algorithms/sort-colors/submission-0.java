class Solution {
    public void sortColors(int[] nums) {
        int i=0,l=0,r=nums.length-1;
        while(i<=r){
            if(nums[i]==0){
                swap(nums,i,l);
                l++;
            }
            else if(nums[i]==2){
                swap(nums,i,r);
                r--;
                i--;
            }
            i++;
        }
    }

    public void swap(int[] nums, int one, int two){
        int temp = nums[one];
        nums[one] = nums[two];
        nums[two] = temp;
    }
}