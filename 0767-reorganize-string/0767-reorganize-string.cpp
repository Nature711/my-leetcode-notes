class Solution {
public:
    string reorganizeString(string& s) {
        int n = s.size(), k = (n >> 1) + (n & 1);
        pair<int, char> counter[26]{};
        for (int i = 0; i < 26; ++i) counter[i].second = 'a' + i;
        for (char c : s) if (++counter[c - 'a'].first > k) return "";
        sort(counter, counter + 26, [](auto& p1, auto& p2) { return p1.first > p2.first; });

        int idx = 0;
        string ans(n, '.');
        for (auto& p : counter) {
            while (p.first--) {
                ans[idx] = p.second;
                idx += 2;
                if (idx >= n) idx = 1;
            }
        }
        return move(ans);
    }
};