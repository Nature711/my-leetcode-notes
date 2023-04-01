class NumMatrix {
    int[][] memo;

    public NumMatrix(int[][] matrix) {
        int R = matrix.length, C = matrix[0].length;
        memo = new int[R + 1][C + 1];
        
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                memo[i][j] = matrix[i - 1][j - 1] + memo[i - 1][j] + memo[i][j - 1] - memo[i - 1][j - 1];
                //System.out.println("memo i " + i + " j " + j + " " + memo[i][j]);
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return memo[row2 + 1][col2 + 1] - memo[row1][col2 + 1] - memo[row2 + 1][col1] + memo[row1][col1];
    }

}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */