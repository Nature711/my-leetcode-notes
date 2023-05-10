class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int total = n * n;
        int up = 0, down = n - 1, left = 0, right = n - 1;
        int curr = 1;
        while (true) {
            for (int i = left; i <= right; i++) matrix[up][i] = curr++;
            up++;
            if (up > down) break;
            for (int i = up; i <= down; i++) matrix[i][right] = curr++;
            right--;
            if (right < left) break;
            for (int i = right; i >= left; i--) matrix[down][i] = curr++;
            down--;
            if (up > down) break;
            for (int i = down; i >= up; i--) matrix[i][left] = curr++;
            left++;
            if (right < left) break;
        }
        
        return matrix;
    }
}