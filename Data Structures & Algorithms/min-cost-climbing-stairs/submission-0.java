class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(recursion(0,cost),recursion(1,cost));
    }

    public int recursion(int index, int[] cost){
        if(index>=cost.length) return 0;
        
        int step1 = cost[index] + recursion(index+1,cost);
        int step2 = cost[index] + recursion(index+2,cost);
        return Math.min(step1, step2);
    }
}
