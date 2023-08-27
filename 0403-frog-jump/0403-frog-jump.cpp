class Solution {
public:
    bool canCross(vector<int>& stones) {
        unordered_map<int, int> map; 
        for (int i = 0; i < stones.size(); i++) map[stones[i]] = i;
        
        unordered_map<string, bool> memo;  // Memoization table
        
        return helper(stones, 0, 1, map, memo);
    }
    
    bool helper(vector<int>& stones, int index, int step, unordered_map<int, int>& map, unordered_map<string, bool>& memo) {
        if (memo.find(to_string(index) + "#" + to_string(step)) != memo.end()) {
            return memo[to_string(index) + "#" + to_string(step)];
        }
        
        int curr = stones[index] + step;
        if (map.find(curr) == map.end()) {
            memo[to_string(index) + "#" + to_string(step)] = false;
            return false;
        }
        
        int curr_idx = map[curr];
        if (curr_idx == stones.size() - 1) {
            memo[to_string(index) + "#" + to_string(step)] = true;
            return true;
        }

        vector<int> next_steps = {step - 1, step, step + 1};
        for (int next_step: next_steps) {
            if (next_step == 0) continue;
            if (helper(stones, curr_idx, next_step, map, memo)) {
                memo[to_string(index) + "#" + to_string(step)] = true;
                return true;
            }
        }
        
        memo[to_string(index) + "#" + to_string(step)] = false;
        return false;
    }
};
