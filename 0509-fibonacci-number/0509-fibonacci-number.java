class Solution {
    
    public int fib(int n) {
        if (n < 2) return n;
        int[] dp = new int[n + 2];
        dp[1] = 1;
        dp[1 + 1] += dp[1];
        dp[1 + 2] += dp[1];
        for (int i = 2; i < n; i++) {
            dp[i + 1] += dp[i];
            dp[i + 2] += dp[i];
        }
        return dp[n];
    }
}