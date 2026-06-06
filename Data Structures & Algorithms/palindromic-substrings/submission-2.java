class Solution {
    public int countSubstrings(String s) {
        int result=0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=true;
            result++;
        }
        //System.out.println("result:"+result);
        for(int len=2;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j=i+len-1;
                if(s.charAt(i)==s.charAt(j)){
                    if(len<=3){
                        //System.out.println("i:"+i+", j:"+j+", result:"+result);
                        dp[i][j]=true;
                        result++;
                    }else{
                        //System.out.println("i:"+i+", j:"+j+", result:"+result);
                        dp[i][j]=dp[i+1][j-1];
                        if(dp[i+1][j-1]) result++;
                    }
                }
            }
        }
        return result;
    }
}
