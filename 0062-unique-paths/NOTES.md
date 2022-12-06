## Top down DP
![image](https://user-images.githubusercontent.com/77217430/205870350-1598fa55-e61f-433b-b24b-657d6467b7c8.png)
```
 public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n]; //dp[i][j] == no of unique paths to reach i, j, starting from (0,0)
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] //reach current point by moving down
                          + dp[i][j - 1]; //reach current point by moving right
            }
        }
        return dp[m - 1][n - 1];
    }
```

## Bottom up DP
- reverse the direction 

```
 public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n]; //dp[i][j] == no of unique paths to reach (m - 1, n - 1), starting from (0,0)
        for (int i = 0; i < m; i++) dp[i][n - 1] = 1;
        for (int j = 0; j < n; j++) dp[m - 1][j] = 1;
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] //move down from i, j
                          + dp[i][j + 1]; //move right from i, j
            }
        }
        return dp[0][0];
    }
```
