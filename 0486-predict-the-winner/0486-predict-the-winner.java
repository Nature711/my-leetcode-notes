class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][][] dp = new int[n][n][2];

        // Base case: Subproblems with size 1
        for (int i = 0; i < n; i++) {
            dp[i][i][0] = nums[i]; // Player 1 score
            dp[i][i][1] = 0;       // Player 2 score
        }

        // Filling up the DP table for subproblems with increasing size
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                // Calculate the scores for both players for the current subarray
                int leftPlayer1 = nums[i] + dp[i + 1][j][1];          // Player 1 picks the leftmost element
                int leftPlayer2 = dp[i + 1][j][0];                   // Player 2 picks the leftmost element

                int rightPlayer1 = nums[j] + dp[i][j - 1][1];         // Player 1 picks the rightmost element
                int rightPlayer2 = dp[i][j - 1][0];                  // Player 2 picks the rightmost element

                // Choose the best option for Player 1 and update the DP table
                dp[i][j][0] = Math.max(leftPlayer1, rightPlayer1);

                // The remaining score goes to Player 2
                dp[i][j][1] = leftPlayer1 > rightPlayer1 ? leftPlayer2 : rightPlayer2;
            }
        }

        // dp[0][n - 1] contains the scores for both players for the entire array
        return dp[0][n - 1][0] >= dp[0][n - 1][1];
    }
}
