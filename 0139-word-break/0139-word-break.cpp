class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        unordered_set<string> dict;
        for (string& s: wordDict) dict.insert(s);
        unordered_map<string, bool> memo;
        return canForm(s, dict, memo);
    }
    
    bool canForm(string& s, unordered_set<string>& dict, unordered_map<string, bool>& memo) {
        if (s.length() == 0 || dict.find(s) != dict.end()) return true;
        if (memo.find(s) != memo.end()) return memo[s];
        
        for (int i = 0; i < s.length(); i++) { //i is the break point
            string before = s.substr(0, i + 1);
            if (dict.find(before) != dict.end()) {
                string after = s.substr(i + 1, s.length() - i - 1);
                bool can = canForm(after, dict, memo);
                if (can) {
                    memo[s] = true;
                    return true;
                }
            }
        }
        memo[s] = false;
        return false;
    }
    
    
    
};