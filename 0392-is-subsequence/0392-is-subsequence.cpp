class Solution {
public:
    bool isSubsequence(string s, string t) {
        int ti = 0;
        for (int si = 0; si < s.size(); si++) {
            
            while (ti < t.size() && t[ti] != s[si]) {
          
                ti++;
            }
            if (ti == t.size() && si < s.size()) {

                return false;
            }
            ti++;
        }
        return true;
    }
};