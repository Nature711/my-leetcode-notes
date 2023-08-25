class Solution {
public:
    bool validTree(int n, vector<vector<int>>& edges) {
        if (n != edges.size() + 1) return false;
        
        unordered_map<int, unordered_set<int>> graph;
        for (vector<int>& edge: edges) {
            if (graph.find(edge[0]) == graph.end()) graph[edge[0]] = {};
            graph[edge[0]].insert(edge[1]);
            if (graph.find(edge[1]) == graph.end()) graph[edge[1]] = {};
            graph[edge[1]].insert(edge[0]);
        }
        
        unordered_set<int> visited;
        visited.insert(0);
        bool res = dfs(0, -1, visited, graph);
        return res && visited.size() == n;
    }
    
    bool dfs(int curr, int parent, unordered_set<int>& visited, unordered_map<int, unordered_set<int>>& graph) {
        if (graph.find(curr) == graph.end()) return true;
        unordered_set<int> neighbors = graph[curr];
      
        for (int neighbor: neighbors) {
            if (neighbor == parent) continue;
            if (visited.find(neighbor) != visited.end()) return false;
            else {
                visited.insert(neighbor);
                if (!dfs(neighbor, curr, visited, graph)) return false;
            }
        }
        return true;
    }
};