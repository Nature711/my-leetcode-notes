class Solution {
    int m, n;
    int[][] matrix;
    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        matrix = grid;
        
        for (int i = 0; i < m; i++) if (matrix[i][0] == 1) dfs(i, 0);
        for (int i = 0; i < m; i++) if (matrix[i][n - 1] == 1) dfs(i, n - 1);
        for (int i = 0; i < n; i++) if (matrix[0][i] == 1) dfs(0, i);
        for (int i = 0; i < n; i++) if (matrix[m - 1][i] == 1) dfs(m - 1, i);
        
        int count = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (matrix[i][j] == 1) count++;
            }
        }
        return count;
    }
    
    public void dfs(int i, int j) {
        if (i < 0 || i == m || j < 0 || j == n || matrix[i][j] == 0) return;
        matrix[i][j] = 0;
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
    }
}