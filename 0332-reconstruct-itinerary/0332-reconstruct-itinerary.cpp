class Solution {
public:
    vector<string> findItinerary(vector<vector<string>>& tickets) {
        unordered_map<string, vector<string>> my_map;
        for (vector<string>& ticket: tickets) {
            if (my_map.find(ticket[0]) == my_map.end()) my_map[ticket[0]] = {};
            my_map[ticket[0]].emplace_back(ticket[1]);
        }
        
        for (auto& [k, v]: my_map) sort(v.begin(), v.end());
        
        int n = tickets.size();
        string start = "JFK";
        vector<string> res(n + 1);
        res[0] = "JFK";
       
        backtrack(start, 1, my_map, res);
        
        return res;
    }
    
    bool backtrack(string& start, int idx, unordered_map<string, vector<string>>& my_map, vector<string>& res) {

        if (idx == res.size()) return true;
        
        if (my_map.find(start) == my_map.end()) return false;
        
        vector<string>& neighbors = my_map[start];
        
        bool has_path = false;
        for (auto& neighbor: neighbors) { 
            if (neighbor != "") {
                res[idx] = neighbor;
                neighbor = "";
                has_path = backtrack(res[idx], idx + 1, my_map, res);
                if (has_path) break;
                else neighbor = res[idx];
            }
        }
        return has_path;
        
    }
};