class Solution {
public:
    bool leadsToDestination(int n, vector<vector<int>>& edges, int source, int destination) {
        unordered_map<int, vector<int>> graph;
        for (vector<int>& edge: edges) {
            if (graph.find(edge[0]) == graph.end()) graph[edge[0]] = {};
            graph[edge[0]].push_back(edge[1]);
        }
        if (graph.find(destination) != graph.end()) return false;
        vector<int> states(n, 0);
        states[source] = 1;
        dfs(source, destination, graph, states);
        return states[source] == 2;
    }
    
    
    void dfs(int curr, int destination, unordered_map<int, vector<int>>& graph, vector<int>& states) {
        if (curr == destination) {
            states[curr] = 2;
            return;
        }
        if (graph.find(curr) == graph.end()) return;
        
        vector<int>& neighbors = graph[curr];
        for (int neighbor: neighbors) {
            if (states[neighbor] == 2) continue;
            if (states[neighbor] == 1) return;
            states[neighbor] = 1;
            dfs(neighbor, destination, graph, states);
            if (states[neighbor] != 2) return;
        }
        states[curr] = 2;
    }
};