class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        dp[n - 1] = grid[m - 1][n - 1];
        
        for (int j = n - 2; j >= 0; j--) dp[j] = dp[j + 1] + grid[m - 1][j];
            
        for (int i = m - 2; i >= 0; i--) {
            dp[n - 1] = dp[n - 1] + grid[i][n - 1];
            for (int j = n - 2; j >= 0; j--) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + grid[i][j];
            }
        }
        
        return dp[0];
    }
}