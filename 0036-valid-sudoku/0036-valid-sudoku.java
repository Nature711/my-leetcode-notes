class Solution {
    public boolean isValidSudoku(char[][] board) {
        //row check 
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !set.add(board[i][j])) return false;
            }
            set = new HashSet<>();
        }
        
        //column check
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.' && !set.add(board[j][i])) return false;
            }
            set = new HashSet<>();
        }
        
        //box check
        for (int i = 0; i < 9; i++) {
            int startRow  = 3 * (i / 3), startCol = 3 * (i % 3);
            for (int a = startRow; a < startRow + 3; a++) {
                for (int b = startCol; b < startCol + 3; b++) {
                    if (board[a][b] != '.' && !set.add(board[a][b])) return false;
                }
            }
            set = new HashSet<>();
        }
        
        return true;
    }
}