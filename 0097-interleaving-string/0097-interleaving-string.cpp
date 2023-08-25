class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
        int m = s1.size(), n = s2.size();
        vector<vector<int>> memo(m + 1, vector<int>(n + 1, 0));
        backtrack(s1, s2, s3, 0, 0, memo);
        return memo[m][n] == 1 ? true : false;
    }
    
    int backtrack(string s1, string s2, string s3, int idx1, int idx2, vector<vector<int>>& memo) {
        //cout << "idx1 " << idx1 << " idx2 " << idx2  << endl;
        int idx3 = idx1 + idx2;
        
        if (memo[idx1][idx2] > 0) return memo[idx1][idx2];
        
        if (idx3 == s3.size()) {
            if (idx1 == s1.size() && idx2 == s2.size()) {
                memo[idx1][idx2] = 1;
                return 1;
            } else {
                memo[idx1][idx2] = 2;
                return 2;
            }
        }
        
        if (s1[idx1] == s3[idx3]) {
            int res1 = backtrack(s1, s2, s3, idx1 + 1, idx2, memo);
            if (res1 == 1) {
                memo[idx1][idx2] = 1;
                return 1;
            }
        }
            
        if (s2[idx2] == s3[idx3]) {
            int res2 = backtrack(s1, s2, s3, idx1, idx2 + 1, memo);
            if (res2 == 1) {
                memo[idx1][idx2] = 1;
                return 1;
            }
        }
        
        memo[idx1][idx2] = 2;
        return 2;
    }
};
