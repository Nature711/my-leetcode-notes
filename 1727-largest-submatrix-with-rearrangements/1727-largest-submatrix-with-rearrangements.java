class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (matrix[i][j] == 0) matrix[i][j] = 0;
                else {
                    if (i > 0) matrix[i][j] += matrix[i - 1][j];
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            matrix[i] = Arrays.stream(matrix[i]).boxed()
                            .sorted(Collections.reverseOrder())
                            .mapToInt(Integer::intValue)
                            .toArray();
            
            for (int j = 0; j < n; j++) {
                res = Math.max(res, matrix[i][j] * (j + 1));
            }
        }
        return res;
    }
}