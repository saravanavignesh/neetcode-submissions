class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left=0, right=getSum(weights);
        while(left<=right){
            int mid = left+(right-left)/2;
            //System.out.println("");
            //System.out.println("mid:"+mid+" canShip:"+canShip(weights,mid,days));
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
        //System.out.println("daysTaken:"+daysTaken);
        return (daysTaken>days) ? false : true;
    }
}