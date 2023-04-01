class Solution {
    Integer[][][] dp;
    int[][] grid;
    int R, C;
    int mod = 1000000007;
    public int ways(String[] pizza, int k) {
        R = pizza.length;
        C = pizza[0].length();
        dp = new Integer[R][C][k + 1];
        grid = new int[R][C];
    
        for (int i = 0; i < R; i++) {
            String p = pizza[i];
            for (int j = 0; j < C; j++) {
                if (p.charAt(j) == 'A') grid[i][j] = 1;
            }
        }
        
        return helper(0, 0, k);
        
    }
    
    public int helper(int r, int c, int k) {
        
        if (dp[r][c][k] != null) return dp[r][c][k];
        
        if (k == 1) {
            dp[r][c][k] = hasApple(r, R - 1, c, C - 1) ? 1 : 0;
            return dp[r][c][k];
        }
        
        int count = 0;
        for (int i = r; i < R - 1; i++) {
            if (hasApple(r, i, c, C - 1)) count = (count + helper(i + 1, c, k - 1)) % mod;
        }
        for (int j = c; j < C - 1; j++) {
            if (hasApple(r, R - 1, c, j)) count = (count + helper(r, j + 1, k - 1)) % mod;
        }
     
        dp[r][c][k] = count;
        return count;
    }
    
    public boolean hasApple(int rs, int re, int cs, int ce) {
        for (int i = rs; i <= re; i++) {
            for (int j = cs; j <= ce; j++) {
                if (grid[i][j] == 1) return true;
            }
        }
        return false;
    }
    
    
}