class Solution {
    char[][] matrix;
    int m, n;
    String target;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        target = word;
        matrix = board;
        for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
              if (board[i][j] == word.charAt(0)) {
                  boolean res = dfs(i, j, new boolean[m][n], 0);
                  if (res) return true;
              }
          }
        }
        return false;
    }
    
    public boolean dfs(int i, int j, boolean[][] visited, int idx) {
        if (idx == target.length()) return true;
        if (i < 0 || i == m || j < 0 || j == n 
            || visited[i][j] || matrix[i][j] != target.charAt(idx)) return false;
        
        visited[i][j] = true;
        
        if (dfs(i + 1, j, visited, idx + 1)) return true;
        if (dfs(i, j + 1, visited, idx + 1)) return true;
        if (dfs(i - 1, j, visited, idx + 1)) return true;
        if (dfs(i, j - 1, visited, idx + 1)) return true;
        
        visited[i][j] = false;
        
        return false;
    }
    
}