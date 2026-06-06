class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen=1;
        int startIndex=0;
        boolean[][]dp = new boolean[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=true;
        }
        for(int len=2;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j=i+len-1;
                if(s.charAt(i)==s.charAt(j)){
                    if(len<=3){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
                if(dp[i][j]&& len>maxLen){
                    maxLen = len;
                    startIndex=i;
                }
            }
        }
        return s.substring(startIndex,startIndex+maxLen);
    }

}
