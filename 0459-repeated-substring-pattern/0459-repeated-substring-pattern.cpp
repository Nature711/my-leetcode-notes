class Solution {
public:
    bool repeatedSubstringPattern(string s) {
        for (int len = 1; len <= s.length() / 2; len++) {
            if (isMadeOfPattern(s.substr(len, s.length() - len + 1), s.substr(0, len))) return true;
        }
        return false;
    }
    
    bool isMadeOfPattern(string s, string pattern) {
        //cout << "s " << s << " pattern " << pattern << endl;
        int n = pattern.length();
        if (s.length() % n != 0) return false;
        for (int i = 0; i < s.length(); i = i + n) {
            if (s.substr(i, n) != pattern) return false;
        }
        return true;
    }
};