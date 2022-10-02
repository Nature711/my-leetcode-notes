class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(sr, sc, image[sr][sc], color, image);
        return image;
    }
    
    public void dfs(int i, int j, int srColor, int scColor, int[][] grid) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] != srColor || grid[i][j] == scColor) return;
        
        grid[i][j] = scColor;

        //searching each of the 4 directions 
        dfs(i + 1, j, srColor, scColor, grid);
        dfs(i, j + 1, srColor, scColor, grid);
        dfs(i - 1, j, srColor, scColor, grid);
        dfs(i, j - 1, srColor, scColor, grid);

        return;
    }
}