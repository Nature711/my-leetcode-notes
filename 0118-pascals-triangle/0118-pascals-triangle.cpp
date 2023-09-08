class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> res;
        res.push_back({1});
        
        for (int i = 2; i <= numRows; i++) {
            vector<int> curr_row(i);
            curr_row[0] = 1;
            curr_row[i - 1] = 1;
            vector<int>& prev_row = res[i - 2];
            for (int j = 1; j < i - 1; j++) {
                curr_row[j] = prev_row[j - 1] + prev_row[j];
            }
            res.push_back(curr_row);
        }
        
        return res;
    }
};