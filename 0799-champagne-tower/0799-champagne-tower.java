class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] cups = new double[query_row + 1][query_row + 1];
        cups[0][0] = (double) poured;
        
        for (int i = 0; i < query_row; i++) { //for each row i
            for (int j = 0; j <= i; j++) { //for each cup j in row i
                double rem = Math.max(0.00, cups[i][j] - 1);
                cups[i + 1][j] += rem / 2;
                cups[i + 1][j + 1] += rem / 2;
            }
        }
        return Math.min(1.00, cups[query_row][query_glass]);
    }
}