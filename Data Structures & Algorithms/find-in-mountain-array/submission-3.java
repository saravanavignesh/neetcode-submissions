/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        int peakIndex = findPeak(mountainArr, length);
        System.out.println("peakIndex:"+peakIndex);
        int peakVal = mountainArr.get(peakIndex);
        if(peakVal<target) return -1;
        if(peakVal==target) return peakIndex;
        int leftIndex = bs(mountainArr, 0, peakIndex-1, target);
        if (leftIndex != -1) return leftIndex;
        return bsRev(mountainArr, peakIndex+1, length-1, target);
    }

    public int findPeak(MountainArray mountainArr, int length){
        int left=0, right=length-1, mid;
        while(left<right){
            mid = left+(right-left)/2;
            if(mountainArr.get(mid)<mountainArr.get(mid+1)){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    public int bs(MountainArray mountainArr, int left, int right, int target){
        int mid;
        while(left<=right){
            mid = left+(right-left)/2;
            int midVal = mountainArr.get(mid);
            if(midVal==target){
                return mid;
            }
            else if(midVal<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return -1;
    }

    public int bsRev(MountainArray mountainArr, int left, int right, int target){
        int mid;
        while(left<=right){
            mid = left+(right-left)/2;
            int midVal = mountainArr.get(mid);
            if(midVal==target){
                return mid;
            }
            else if(midVal<target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }
}