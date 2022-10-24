class Solution {
    public int minSteps(int n) {
        
        int[] dp = new int[n + 1];
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            if (dp[i] == 0) {
                //System.out.println("new val at " + i);
                dp[i] = i;
            }
            for (int j = 2; i * j <= n; j++) {
                dp[i * j] = dp[i] + j;
                //System.out.println("from " + i + " updating " + i * j + " to " + dp[i * j]);
            }
        }

        return dp[n];
    }
}