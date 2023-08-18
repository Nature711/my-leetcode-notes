class Solution {
public:
    int maximalNetworkRank(int n, vector<vector<int>>& roads) {
        unordered_map<int, unordered_set<int>> graph;
        for (vector<int>& road: roads) {
            if (graph.find(road[0]) == graph.end()) graph[road[0]] = {};
            graph[road[0]].insert(road[1]);
            if (graph.find(road[1]) == graph.end()) graph[road[1]] = {};
            graph[road[1]].insert(road[0]);
        }

        int maxRank = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int rankI = graph[i].size(), rankJ = graph[j].size();
                int totalRank = rankI + rankJ;
                if (graph[i].find(j) != graph[i].end()) totalRank--;
                maxRank = max(maxRank, totalRank);
            }
        }
        return maxRank;
    }
    
    
};