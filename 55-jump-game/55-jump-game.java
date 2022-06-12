class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        // dp[0] = true;
        
        // for (int i = 1; i < n; i++) {
        //     for (int j = 0; j < i; j++) {
        //         if (dp[j] && (nums[j] >= i - j)) {
        //             dp[i] = true;
        //             break;
        //         }
        //     }
        // }
        
        dp[n - 1] = true;
        
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < n && dp[i + j]) dp[i] = true;
            }
        }
        
        
        return dp[0];
    }
    
}