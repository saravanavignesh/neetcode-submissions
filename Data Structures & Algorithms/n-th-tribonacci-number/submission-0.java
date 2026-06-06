class Solution {
    public int tribonacci(int n) {
        if(n==0||n==1) return n;
        if(n==2) return 1;
        int result = 0, first = 1, second = 1, third = 0;
        for(int i=3;i<=n;i++){
            result = first+second+third;
            third = second;
            second = first;
            first = result;
        }
        return result;
    }
}