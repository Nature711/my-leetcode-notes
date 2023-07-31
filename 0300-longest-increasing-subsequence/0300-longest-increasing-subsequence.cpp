class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();
        int dp[n];
        int res = 0;
        for (int i = 0; i < n; i++) dp[i] = 0;
        for (int i = 0; i < n; i++) {
            int maxSoFar = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxSoFar = max(maxSoFar, dp[j]);
                }
            }
            dp[i] = maxSoFar + 1;
            res = max(dp[i], res);
        }
        return res;
    }
};