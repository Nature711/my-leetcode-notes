class Solution {
    int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
    char[][] globalGrid;
    int m, n;
    public int numIslands(char[][] grid) {
        globalGrid = grid;
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void dfs(int r, int c) {
        globalGrid[r][c] = '0';
        for (int[] direction: directions) {
            int nextR = r + direction[0];
            int nextC = c + direction[1];
            if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && globalGrid[nextR][nextC] != '0') {
              dfs(nextR, nextC);
            }
        }
    }
}