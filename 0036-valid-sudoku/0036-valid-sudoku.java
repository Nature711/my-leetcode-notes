class Solution {
    public boolean isValidSudoku(char[][] board) {
        //row check 
        HashSet<Character> set = new HashSet<>();
        
        List<HashSet<Character>> sets = new ArrayList<>();
        
        List<HashSet<Character>> boxSets = new ArrayList<>();
        
        for (int i = 0; i < 9; i++) {
            if (i < 3) boxSets.add(new HashSet<>());
            sets.add(new HashSet<>());
        }
        
        
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!set.add(board[i][j])) return false;
                    if (!sets.get(j).add(board[i][j])) return false;
                    if (!boxSets.get(j / 3).add(board[i][j])) return false;
                }
            }
            set.clear();
            if (i % 3 == 2) for (int a = 0; a < 3; a++) boxSets.get(a).clear();
        }
        
//         //column check
//         for (int i = 0; i < 9; i++) {
//             for (int j = 0; j < 9; j++) {
//                 if (board[j][i] != '.' && !set.add(board[j][i])) return false;
//             }
//             set = new HashSet<>();
//         }
        
//        //box check
//         for (int i = 0; i < 9; i++) {
//             int startRow  = 3 * (i / 3), startCol = 3 * (i % 3);
//             for (int a = startRow; a < startRow + 3; a++) {
//                 for (int b = startCol; b < startCol + 3; b++) {
//                     if (board[a][b] != '.' && !set.add(board[a][b])) return false;
//                 }
//             }
//             set = new HashSet<>();
//         }
        
        return true;
    }
}