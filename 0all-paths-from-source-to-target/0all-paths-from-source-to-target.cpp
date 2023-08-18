class Solution {
public:
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
        vector<vector<int>> res;
        vector<int> currPath = {0};
        dfs(0, graph, currPath, res);
        return res;
    }
    
    void dfs(int curr, vector<vector<int>>& graph, vector<int>& currPath, vector<vector<int>>& res) {
        int target = graph.size() - 1;
        if (curr == target) {
            res.emplace_back(currPath);
            return;
        }
        
        for (int neighbor: graph[curr]) {
            currPath.push_back(neighbor);
            dfs(neighbor, graph, currPath, res);
            currPath.pop_back();
        }
    }
};