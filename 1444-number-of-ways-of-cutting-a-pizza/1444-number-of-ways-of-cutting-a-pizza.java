class Solution {
    Integer[][][] memo;
    int[][] grid;
    int r, c;
    public int ways(String[] pizza, int k) {
        r = pizza.length;
        c = pizza[0].length();
        memo = new Integer[r][c][k + 1];
        grid = new int[r][c];
    
        for (int i = 0; i < r; i++) {
            String p = pizza[i];
            for (int j = 0; j < c; j++) {
                if (p.charAt(j) == 'A') grid[i][j] = 1;
            }
        }
        
        return helper(0,0,k);
        
    }
    
    private boolean hasApple(int i, int j, int ii, int jj) {
        for (int r = i; r <= ii; r++) {
            for (int c = j; c <= jj; c++) {
                if (grid[r][c] == 1) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private int helper(int i, int j, int k) {
        if (memo[i][j][k] != null) {
            return memo[i][j][k];
        }
        
        if (k == 1) {
            if (hasApple(i, j, r-1, c-1)) {
                memo[i][j][k] = 1;
            } else {
                memo[i][j][k] = 0;
            }
            return memo[i][j][k];
        }
        
        int ways = 0;
        for (int ii = i; ii < r-1; ii++) {
            if (hasApple(i, j, ii, c-1)) {
                ways = (ways + helper(ii+1, j, k-1)) % 1_000_000_007;
            }
        }
        for (int jj = j; jj < c-1; jj++) {
            if (hasApple(i, j, r-1, jj)) {
                ways = (ways + helper(i, jj+1, k-1)) % 1_000_000_007;
            }
        }
        
        memo[i][j][k] = ways;
        return ways;
    }
    
    
}