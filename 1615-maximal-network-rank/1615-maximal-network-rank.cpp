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
                unordered_set<int> visited;
                visited.insert(i);
                if (canReach(i, j, graph, visited)) {
                    int rankI = graph[i].size(), rankJ = graph[j].size();
                    //cout << "i " << i << " rank "<< rankI << " j " << j << " rankJ " << rankJ << endl;
                    int totalRank = rankI + rankJ;
                    if (graph[i].find(j) != graph[i].end()) totalRank--;
                    maxRank = max(maxRank, totalRank);
                }
            }
        }
        
        return maxRank;
    }
    
    bool canReach(int i, int target, unordered_map<int, unordered_set<int>>& graph, unordered_set<int>& visited) {
        return true;
//         if (i == target) return true;
//         if (graph.find(i) == graph.end()) return false;
        
//         for (int neighbor: graph[i]) {
//             if (visited.find(neighbor) == visited.end()) {
//                 visited.insert(neighbor);
//                 if (canReach(neighbor, target, graph, visited)) return true;
//             }
//         }
//         return false;
    }
    
    
    
};