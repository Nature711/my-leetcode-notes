class Solution {
    int[][] grids;
    int m, n;
    public int closedIsland(int[][] grid) {
        grids = grid;
        
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grids[i][j] == 0) {
                    if (dfs(i, j)) count++;
                }
            }
        }
        
        return count;
    }
    
    public boolean dfs(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) return false;
        if (grids[i][j] == 1) return true;
        grids[i][j] = 1;
        
        boolean up = dfs(i - 1, j);
        boolean down = dfs(i + 1, j);
        boolean left = dfs(i, j - 1);
        boolean right = dfs(i, j + 1);
        
        return up && down && left && right;
    }
}
