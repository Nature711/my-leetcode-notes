class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        
        if (m * n != r * c) return mat;
        
        int[][] res = new int[r][c];
        
        int idx, a, b;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                idx = n * i + j;
                a = idx / c;
                b = idx % c;
                res[a][b] = mat[i][j];
            }
        }
        
        return res;
    }
}