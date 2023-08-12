class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        int m = obstacleGrid.size(), n = obstacleGrid[0].size();
        int dp[m][n];
        int ii = 0, jj = 0;
        while (ii < m && obstacleGrid[ii][0] == 0) {
            dp[ii][0] = 1;
            ii++;
        }
        while (ii < m) {
            dp[ii][0] = 0;
            ii++;
        }
            
        while (jj < n && obstacleGrid[0][jj] == 0) {
            dp[0][jj] = 1;
            jj++;
        }
        while (jj < n) {
            dp[0][jj] = 0;
            jj++;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = 0;
            }
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    if (obstacleGrid[i - 1][j] == 0) dp[i][j] += dp[i - 1][j];
                    if (obstacleGrid[i][j - 1] == 0) dp[i][j] += dp[i][j - 1];
                }
            }
        }
        
        return dp[m - 1][n - 1];
    }
};

