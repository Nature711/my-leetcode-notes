class Solution {
public:
    int minExtraChar(string s, vector<string>& dictionary) {
        unordered_set<string> dic;
        for (string& word: dictionary) dic.insert(word);
        int n = s.size();
        vector<int> dp(n + 1, n);
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {   
            for (int j = i + 1; j <= n; j++) {
                string stmp = s.substr(i, j - i);
                int add = 0;
                if (dic.find(stmp) == dic.end()) add = j - i;
                dp[i] = min(dp[i], add + dp[j]);
            }
            
        }
        return dp[0];
    }
    
   
};