class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n + 1]; //if subarray nums[i...n-1] is valid partition
        
        dp[n] = true;
        dp[n - 1] = false;
   
        for (int i = n - 2; i >= 0; i--) {
            int diff1 = nums[i + 1] - nums[i];
            if (diff1 == 0) dp[i] = dp[i + 2];
            
            if (i + 2 < n) {
                int diff2 = nums[i + 2] - nums[i + 1];
                if ((diff1 == 0 && diff2 == 0) || (diff1 == 1 && diff2 == 1)) {
                    dp[i] |= dp[i + 3];
                }
            }
            
        }
        
        return dp[0];
    }
   
}