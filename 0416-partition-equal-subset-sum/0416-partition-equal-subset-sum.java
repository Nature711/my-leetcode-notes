class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num: nums) sum += num;
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n][target + 1]; // dp[i][j]: true if we can use nums from [0...i] to make up j
        for (int i = 0; i < n; i++) dp[i][0] = true; // can always make up 0 by using anything
        for (int i = 1; i <= target; i++) dp[0][i] = (nums[0] == i);
    
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - nums[i] >= 0) {
                    dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];
                }
            }
            if (dp[i][target]) return true;
        }
        
        return dp[n - 1][target];
    }
}