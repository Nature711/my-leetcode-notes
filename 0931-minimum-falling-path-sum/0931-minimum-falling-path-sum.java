class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] prev = new int[n];
        int[] curr = new int[n];
        for (int j = 0; j < n; j++) prev[j] = matrix[m - 1][j];
        
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                curr[j] = prev[j];
                if (j > 0) curr[j] = Math.min(curr[j], prev[j - 1]);
                if (j < n - 1) curr[j] = Math.min(curr[j], prev[j + 1]);
                curr[j] += matrix[i][j];
            }
            System.arraycopy(curr, 0, prev, 0, n);
        }
        
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) res = Math.min(res, prev[j]);
        return res;
    }
}