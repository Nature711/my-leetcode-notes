class Solution {
    
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        
        dp[1] = 1;
        
        for (int curr = 2; curr <= n; curr++) {
            for (int i = curr - 1; i > 0; i--) {
                dp[curr] = Math.max(dp[curr], Math.max(i * dp[curr - i], i * (curr - i)));
            }
        }
        
        return dp[n];
    }
}


