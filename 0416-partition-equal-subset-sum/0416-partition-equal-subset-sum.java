class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num: nums) sum += num;
        if (sum % 2 != 0) return false;
        
        int targetSum = sum / 2;
        boolean[][] dp = new boolean[n + 1][targetSum + 1]; //dp[i][j] = if we can sum up to target j using nums from idx 0 to i
        
        dp[0][0] = true;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= targetSum; j++) {
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[n][targetSum];
        
    }
}