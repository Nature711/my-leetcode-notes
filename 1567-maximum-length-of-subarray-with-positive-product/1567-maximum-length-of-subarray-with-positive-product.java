class Solution {
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        
        int[][] dp = new int[n][2]; 
        //dp[i][0] = max length of subarray with positive product
        //dp[i][1] = max length of subarray with negative product
        dp[0][0] = nums[0] > 0 ? 1 : 0;
        dp[0][1] = nums[0] < 0 ? 1 : 0;
        
        int max = Math.max(dp[0][0], 0);
        
        for (int i = 1; i < n; i++) {
            
            if (nums[i] > 0) {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = dp[i - 1][1] == 0 ? 0 : dp[i - 1][1] + 1;
            } else if (nums[i] < 0) {
                dp[i][0] = dp[i - 1][1] == 0 ? 0 : dp[i - 1][1] + 1;
                dp[i][1] = dp[i - 1][0] + 1; 
            } else {
                dp[i][0] = 0;
                dp[i][1] = 0;
            }
            
            //System.out.println("i " + i + " dp[i][0] " + dp[i][0] + " dp[i][1] " + dp[i][1]);
            
            max = Math.max(max, dp[i][0]);
        }
        return max;
    }
}