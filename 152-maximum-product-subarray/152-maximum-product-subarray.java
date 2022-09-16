class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        
        int max = nums[0];
        
        for (int i = 1; i < n; i++) {
            
            dp[i][0] = Math.max(dp[i - 1][0] * nums[i], Math.max(dp[i - 1][1] * nums[i], nums[i]));
            dp[i][1] = Math.min(dp[i - 1][0] * nums[i], Math.min(dp[i - 1][1] * nums[i], nums[i]));
            
            max = Math.max(dp[i][0], Math.max(dp[i][1], max));
            
        }
        return max;
    }
}