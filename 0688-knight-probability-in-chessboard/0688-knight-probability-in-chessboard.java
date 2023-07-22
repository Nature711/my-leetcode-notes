class Solution {
    int[][] directions = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};

    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[n][n][k + 1];
        return findProbability(n, k, row, column, dp);
    }

    public double findProbability(int n, int k, int r, int c, double[][][] dp) {
        if (r < 0 || r >= n || c < 0 || c >= n)
            return 0.0;

        if (k == 0)
            return 1.0;

        if (dp[r][c][k] != 0)
            return dp[r][c][k];

        double probability = 0.0;
        for (int[] direction : directions) {
            int nextR = r + direction[0];
            int nextC = c + direction[1];
            probability += 0.125 * findProbability(n, k - 1, nextR, nextC, dp);
        }

        dp[r][c][k] = probability;
        return probability;
    }
}
