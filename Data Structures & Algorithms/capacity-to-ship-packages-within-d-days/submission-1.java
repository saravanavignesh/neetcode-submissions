class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left=getMax(weights), right=getSum(weights);
        while(left<=right){
            int mid = left+(right-left)/2;
            if(canShip(weights,mid,days)){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return left;    
    }

    public int getSum(int[] weights){
        int sum=0;
        for(int i=0;i<weights.length;i++){
            sum += weights[i];
        }
        return sum;
    }

    public boolean canShip(int[] weights, int capacity, int days){
        int daysTaken=0;
        int currCapacity = 0;
        for(int i=0;i<weights.length;i++){
            if(capacity<weights[i]) return false;
            
            currCapacity += weights[i];

            if(currCapacity>capacity){
                daysTaken++;
                currCapacity = weights[i];
            }
            
            if(daysTaken>days) return false;
        }
        daysTaken++;
        return (daysTaken>days) ? false : true;
    }

    public int getMax(int[] weights){
        int max = weights[0];
        for(int i=1;i<weights.length;i++){
            max = Math.max(max, weights[i]);
        }
        return max;
    }
}