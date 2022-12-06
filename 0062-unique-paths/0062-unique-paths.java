class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n]; //dp[i][j] == no of unique paths to reach i, j, starting from (0,0)
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] //reach current point by moving down
                          + dp[i][j - 1]; //reach current point by moving right
            }
        }
        return dp[m - 1][n - 1];
    }
}