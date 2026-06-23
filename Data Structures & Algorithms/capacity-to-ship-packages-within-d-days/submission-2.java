class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = Arrays.stream(weights).max().getAsInt();
        int high = Arrays.stream(weights).sum();
        while(low<high){
            int mid = low+(high-low)/2;
            if(isPossibleToShip(weights,days,mid)){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    public boolean isPossibleToShip(int[] weights, int target, int capacity){
        int weight=0;
        int days=1;
        for(int i=0;i<weights.length;i++){
            if(weight+weights[i]<=capacity){
                weight+=weights[i];
            }else{
                weight=weights[i];
                days++;
            }
        }
        return (days<=target) ? true:false;
    }
}