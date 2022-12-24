class Solution {

    public boolean canPartition(int[] nums) {

        int n = nums.length;
        int sum = 0;
        for (int num: nums) sum += num;
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        
        boolean[][] dp = new boolean[n + 1][target + 1]; 
        //dp[i][j] = whether we can form a subset sum of j using elements from 0...i
        for (int i = 0; i <= target; i++) dp[0][i] = false;
        for (int i = 0; i <= n; i++) dp[i][0] = true;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                int rem = j - nums[i - 1];
                dp[i][j] = dp[i - 1][j] || (rem < 0 ? false : dp[i - 1][rem]);
       
            }
        }
  
        return dp[n][target];
    }
    
}