class Solution {
public:
    vector<int> countBits(int n) {
        
        vector<int> dp(n + 1, 0);
        if (n == 0) return dp;
        dp[1] = 1;
        
        int i = 2;
        while (i <= n) {
            for (int j = i; j <= 2 * i - 1; j++) {
                if (j > n) break;
                dp[j] = dp[j - i] + 1;
            }
            i = i << 1;
        }
        
        return dp;
    }

};