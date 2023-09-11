class Solution {
public:
    vector<vector<int>> groupThePeople(vector<int>& groupSizes) {
        unordered_map<int, vector<int>> map;
        for (int i = 0; i < groupSizes.size(); i++) {
            int curr_size = groupSizes[i];
            if (map.count(curr_size) == 0) map[curr_size] = {};
            map[curr_size].push_back(i);
        }
        vector<vector<int>> res;
        for (auto& entry: map) {
            int grp_size = entry.first;
            vector<int>& people = entry.second;
            int num_grps = people.size() / grp_size;
            int ppl_idx = 0;
            for (int i = 0; i < num_grps; i++) {
                vector<int> grp;
                for (int j = 0; j < grp_size; j++) {
                    grp.push_back(people[ppl_idx++]);
                }
                res.push_back(grp);
            }
        }
        return res;
    }
};