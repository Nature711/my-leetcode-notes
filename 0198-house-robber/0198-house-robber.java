class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        
        int[] dp = new int[nums.length]; //dp[i] == max amount of money you can rob from houses 0...i
        
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], //not robbing the current house i
                             nums[i] + dp[i - 2]);//rob the current house i);
        }
           
        return dp[nums.length - 1];
    }
}