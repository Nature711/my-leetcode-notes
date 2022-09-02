class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length]; //dp[i] = length LIS ending at i
        int[] count = new int[nums.length]; //count[i] = no of LIS ending at i
        
        
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] == dp[j] + 1) {
                    count[i] += count[j];
                }
            }
            count[i] = Math.max(count[i], 1);
        }
        
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] > len) len = dp[i];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == len) res += count[i];
        }
        
        return res;
    }
    
}