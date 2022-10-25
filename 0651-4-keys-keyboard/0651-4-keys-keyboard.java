class Solution {
    public int maxA(int n) {
        
        if (n <= 6) return n;
        
        int[] dp = new int[n + 1];
        
        for (int i = 0; i <= 6; i++) dp[i] = i;
        
        for (int i = 7; i <= n; i++) {
            //at least we can get i As by pressing A i times
            dp[i] = i; 
            
            //can get additional As by pressing Ctrl V 
            
            for (int j = 1; i - j - 2 > 0; j++) {
                //the number of A obtained by issuing Ctrl V j times
                dp[i] = Math.max(dp[i], (j + 1) * dp[i - j - 2]);
            }
        }
        
        return dp[n];
     }
}