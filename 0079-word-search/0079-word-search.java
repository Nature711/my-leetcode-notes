class Solution {
   boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, 0, word)) return true;
            }
        }
        return false;
    }
    
    
    public boolean dfs(char[][] board, int i, int j, int wordIdx, String word) {
        if (wordIdx == word.length()) return true;
        
        if (i < 0 || i == board.length || j < 0 || j == board[0].length 
            || visited[i][j] || word.charAt(wordIdx) != board[i][j]) return false;
        
        visited[i][j] = true;
        
        if (dfs(board, i + 1, j, wordIdx + 1, word)) return true;
        if (dfs(board, i, j + 1, wordIdx + 1, word)) return true;
        if (dfs(board, i - 1, j, wordIdx + 1, word)) return true;
        if (dfs(board, i, j - 1, wordIdx + 1, word)) return true;
        
        visited[i][j] = false;
        
        return false;
    }
}