class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        
        for (int i = 0; i < n; i++) {
            int min = nums[i] == 0 ? -1 : 0;
            if (dp[i] == false) break;
            for (int j = nums[i]; j > min; j--) {
                if (i + j == n - 1) return true;
                if (i + j < n) dp[i + j] = true;
            }
        }
        return dp[n - 1];
    }
    
}