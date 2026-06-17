class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        while(low<high){
            int mid = low+(high-low)/2;
            if(eatBananas(piles,h,mid)){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    public boolean eatBananas(int[] piles, int h, int k){
        int eatingTime=0;
        for(int i=0;i<piles.length;i++){
            eatingTime += piles[i] / k;

            if (piles[i] % k != 0) {
                eatingTime++;
            }
            if(eatingTime>h) return false;
        }
        return true;
    }
}
