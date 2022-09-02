class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length]; //dp[i] = length of LCIS ending at index i
        dp[0] = 1;
        int res = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) dp[i] = dp[i - 1] + 1;
            else dp[i] = 1;
            res = Math.max(dp[i], res);
        }
        
        return res;
    }
}