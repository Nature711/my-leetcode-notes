class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            dp[i][0] += dp[i - 1][0] + (int) s1.charAt(i - 1);
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] += dp[0][i - 1] + (int) s2.charAt(i - 1);
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int deleteFromS1 = dp[i - 1][j] + (int) s1.charAt(i - 1);
                    int deleteFromS2 = dp[i][j - 1] + (int) s2.charAt(j - 1);
                    dp[i][j] = Math.min(deleteFromS1, deleteFromS2);
                }
            }
        }
        return dp[m][n];
    }
}