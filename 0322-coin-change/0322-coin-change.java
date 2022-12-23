class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        
        for (int curr_amount = 1; curr_amount <= amount; curr_amount++) {
            
            for (int denom: coins) {
                int rem = curr_amount - denom;
               
                if (rem < 0) continue;
                
                dp[curr_amount] = Math.min(dp[curr_amount], dp[rem] + 1);
                
            }
           
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }
}