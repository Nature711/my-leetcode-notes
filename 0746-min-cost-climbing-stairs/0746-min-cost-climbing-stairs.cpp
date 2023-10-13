class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        int top = cost.size();
        int dp[top + 1];
        dp[top] = 0;
        dp[top - 1] = cost[top - 1];
        for (int i = top - 2; i >= 0; i--) {
            dp[i] = cost[i] + min(dp[i + 1], dp[i + 2]);
        }
        return min(dp[0], dp[1]);
    }
};