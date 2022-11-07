class Solution {
    public int minCost(int[][] costs) {
        //0 for red, 1 for blue, 2 for green
        int n = costs.length;
        int[][] dp = new int[n][3]; 
        //dp[i][j]: min cost to paint houses 0...i, where the i-th house is painted in color j
     
        for (int color = 0; color < 3; color++) {
            dp[0][color] = costs[0][color];
        }
        
        for (int i = 1; i < n; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }
        
        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }
}