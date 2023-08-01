class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
        vector<vector<int>> res;
        vector<int> curr;
        backtrack(1, n, k, curr, res);
        return res;
    }
    
    void backtrack(int currIdx, int n, int k, vector<int>& curr, vector<vector<int>>& res) {
        if (curr.size() == k) {
            vector<int> copy = curr; //create a copy and put it into res
            res.push_back(copy);
            //curr.erase(curr.end() - 1);
            return;
        }
        
        for (int i = currIdx; i <= n; i++) {
            curr.push_back(i);
            backtrack(i + 1, n, k, curr, res);
            curr.erase(curr.end() - 1);
        }
    }
};