class NumMatrix {
    
    int[][] grid;
    int R, C;
    int[][] prefixSums;

    public NumMatrix(int[][] matrix) {
        grid = matrix;
        R = matrix.length;
        C = matrix[0].length;
        //dp = new int[R][C];
        prefixSums = new int[R][C + 1];
        
        //compute prefixSum for each row
        for (int i = 0; i < R; i++) {
            computePrefixSum(i); 
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int r = row1; r <= row2; r++) {
            sum += prefixSums[r][col2 + 1] - prefixSums[r][col1];
        }
        return sum;
    }
    
    public void computePrefixSum(int row) {
        prefixSums[row][0] = 0;
        for (int i = 1; i <= C; i++) prefixSums[row][i] = prefixSums[row][i - 1] + grid[row][i - 1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */