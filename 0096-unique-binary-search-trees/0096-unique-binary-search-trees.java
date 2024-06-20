class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            for (int numLeft = 0; numLeft < i; numLeft++) {
                dp[i] += dp[numLeft] * dp[i - numLeft - 1];
            } 
        }

        return dp[n];
    }
}