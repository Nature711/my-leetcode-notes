class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) dp[m - 1][i] = matrix[m - 1][i];
        
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int currMin = dp[i + 1][j];
                if (j > 0) currMin = Math.min(currMin, dp[i + 1][j - 1]);
                if (j < n - 1) currMin = Math.min(currMin, dp[i + 1][j + 1]);
                dp[i][j] = matrix[i][j] + currMin;
            }
        }
        
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) res = Math.min(res, dp[0][i]);
        return res;
    }
}