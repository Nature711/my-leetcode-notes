class Solution {
public:
    int findLongestChain(vector<vector<int>>& pairs) {
        sort(begin(pairs), end(pairs), [](vector<int>& p1, vector<int>& p2) { return p1[0] < p2[0]; });
        
        //for (auto& p: pairs) cout << p[0] << " " << p[1] << endl;
        int min_end = -1001, remove_count = 0;
        for (vector<int>& p: pairs) {
            if (p[0] > min_end) min_end = p[1];
            else {
                
                min_end = min(p[1], min_end);
                remove_count++;
            }
        }
        
        return pairs.size() - remove_count;
    }
};