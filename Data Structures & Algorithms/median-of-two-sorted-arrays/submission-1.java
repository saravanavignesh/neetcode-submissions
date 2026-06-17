class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int left = (nums1.length+nums2.length+1)/2;
        int right = (nums1.length+nums2.length+2)/2;
        return (getKthElement(nums1,nums1.length, nums2, nums2.length,left,0,0)+
                getKthElement(nums1,nums1.length, nums2, nums2.length,right,0,0))/2.0;
    }

    public int getKthElement(int[] nums1,int nums1Len,int[] nums2,int nums2Len,int k, int nums1Ind, int nums2Ind){
        if(nums1Len>nums2Len){
            return getKthElement(nums2,nums2Len,nums1,nums1Len,k,nums2Ind,nums1Ind);
        }
        if(nums1Len==0){
            return nums2[nums2Ind+k-1];
        }
        if(k==1){
            return Math.min(nums1[nums1Ind],nums2[nums2Ind]);
        }
        int i= Math.min(nums1Len,k/2);
        int j= Math.min(nums2Len,k/2);
        if(nums1[nums1Ind + i -1]>nums2[nums2Ind + j -1]){
            return getKthElement(nums1,nums1Len,nums2,nums2Len-j,k-j,nums1Ind,nums2Ind+j);
        }else{
            return getKthElement(nums1,nums1Len-i,nums2,nums2Len,k-i,nums1Ind+i,nums2Ind);
        }
    }
}
