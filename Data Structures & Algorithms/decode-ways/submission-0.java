class Solution {

    int[] dp;

    public int numDecodings(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return rec(s, 0);
    }

    public int rec(String s, int level) {

        if (level == s.length()) {
            return 1;
        }

        if (s.charAt(level) == '0') {
            return 0;
        }

        if (dp[level] != -1) {
            return dp[level];
        }

        int ans = 0;

        // Take 1 digit
        ans += rec(s, level + 1);

        // Take 2 digits
        if (level + 1 < s.length()) {

            int num = Integer.parseInt(
                    s.substring(level, level + 2));

            if (num >= 10 && num <= 26) {
                ans += rec(s, level + 2);
            }
        }

        return dp[level] = ans;
    }
}