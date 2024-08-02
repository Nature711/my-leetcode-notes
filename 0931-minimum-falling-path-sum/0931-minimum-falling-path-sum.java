class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++) dp[m - 1][j] = matrix[m - 1][j];
        
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = dp[i + 1][j];
                if (j > 0) dp[i][j] = Math.min(dp[i][j], dp[i + 1][j - 1]);
                if (j < n - 1) dp[i][j] = Math.min(dp[i][j], dp[i + 1][j + 1]);
                dp[i][j] += matrix[i][j];
            }
        }
        
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) res = Math.min(res, dp[0][j]);
        return res;
    }
}