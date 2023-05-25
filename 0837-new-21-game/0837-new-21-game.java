class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0) return 1;
        double[] dp = new double[Math.max(n, k - 1 + maxPts) + 1];
        
        for (int i = n + 1; i < dp.length; i++) dp[i] = 0;
        for (int i = k; i <= n; i++) dp[i] = 1;
        double sum = 0;
        for (int draw = 1; draw <= maxPts; draw++) sum += dp[k - 1 + draw];
        dp[k - 1] = sum / maxPts;
        for (int i = k - 2; i >= 0; i--) {
            //System.out.println(i);
            sum = sum - dp[i + 1 + maxPts] + dp[i + 1];
            dp[i] = sum / maxPts;
        }
        
        return dp[0];
    }
}