class Solution {
    int[][] grids;
    int m, n;
    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        grids = grid;
        
        // mark top and bottom boundaries
        for (int i = 0; i < n; i++) {
            if (grids[0][i] == 0) dfs(0, i);
            if (grids[m-1][i] == 0) dfs(m-1, i);
        }
        
        // mark left and right boundaries
        for (int i = 0; i < m; i++) {
            if (grids[i][0] == 0) dfs(i, 0);
            if (grids[i][n-1] == 0) dfs(i, n-1);
        }
        
        int count = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grids[i][j] == 0) {
                    dfs(i, j); 
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public void dfs(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grids[i][j] != 0) return;
        
        grids[i][j] = 2;
        
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
    }
}
