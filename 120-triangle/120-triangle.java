class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        int currWidth = triangle.get(height - 1).size();
    
        int[][] dp = new int[height][currWidth];
        
        for (int i = 0; i < currWidth; i++) {
            dp[height - 1][i] = triangle.get(height - 1).get(i);
        }
        
        for (int i = height - 2; i >= 0; i--) {
            currWidth = i + 1;
            for (int  j = 0; j < currWidth; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        
        return dp[0][0];                         
    }

}