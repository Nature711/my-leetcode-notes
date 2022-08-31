class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[] temp = new int[4];
    
        for (int i = 0;  i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                temp[0] = matrix[i][j];
                temp[1] = matrix[j][n - 1 - i];
                temp[2] = matrix[n - 1 - i][n - 1 - j];
                temp[3] = matrix[n - 1 - j][i];
                
                matrix[i][j] = temp[3];
                matrix[j][n - 1 - i] = temp[0];
                matrix[n - 1 - i][n - 1 - j] = temp[1];
                matrix[n - 1 - j][i] = temp[2];
            }
        }
    }
}