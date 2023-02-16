class Solution {
    public String longestPalindrome(String s) {
        int n = s.length(), maxLen = 1, maxI = 0, maxJ = 0;
        boolean[][] dp = new boolean[n][n];
        
        for (int i = 0; i < n; i++) dp[i][i] = true;
        
        for (int i = n; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1) dp[i][j] = true;
                    else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    if (dp[i][j] && (j - i + 1) >= maxLen) {
                        maxLen = j - i + 1;
                        maxI = i;
                        maxJ = j;
                    }
                }
            }
        }
        
        return s.substring(maxI, maxJ + 1);
    }
    
    
}
