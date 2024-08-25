class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num: nums) sum += num;
        
        if (target > sum || target < -sum) {
            // If the target is out of the possible sum range, there are no solutions
            return 0;
        }
        
        int n = nums.length, range = sum * 2 + 1;
        int[][] dp = new int[n + 1][range];
        dp[0][sum] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < range; j++) {
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                } 
                if (j + nums[i - 1] < range) {
                    dp[i][j] += dp[i - 1][j + nums[i - 1]];
                }
            }
        }
        
        return dp[n][target + sum]; 
    }
}