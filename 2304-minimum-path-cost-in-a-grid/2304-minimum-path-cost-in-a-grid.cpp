class Solution {
public:
    int minPathCost(vector<vector<int>>& grid, vector<vector<int>>& moveCost) {
        int m = grid.size(), n = grid[0].size();
        //vector<vector<int>> dp(m, vector<int>(n, INT_MAX));
        vector<int> dp(n, INT_MAX);
        for (int i = 0; i < n; i++) dp[i] = grid[0][i];
        
        for (int i = 1; i < m; i++) {
            vector<int> tmp = dp;
            for (int i = 0; i < n; i++) dp[i] = INT_MAX;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[j] = min(dp[j], tmp[k] + moveCost[grid[i - 1][k]][j]);
                }
                dp[j] += grid[i][j];
            }
        }
        int res = INT_MAX;
        for (int i = 0; i < n; i++) res = min(res, dp[i]);
        return res;
    }
};