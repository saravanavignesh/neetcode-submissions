class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int left = 1, right=getMax(piles);
        int minHour = Integer.MAX_VALUE;
        while(left<=right){
            int mid = left + (right - left)/2;
            if(validTimeTaken(mid, piles, h)){
                minHour = Math.min(minHour, mid);
                right = mid - 1;
            }else{
                left = mid + 1;
            }   
        }
        return minHour;
    }

    public boolean validTimeTaken(int eatingRate, int[] piles, int h){
        int timeTaken = 0;
        for(int i=0;i<piles.length;i++){
            if(piles[i]<=eatingRate){
                timeTaken += 1;
            }else{
                int quotient = piles[i]/eatingRate;
                int remainder = (piles[i] % eatingRate==0)? 0 : 1;
                timeTaken += quotient+remainder;
            }
            if(timeTaken>h) return false; 
        }
        return true;
    }

    int getMax(int[] piles) {
        int max = piles[0];
        for (int pile : piles) {
            if (pile > max) max = pile;
        }
        return max;
    }
}
