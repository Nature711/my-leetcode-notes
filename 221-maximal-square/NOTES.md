```
 public int maximalSquare(char[][] matrix) {
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        
        for (int i = 0; i < m; i++) dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
        for (int i = 0; i < n; i++) dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    ***dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;***
                } 
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
         
                max = Math.max(max, dp[i][j]);
            }
        }
        
        return max * max;
    }
}
```
When determining dp[i][j]: 
- need to look at dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]
- should take the min among them, since dp[i][j] is upper bounded by the min

![image](https://user-images.githubusercontent.com/77217430/187073666-f507e157-5d5a-42bf-a081-51f0aeae144a.png)
