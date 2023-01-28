class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = matrix[i][n - 1] == '1' ? 1 : 0; //last column
            max = Math.max(dp[i][n - 1], max);
        }
        for (int j = 0; j < n; j++) {
            dp[m - 1][j] = matrix[m - 1][j] == '1' ? 1 : 0; //last row
            max = Math.max(dp[m - 1][j], max);
        }
        
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i][j + 1], 
                                            Math.min(dp[i + 1][j], dp[i + 1][j + 1]));
                    max = Math.max(dp[i][j], max);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        
        return max * max;
    }
}