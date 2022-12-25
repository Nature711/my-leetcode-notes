class Solution {
    public int maxProduct(int[] nums) {
        int[][] dp = new int[nums.length][2]; 
        //dp[i][0] == max product using subarray 0...i, using nums[i]
        //dp[i][1] == min product using subarray 0...i, using nums[i]
        
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int max = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                dp[i][0] = Math.max(nums[i], dp[i - 1][0] * nums[i]);
                dp[i][1] = Math.min(nums[i], dp[i - 1][1] * nums[i]);
                
            } else {
                dp[i][0] = Math.max(nums[i], dp[i - 1][1] * nums[i]);
                dp[i][1] = Math.min(nums[i], dp[i - 1][0] * nums[i]);
            }
            max = Math.max(dp[i][0], max);
        }
        return max;
    }
}