class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        
        int subIslands = 0;
        
        for (int i = 0; i < grid1.length; i++) {
          for (int j = 0; j < grid1[0].length; j++) {
              if (grid1[i][j] == 1) dfs1(i, j, grid1); 
          }
        }
        
        for (int i = 0; i < grid1.length; i++) {
          for (int j = 0; j < grid1[0].length; j++) {
              if (grid2[i][j] == 1) {
                  boolean res = dfs2(i, j, grid1, grid2);
                  subIslands += res ? 1 : 0;
              }
          }
        }
        
        return subIslands;
    }
    
    
    public void dfs1(int i, int j, int[][] grid) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == 0 || grid[i][j] == 2) return;

        grid[i][j] = 2; 

        dfs1(i + 1, j, grid);
        dfs1(i, j + 1, grid);
        dfs1(i - 1, j, grid);
        dfs1(i, j - 1, grid);
    }
    
    public boolean dfs2(int i, int j, int[][] grid1, int[][] grid2) {

        if (i < 0 || i == grid2.length || j < 0 || j == grid2[0].length || grid2[i][j] == 0) return true;
        
        grid2[i][j] = 0;

        
        boolean isSubIsland = grid1[i][j] == 2;
       
        isSubIsland = dfs2(i + 1, j, grid1, grid2) && isSubIsland;
        isSubIsland = dfs2(i, j + 1, grid1, grid2) && isSubIsland;
        isSubIsland = dfs2(i - 1, j, grid1, grid2) && isSubIsland;
        isSubIsland = dfs2(i, j - 1, grid1, grid2) && isSubIsland;
        
      
        
        return isSubIsland;
    }
}