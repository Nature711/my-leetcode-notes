class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[][] dp = new int[n + 1][2];
        dp[n][0] = 0;
        dp[n][1] = 0;
        for (int i = 0; i < n; i++) {
            dp[i][0] = Integer.MIN_VALUE;
            dp[i][1] = Integer.MAX_VALUE;
        }
        
        for (int i = n - 1; i >= 0; i--) {
            int currScoreAlice = 0, currScoreBob = 0;
            for (int j = 0; j < 3; j++) {
                if (i + j >= n) break;
                currScoreAlice += stoneValue[i + j];
                currScoreBob -= stoneValue[i + j];
                dp[i][0] = Math.max(dp[i][0], 
                                    dp[Math.min(n, i + j + 1)][1] + currScoreAlice);
                dp[i][1] = Math.min(dp[i][1],
                                    dp[Math.min(n, i + j + 1)][0] + currScoreBob);
            }
           // System.out.println("Start " + i + " Alice " + dp[i][0] + " Bob " + dp[i][1]);
            
        }
        
        int res = dp[0][0];
        if (res > 0) return "Alice";
        else if (res < 0) return "Bob";
        else return "Tie";
    }
   
    
    
}