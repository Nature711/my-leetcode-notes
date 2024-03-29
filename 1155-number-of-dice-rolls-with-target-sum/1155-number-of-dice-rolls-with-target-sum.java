class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1]; //dp[i][j] = no of ways to sum up to j using i dices
        
        dp[0][0] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                //use the current dice to obtain a value val 
                //use the remaining i - 1 dices to obtain (j - val) as target for subproblem
                for (int val = 1; val <= Math.min(k, j); val++) dp[i][j] = (dp[i][j] + dp[i - 1][j - val]) % (int) (Math.pow(10, 9) + 7);
            }
        }
        
        return (int) (dp[n][target] % (Math.pow(10, 9) + 7));
        
    }
}